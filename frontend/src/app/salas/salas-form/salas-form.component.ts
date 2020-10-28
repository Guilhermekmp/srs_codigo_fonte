import { ValueConverter } from '@angular/compiler/src/render3/view/template';
import { SalaEquipamento } from './../sala-equipamento';
import { SalasComponent } from './../salas.component';
import { EquipamentosService } from './../../equipamentos/equipamentos.service';
import { SalasService } from './../salas.service';
import { Sala } from './../sala';
import { Component, Input, OnInit, Output } from '@angular/core';
import { FormGroup, FormBuilder, FormArray, FormControl } from '@angular/forms';
import { EventEmitter } from '@angular/core';
import { debounce } from '@fullcalendar/core';

@Component({
  selector: 'app-salas-form',
  templateUrl: './salas-form.component.html',
  styleUrls: ['./salas-form.component.css']
})
export class SalasFormComponent implements OnInit {

  @Output() criarSalaEvento = new EventEmitter();  
  
  formulario: FormGroup;
  formulario2: FormGroup;

  controlDrop = new FormControl();

  equipamentos: FormArray;
  listaEquipamentosNew: SalaEquipamento[] = [];
  
  @Input() set salaId(id: number){
    if(id)  {
      this.buscarSalaPorId(id);
      console.log("ID " + id);
      this.mostrarLista = true;
      console.log(this.mostrarLista);
    }
  }

  mostrarLista: boolean = false;

  sala = new Sala();

  tiposSala: any[];

  listaEquipamentos: any[] = [];

  constructor(private formBuilder: FormBuilder, 
    private salasService: SalasService, 
    private equipamentosService: EquipamentosService,
    private salasComponent: SalasComponent ) {
      this.initForm();
      if(!this.salaId){
        this.mostrarLista = false;
      }
    }

  ngOnInit(): void {
    
    this.tiposSala = [
      {label: 'Reunião', value: 1},
      {label: 'Trabalho', value: 2},
      {label: 'Palestras', value: 3},
      {label: 'Video', value: 4},
      {label: 'Auditório', value: 5}
    ]

  this.listarEquipamentos();

  console.log("SALAID " + this.salaId);
  this.formulario2 = this.formBuilder.group({});

  this.listaEquipamentosNew.push(new SalaEquipamento());

  }

  private buscarSalaPorId(id: number){
    this.salasService.buscarSala(id).subscribe((data)=>{
      this.sala = data;
      this.atualizarForm();
      console.log(data);
      this.listaEquipamentosNew = this.sala.equipamentos;
      console.log(this.listaEquipamentosNew);
    }, err =>{
      console.log(err);
    });

  }

  atualizarForm() {
    var equipamentos = this.listaEquipamentosNew.map(e => {return { idSala: null, idEquipamento: e.idEquipamento, quantidade: e.quantidade }});

    this.formulario.get('descricao').setValue(this.sala.descricao);
    this.formulario.get('precoDiario').setValue(this.sala.precoDiario);
    this.formulario.get('capacidade').setValue(this.sala.capacidade);
    this.formulario.get('idTipoSala').setValue(this.sala.idTipoSala);
    // this.formulario.get('equipamentos').patchValue(equipamentos);

    console.log("AAAAAAAAA", this.sala);
    console.log("BBBBBBBBB", this.formulario.value);

  }

  private initForm(){
    this.formulario = this.formBuilder.group({
      descricao: new FormControl(),
      // equipamentos: new FormControl(),
      idTipoSala: new FormControl(),
      capacidade: new FormControl(),
      precoDiario: new FormControl(),
    })
  }

  criarEquipamento(){
    return this.formBuilder.group({
      idSala: null,
      idEquipamento: new FormControl(),
      quantidade: new FormControl()
    })
  }

  listarEquipamentos(){
    this.equipamentosService.listarEquipamentos().subscribe((data)=>{
      this.listaEquipamentos = data.map(e => {return { label: e.nome, value: e.id }}), err =>{
      console.log(err);
      }
    })
  }

  addEquipamento(){
    this.listaEquipamentosNew.push(new SalaEquipamento());
  }

  removerEquipamento(index: number){
    this.listaEquipamentosNew.splice(index, 1);
  }

  clear(){
    this.equipamentos.clear();
  }

  onSubmit(){
    if(this.formulario.valid){
      if(this.sala.id){
        console.log('sala editada' , this.sala);

        this.salasService.atualizarSala(this.construirObjetoSala()).subscribe(
          success => {
            console.log('PUT' + this.sala)},
          error => console.error(error),
          () => {console.log('request completo')
         debounce(this.criarSalaEvento.emit(), 2)
        });
     
      }
      else{
       console.log('nova sala', this.construirObjetoSala());
       
        this.salasService.criar(this.construirObjetoSala()).subscribe(
          success => {
            console.log('POST')},
          error => console.error(error),
          () => {console.log('request completo')
         debounce(this.criarSalaEvento.emit(), 2)
        });
     
      }
      this.formulario.reset();
      //window.location.reload();
    }
  } 

  construirObjetoSala(): Sala {
    const sala = new Sala();
    sala.id = this.sala.id? this.sala.id : null;
    sala.capacidade = this.formulario.get('capacidade').value;
    sala.descricao = this.formulario.get('descricao').value;
    sala.idTipoSala = this.formulario.get('idTipoSala').value;
    sala.precoDiario = this.formulario.get('precoDiario').value;

    sala.equipamentos = this.listaEquipamentosNew.map(item=>{
      console.log('item lista', item);
      
      if(item.idEquipamento && item.quantidade){
        return item;
      }
      });
    return sala;
  }

  alterarIdEquipamento(idEquipamento: number, index: number){
    this.listaEquipamentosNew[index].idSala = null;
    this.listaEquipamentosNew[index].idEquipamento = idEquipamento;
  }

  alterarQuantidade(quantidade: number, index: number){
    console.log(quantidade, index);
    this.listaEquipamentosNew[index].quantidade = Number(quantidade);
  }

  getNomeEquipamento(idEquipamento: number): string {
    let item = this.listaEquipamentos.find(i => i.value === idEquipamento);
    return item ? item.label : '';
  }

}

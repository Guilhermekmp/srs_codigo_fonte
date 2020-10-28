import { ValueConverter } from '@angular/compiler/src/render3/view/template';
import { SalaEquipamento } from './../sala-equipamento';
import { SalasComponent } from './../salas.component';
import { EquipamentosService } from './../../equipamentos/equipamentos.service';
import { SalasService } from './../salas.service';
import { Sala } from './../sala';
import { Component, Input, OnInit, Output } from '@angular/core';
import { FormGroup, FormBuilder, FormArray, FormControl, Validators } from '@angular/forms';
import { EventEmitter } from '@angular/core';
import { debounce } from '@fullcalendar/core';

@Component({
  selector: 'app-salas-form',
  templateUrl: './salas-form.component.html',
  styleUrls: ['./salas-form.component.css']
})
export class SalasFormComponent implements OnInit {
  
  formulario: FormGroup;
  formulario2: FormGroup;

  controlDrop = new FormControl();

  equipamentos: FormArray;
  
  listaEquipamentosNew: SalaEquipamento[] = [];
  
  @Input() set salaId(id: number){
    if(id)  {
      this.buscarSalaPorId(id);
      //console.log("ID " + id);
      this.mostrarLista = true;
      //console.log(this.mostrarLista);
    }
    else{
      this.resetarSala();
    }
  }

  listaEquipamentosAdicionados: SalaEquipamento[] = [];

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
        this.formulario.reset();
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

  //console.log("SALAID " + this.salaId);
  this.formulario2 = this.formBuilder.group({});

  // this.listaEquipamentosAdicionados.push(new SalaEquipamento());

  }

  private buscarSalaPorId(id: number){
    this.salasService.buscarSala(id).subscribe((data)=>{
      this.sala = data;
      this.atualizarForm();
      //console.log(data);
      this.listaEquipamentosNew = this.sala.equipamentos;
      //console.log("EQUIPAMENTOS DA SALA", this.listaEquipamentosNew);
    }, err =>{
      //console.log(err);
    });

  }

  atualizarForm() {
    var equipamentos = this.listaEquipamentosNew.map(e => {return { idSala: null, idEquipamento: e.idEquipamento, quantidade: e.quantidade }});

    this.formulario.get('descricao').setValue(this.sala.descricao);
    this.formulario.get('precoDiario').setValue(this.sala.precoDiario);
    this.formulario.get('capacidade').setValue(this.sala.capacidade);
    this.formulario.get('idTipoSala').setValue(this.sala.idTipoSala);
    // this.formulario.get('equipamentos').patchValue(equipamentos);

    //console.log("VALOR DA SALA", this.sala);
    //console.log("VALOR DO FORMULARIO", this.formulario.value);

  }

  private initForm(){
    this.formulario = this.formBuilder.group({
      descricao: [null, Validators.required],
      // equipamentos: new FormControl(),
      idTipoSala: [null, Validators.required],
      capacidade: [null, [Validators.required, Validators.min(0)]],
      precoDiario: [null, [Validators.required, Validators.min(0)]],
    })
  }

  criarEquipamento(){
    return this.formBuilder.group({
      idSala: null,
      idEquipamento: new FormControl(),
      quantidade: new FormControl()
    })
  }

  //Funções que usam listaEquipamentos
  listarEquipamentos(){
    this.equipamentosService.listarEquipamentos().subscribe((data)=>{
      this.listaEquipamentos = data.map(e => {return { label: e.nome, value: e.id }}), err =>{
      //console.log(err);
      }
    })
  }

  getNomeEquipamento(idEquipamento: number): string {
    let item = this.listaEquipamentos.find(i => i.value === idEquipamento);
    return item ? item.label : '';
  }

  /* ListaEquipamentosNew é a lista dos equipamentos que já estavam adicionados 
  * na sala. Unicamente utilizada no formulário de editar.
  * 
  * ListaEquipamentosAdicionados é a lista dos novos equipamentos a serem 
  * adicionados. Usada tanto em Nova Sala quanto em Editar.
  * 
  * Há uma junção (concatenação) das duas listas quando o formulário 
  * for submetido.
  */

  //Funções que usam listaEquipamentosNew
  alterarIdEquipamento(idEquipamento: number, index: number){
    this.listaEquipamentosNew[index].idSala = null;
    this.listaEquipamentosNew[index].idEquipamento = idEquipamento;
  }

  removerEquipamento(index: number){
    this.listaEquipamentosNew.splice(index, 1);
  }

  alterarQuantidade(quantidade: number, index: number){
    //console.log(quantidade, index);
    this.listaEquipamentosNew[index].quantidade = Number(quantidade);
  }

  removerTodosEquipamentos(){
    this.listaEquipamentosNew = [];
  }

  //Funções que usam listaEquipamentosAdicionados
  addEquipamento(){
    this.listaEquipamentosAdicionados.push(new SalaEquipamento());
  }

  alterarIdEquipamentoAdicionado(idEquipamento: number, index: number){
    this.listaEquipamentosAdicionados[index].idSala = null;
    this.listaEquipamentosAdicionados[index].idEquipamento = idEquipamento;
  }

  removerEquipamentoAdicionado(index: number){
    this.listaEquipamentosAdicionados.splice(index, 1);
  }

  alterarQuantidadeAdicionado(quantidade: number, index: number){
    //console.log(quantidade, index);
    this.listaEquipamentosAdicionados[index].quantidade = Number(quantidade);
  }

  juntarListas(): SalaEquipamento[]{
    var listaCompleta :SalaEquipamento[];
    listaCompleta = this.listaEquipamentosAdicionados;
    for (let index = 0; index < this.listaEquipamentosNew.length; index++) {
       var salaEquipamento: SalaEquipamento = new SalaEquipamento(); 
       
       salaEquipamento.idSala = null;
       salaEquipamento.idEquipamento = this.listaEquipamentosNew[index].idEquipamento;
       salaEquipamento.quantidade = this.listaEquipamentosNew[index].quantidade;
       
      listaCompleta.push(salaEquipamento);
    }
    //console.log("LISTA COMPLETA", listaCompleta);
    return listaCompleta;
  }

  onSubmit(){
    if(this.formulario.valid){
      if(this.sala.id){
        // //console.log('sala editada' , this.sala);

        this.salasService.atualizarSala(this.construirObjetoSala()).subscribe(
          success => {
            this.salasComponent.throwMessageSuccess('Atualizada com sucesso!');
            window.location.reload();
            //console.log('PUT', this.sala)
          },
          error => console.error(error)
        );
        
      }
      else{
       //console.log('nova sala', this.construirObjetoSala());
       
        this.salasService.criar(this.construirObjetoSala()).subscribe(
          success => {
            this.salasComponent.throwMessageSuccess('Criada com sucesso!');
            window.location.reload();
            //console.log('POST')
          },
          error => console.error(error)
          //console.log('request completo')
        );
      }
    }
  }

  construirObjetoSala(): Sala {
    const sala = new Sala();
    sala.id = this.sala.id? this.sala.id : null;
    sala.capacidade = this.formulario.get('capacidade').value;
    sala.descricao = this.formulario.get('descricao').value;
    sala.idTipoSala = this.formulario.get('idTipoSala').value;
    sala.precoDiario = this.formulario.get('precoDiario').value;

    sala.equipamentos = this.juntarListas()
    .map(item=>{
      //console.log('item lista', item);
      
      if(item.idEquipamento && item.quantidade){
        return item;
      }
      });
    //console.log("EQUIPAMENTOS SALA EDITADA", sala.equipamentos);
    return sala;
  }

  resetarSala(){
    this.sala.id = null;
    this.sala.descricao = null;
    this.sala.capacidade = null;
    this.sala.idTipoSala = null;
    this.sala.precoDiario = null;

    this.removerTodosEquipamentos();
  }

}

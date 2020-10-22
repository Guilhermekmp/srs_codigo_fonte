import { SalasComponent } from './../salas.component';
import { EquipamentosService } from './../../equipamentos/equipamentos.service';
import { SalasService } from './../salas.service';
import { Sala } from './../sala';
import { Component, OnInit, Output } from '@angular/core';
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

  equipamentos: FormArray;

  salaId: number;

  tiposSala: any[];

  listaEquipamentos: any[];

  constructor(private formBuilder: FormBuilder, 
    private salasService: SalasService, 
    private equipamentosService: EquipamentosService,
    private salasComponent: SalasComponent ) {}

  ngOnInit(): void {
    
    this.tiposSala = [
      {label: 'Reunião', value: 1},
      {label: 'Trabalho', value: 2},
      {label: 'Palestras', value: 3},
      {label: 'Video', value: 4},
      {label: 'Auditório', value: 5}
    ]

  this.initForm();
  this.listarEquipamentos();
  }

  private initForm(){
    this.formulario = this.formBuilder.group({
      descricao: new FormControl(),
      equipamentos: this.formBuilder.array([this.criarEquipamento()]),
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
      this.listaEquipamentos = data.map(e => {return { label: e.nome, value: e.id, preco: e.precoDiario}}), err =>{
      console.log(err);
      }
    })
  }

  addEquipamento(){
    this.equipamentos = this.formulario.get('equipamentos') as FormArray;
    this.equipamentos.push(this.criarEquipamento());
  }

  removerEquipamento(index: number){
    this.equipamentos.removeAt(index);
  }

  clear(){
    this.equipamentos.clear();
  }

  onSubmit(){
    if(this.formulario.valid){
      if(this.salaId){
    var sala = this.formulario.getRawValue();
    sala.id = this.salaId;
    this.salasService.atualizarSala(sala).subscribe(
      success => {
      alert("Cadastrada com sucesso")
      this.criarSalaEvento.emit();
      this.formulario.reset();
      },
      error => {alert(error.message)
      })
    }
    else{
      const sala: Sala = {
        ...this.formulario.value,
      }
      this.salasService.criar(sala).subscribe(
        success => {
          console.log('sucesso')},
        error => console.error(error),
        () => {console.log('request completo')
       debounce(this.criarSalaEvento.emit(), 2)
      });
   
    this.formulario.reset();
    }
  } 
  }
}

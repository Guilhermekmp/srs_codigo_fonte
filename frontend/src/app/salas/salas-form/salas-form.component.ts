import { SalasComponent } from './../salas.component';
import { EquipamentosService } from './../../equipamentos/equipamentos.service';
import { SalasService } from './../salas.service';
import { Sala } from './../sala';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormArray, FormControl } from '@angular/forms';

@Component({
  selector: 'app-salas-form',
  templateUrl: './salas-form.component.html',
  styleUrls: ['./salas-form.component.css']
})
export class SalasFormComponent implements OnInit {

  formulario: FormGroup;

  equipamentos: FormArray;

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
      {label: 'Auditórtio', value: 5}
    ]

      this.initForm();

  }

  private initForm(){
    this.formulario = this.formBuilder.group({
      descricao: null,
      equipamentos: this.formBuilder.array([this.criarEquipamento()]),
      idTipoSala: 1,
      capacidade: 0,
      precoDiario: 0.00,
      disponivel: 1,
    })
  }

  criarEquipamento(){
    return this.formBuilder.group({
      idSala: null,
      idEquipamento: 1,
      quantidade: 1
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
    console.log(this.formulario.value);
    if(this.formulario.valid) {
      const sala: Sala = {
        ...this.formulario.value,
      }
      this.salasComponent.listar();
      console.log(this.formulario.value.equipamentos);
      this.salasService.criar(sala).subscribe(
        success => console.log('sucesso'),
        error => console.error(error),
        () => console.log('request completo')
      );
    }
  }
}

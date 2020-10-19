import { EquipamentosService } from './../../equipamentos/equipamentos.service';
import { SalasService } from './../salas.service';
import { Sala } from './../sala';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-salas-form',
  templateUrl: './salas-form.component.html',
  styleUrls: ['./salas-form.component.css']
})
export class SalasFormComponent implements OnInit {

  formulario: FormGroup;

  tiposSala: any[];

  equipamentos: any[];

  constructor(private formBuilder: FormBuilder, private salasService: SalasService, private equipamentosService: EquipamentosService ) {}

  ngOnInit(): void {

    this.tiposSala = [
      {label: 'Reunião', value: 1},
      {label: 'Trabalho', value: 2},
      {label: 'Palestras', value: 3},
      {label: 'Video', value: 4},
      {label: 'Auditório', value: 5}
    ]

      this.equipamentosService.listarEquipamentos().subscribe((data)=>{
        this.equipamentos = data.map(e => {return { label: e.nome, value: e.id }});
        console.log(this.equipamentos);
      }, err =>{
        console.log(err);
      });

    console.log(this.tiposSala);

    this.formulario = this.formBuilder.group({
      descricao: [null],
      equipamentos: this.formBuilder.group({
        idSala: null,
        idEquipamento: 1,
        quantidade: 1
        }
      ),
      idTipoSala: [1],
      capacidade: [0],
      precoDiario: [0.00],
      disponivel: [1],
    })
  }

  onSubmit(){
    console.log(this.formulario.value);
    if(this.formulario.valid) {
      const sala: Sala = {
        ...this.formulario.value,
        equipamentos: [this.formulario.value.equipamentos]
      }
      console.log('submit');
      this.salasService.criar(sala).subscribe(
        success => console.log('sucesso'),
        error => console.error(error),
        () => console.log('request completo')
      );
    }
  }
}

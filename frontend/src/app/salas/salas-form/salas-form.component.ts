import { SalasService } from './../salas.service';
import { Equipamento } from './../../equipamentos/equipamento';
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

  constructor(private formBuilder: FormBuilder, private salasService: SalasService ) {}

  ngOnInit(): void {

    this.tiposSala = [
      {label: 'Reunião', value: 1},
      {label: 'Trabalho', value: 2},
      {label: 'Palestras', value: 3},
      {label: 'Auditório', value: 4},
  ];

    this.formulario = this.formBuilder.group({
      descricao: null,
      equipamentos: [
        {
        idSala: null,
        idEquipamento: 1,
        quantidade: 5
        }
      ],
      idTipoSala: 1,
      capacidade: 0,
      precoDiario: 0.00,
      disponivel: 1,

      // id: number;
      // nome: string;
      // idTipoEquipamento: number;
      // precoDiario: number;
      // obrigatorio: number;

      // descricao: String,
      // idTipoSala: number
      // precoDiario:number,
      // disponivel: number,
      // capacidade: number,
      // equipamentos: any[]
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

import { ClientesService } from './../../clientes/clientes.service';
import { ReservasService } from './../reservas.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Reserva } from '../reserva';

@Component({
  selector: 'app-reservas-form',
  templateUrl: './reservas-form.component.html',
  styleUrls: ['./reservas-form.component.css']
})
export class ReservasFormComponent implements OnInit {

  formulario: FormGroup;

  equipamentoOpcional: any[];

  cpf: number;

  listaCpf: number[];

  constructor(private reservasService:ReservasService, private clientesService:ClientesService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {

    this.formulario = this.formBuilder.group({
      idSala: 1,
      idCliente: 1,
      dataInicio : null,
      dataFim : null,
      total : 30000,
      equipamentos:[{
        'idReserva': null,
        'idEquipamento': 21,
        'quantidade': 5,
      }]
    })
  }

  onSubmit(){
    console.log(this.formulario.value);
      const reserva: Reserva = {
        ...this.formulario.value,
        equipamentos: [this.formulario.value.equipamentos]
      }
      console.log('submit');
      this.reservasService.salvar(reserva).subscribe(
        success => console.log('sucesso'),
        error => console.error(error),
        () => console.log('request completo')
      );
  }

  // procurarCPF(event) {
  //   this.clientesService.buscar(event.query).then(data => {
  //     this.listaCpf = data;
  //   });
  // }
}

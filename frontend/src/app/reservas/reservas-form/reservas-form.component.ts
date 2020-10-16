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

  constructor(private reservasService:ReservasService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {

    this.formulario = this.formBuilder.group({
      idSala: 1,
      idCliente: 2,
      dataInicio : null,
      dataFim : null,
      total : 30000
    }
    )
    }

    onSubmit(){
      console.log(this.formulario.value);
        const reserva: Reserva = {
          ...this.formulario.value,
        }
        console.log('submit');
        this.reservasService.salvar(reserva).subscribe(
          success => console.log('sucesso'),
          error => console.error(error),
          () => console.log('request completo')
        );
    }
  }

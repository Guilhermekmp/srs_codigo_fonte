import { ClientesService } from './../../clientes/clientes.service';
import { EquipamentosService } from './../../equipamentos/equipamentos.service';
import { SalasService } from './../../salas/salas.service';
import { ReservasComponent } from './../reservas.component';
import { ReservasService } from './../reservas.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Reserva } from '../reserva';
import { Sala } from 'src/app/salas/sala';

@Component({
  selector: 'app-reservas-form',
  templateUrl: './reservas-form.component.html',
  styleUrls: ['./reservas-form.component.css']
})
export class ReservasFormComponent implements OnInit {

  formulario: FormGroup;

  equipamentoOpcionais: any[];

  sala: Sala;

  equipamento: any[];
  salas: any[];
  clientes: any[];

  constructor(private reservasService:ReservasService, private formBuilder: FormBuilder
    ,private salasService:SalasService, private equipamentosService: EquipamentosService
    ,private clientesService:ClientesService) { }

  ngOnInit(): void {

    this.formulario = this.formBuilder.group({
      idSala: [1],
      idCliente: [2],
      dataInicio : null,
      dataFim : null,
      total : 30000
    })

    this.salasService.listarSalas().subscribe((data)=>{
      this.salas = data.map(e => {return { label: e.descricao, value: e.id }});
      console.log(this.salas);
    }, err =>{
      console.log(err);
    });

    this.clientesService.listar().subscribe((data)=>{
      this.clientes = data.map(e => {return { label: e.cpf, value: e.id }});
      console.log(this.clientes);
    }, err =>{
      console.log(err);
    });

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

  listarOpcionais(idSala:number){
    this.salasService.buscarSala(idSala).subscribe((dado) =>{
      this.sala = dado;
    }, err => {
      console.log('erro', err);
    });
    this.equipamentosService.listarEquipamentos().subscribe((dados) => {
      this.equipamento = dados;
    }, err => {
      console.log('erro', err);
    });
    for (let index = 0; index < this.equipamento.length; index++) {
      const equip = this.equipamento[index];
      var adicionar = new Boolean(true);
      var j = 0;
      for (j; j < this.sala.equipamentos.length; j++) {
        const element = this.sala.equipamentos[j];
        if(element.idEquipamento === equip.idEquipamento){
          adicionar = false;
        }
      }
      if(adicionar){
        this.equipamentoOpcionais.push(equip)
      }       
    }
  }
}
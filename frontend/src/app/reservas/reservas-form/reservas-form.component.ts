import { EquipamentoOpcional } from './../reservas-equipamento';
import { ClientesService } from './../../clientes/clientes.service';
import { EquipamentosService } from './../../equipamentos/equipamentos.service';
import { SalasService } from './../../salas/salas.service';
import { ReservasComponent } from './../reservas.component';
import { ReservasService } from './../reservas.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Reserva } from '../reserva';
import { Sala } from 'src/app/salas/sala';
import { Cliente } from 'src/app/clientes/models/cliente.interface';
import { Equipamento } from 'src/app/equipamentos/equipamento';

@Component({
  selector: 'app-reservas-form',
  templateUrl: './reservas-form.component.html',
  styleUrls: ['./reservas-form.component.css']
})
export class ReservasFormComponent implements OnInit {

  formulario: FormGroup;

  equipamentoOpcionais = [];
  EquipamentoOpcionalSelecionado: Equipamento;

  salas = [];
  salaSelecionada: Sala;

  clientes: any[];
  clienteSelecionado: Cliente;

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

  teste(val:any[]){
    console.log(val)
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
    
    var sala:Sala;
    this.salasService.buscarSala(idSala).subscribe((dado) =>{
      sala = dado;
    }, err => {
      console.log('erro', err);
    });

    console.log(sala);
    
    var equipamento = [];
    
    this.equipamentosService.listarEquipamentos().subscribe((dados) => {
      equipamento = dados;
      console.log(equipamento);
    }, err => {
      console.log('erro', err);
    });
    console.log(equipamento, "aq");
    for (let index = 0; index < equipamento.length; index++) {
      console.log("cheguei aqui")
      var equip = equipamento[index];
      var adicionar = new Boolean(true);

      for (let j = 0; j < sala.equipamentos.length; j++) {
      
        const element = sala.equipamentos[j];
        if(element.idEquipamento == equip.idEquipamento){
          adicionar = false;
        }
      }
      if(adicionar){
        this.equipamentoOpcionais.push(equip);
       }       
    }
    console.log(this.equipamentoOpcionais);
  }
}
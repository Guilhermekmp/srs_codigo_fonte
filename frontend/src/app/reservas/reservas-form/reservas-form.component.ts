import { EquipamentoOpcional } from './../reservas-equipamento';
import { ClientesService } from './../../clientes/clientes.service';
import { EquipamentosService } from './../../equipamentos/equipamentos.service';
import { SalasService } from './../../salas/salas.service';
import { ReservasComponent } from './../reservas.component';
import { ReservasService } from './../reservas.service';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Reserva } from '../reserva';
import { Sala } from 'src/app/salas/sala';
import { Cliente } from 'src/app/clientes/models/cliente.interface';
import { Equipamento } from 'src/app/equipamentos/equipamento';
import { ValueConverter } from '@angular/compiler/src/render3/view/template';

@Component({
  selector: 'app-reservas-form',
  templateUrl: './reservas-form.component.html',
  styleUrls: ['./reservas-form.component.css']
})
export class ReservasFormComponent implements OnInit {

  formulario: FormGroup;

  reserva: Reserva;

  equipamentoOpcionais = [];
  equipamentosSelecionados = [];

  salas = [];
  salaSelecionada: Sala;

  clientes: any[];
  clienteSelecionado: Cliente;

  constructor(private reservasService: ReservasService, private formBuilder: FormBuilder
    , private salasService: SalasService, private equipamentosService: EquipamentosService
    , private clientesService: ClientesService) { }

  ngOnInit(): void {

    this.initForm();

    this.listarSalas();
    this.listarClientes();

  }

  private listarClientes() {
    this.clientesService.listar().subscribe((data) => {
      this.clientes = data.map(e => { return { label: e.cpf, value: e.id } });
      console.log(this.clientes);
    }, err => {
      console.log(err);
    });
  }

  private listarSalas() {
    this.salasService.listarSalas().subscribe((data) => {
      this.salas = data.map(e => { return { label: e.descricao, value: e.id } });
      console.log(this.salas);
    }, err => {
      console.log(err);
    });
  }

  private initForm() {
    this.formulario = this.formBuilder.group({
      equipamentos: this.formBuilder.array(this.equipamentosSelecionados),
      idSala: new FormControl(),
      idCliente: new FormControl(),
      dataInicio: '2020-11-15T12:30:20',
      dataFim: '2021-01-15T12:30:20',
      total: 0
    })
  }

  addEquipamento(){
    this.formulario.value.equipamentos = this.equipamentosSelecionados
  }
  

  onSubmit() {
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

  listarOpcionais() {

    this.salasService.listarEquipamentoOpcionais(this.formulario.value.idSala).subscribe((dado) => {
      this.equipamentoOpcionais = dado.map(e => { return { label: e.nome, value: e.id } });
      console.log(this.equipamentoOpcionais, "equipamentos");

    }, err => {
      console.log('erro', err);
    });
  }

  valorTotal() {
    this.reserva = {
      ...this.formulario.value,
    }
    var lista = this.formulario.value.equipamentos;
    if(lista != null){
      this.reserva.equipamentos = []
      lista.forEach(element => {
        this.reserva.equipamentos.push(element.value);
      });
    }
    console.log(this.formulario.value);
    
    this.getTotal(this.reserva);
  }
  getTotal(reserva: Reserva) {
    console.log(reserva);
    this.reservasService.getTotal(reserva).subscribe((dado) => {
      this.formulario.patchValue({ total: dado.total });
    });
  }

  objetoEquipamento() {
    console.log(this.equipamentosSelecionados);
    this.equipamentosSelecionados.map(element => {
      var valor: EquipamentoOpcional = new EquipamentoOpcional;
      console.log(valor);
      valor.idReserva = null;
      valor.idEquipamento = element.value;
      valor.quantidade = 0;
      element.value = valor;

    });
  }

  setQuantidade(id:number,qtd:number){
    this.formulario.value.equipamentos.forEach(element => {
      if(element.value.idEquipamento === id){
        element.value.quantidade = qtd;
        console.log(element.value.quantidade);
      }
    });
    console.log(this.equipamentosSelecionados);
    
  }
}
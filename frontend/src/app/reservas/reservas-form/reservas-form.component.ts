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
  EquipamentoOpcionalSelecionado: Equipamento;
  equipamentosSelecionados = [];
  equipamentosAdicionados = [];

  equipamentos : FormArray;

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
      equipamentos: this.formBuilder.array(this.equipamentosAdicionados),
      idSala: [1],
      idCliente: [1],
      dataInicio:'2020-11-15T12:30:20',
      dataFim: '2021-01-15T12:30:20',
      total: 0
    })
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

  criarEquipamento() {
    return this.formBuilder.group({
      idReserva: null,
      idEquipamento: new FormControl,
      quantidade: new FormControl
    })
  }

  addEquipamento(){
    this.equipamentos = this.formulario.get('equipamentos') as FormArray;
    this.equipamentos.push(this.criarEquipamento());
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
      this.reserva.total = 0;
      this.getTotal(this.reserva);
      this.formulario.patchValue({total:this.reserva.total})
      console.log(this.formulario.get('total').value);
      
    }
  getTotal(reserva:Reserva){
    console.log(reserva);
    
    this.reservasService.getTotal(reserva).subscribe((dado) =>{
      console.log(dado,'novaReserva');
      this.reserva = dado;
    });
  }

  objetoEquipamento() {
    this.equipamentosAdicionados = [];
    console.log(this.equipamentosSelecionados);
    this.equipamentosSelecionados.forEach(element => {
      var valor: EquipamentoOpcional = new EquipamentoOpcional;
      console.log(valor);
      valor.idReserva = null;
      valor.idEquipamento = element.value;
      valor.quantidade = 0;
      this.equipamentosAdicionados.push({ label: element.label, value: valor });
      console.log(this.equipamentosAdicionados);
      
    });
    console.log(this.equipamentosAdicionados);
  }


  // private retirarListaEquipamento(){
  //   for (let index = 0; index < this.equipamentoOpcionais.length; index++) {
  //     const element = this.equipamentoOpcionais[index];
  //     if(element.value == this.equipamentosAdicionados.value.idEquipamento){
  //       this.equipamentoOpcionais.slice(index,1);
  //     }

  //   }
  // }
}
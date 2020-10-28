import { EquipamentoOpcional } from './../reservas-equipamento';
import { ClientesService } from './../../clientes/clientes.service';
import { EquipamentosService } from './../../equipamentos/equipamentos.service';
import { SalasService } from './../../salas/salas.service';
import { ReservasComponent } from './../reservas.component';
import { ReservasService } from './../reservas.service';
import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Reserva } from '../reserva';
import { Sala } from 'src/app/salas/sala';
import { Cliente } from 'src/app/clientes/models/cliente.interface';
import { Equipamento } from 'src/app/equipamentos/models/equipamento';
import { ValueConverter } from '@angular/compiler/src/render3/view/template';
import { debounce } from '@fullcalendar/core';

@Component({
  selector: 'app-reservas-form',
  templateUrl: './reservas-form.component.html',
  styleUrls: ['./reservas-form.component.css']
})
export class ReservasFormComponent implements OnInit {

  @Output() criarReservaEvento = new EventEmitter();

  formulario: FormGroup;
  formulario2: FormGroup;

  controlDrop = new FormControl();

  reserva = new Reserva();

  equipamentos: FormArray;
  equipamentoOpcionais = [];

  equipamentosOpcionaisAdicionados: EquipamentoOpcional[] = [];
  equipamentosOpcionaisNew: EquipamentoOpcional[] = []; 

  salas = [];
  salaSelecionada: Sala;

  clientes: any[];
  clienteSelecionado: Cliente;

  mostrarLista: boolean = false;

  @Input() set reservaId(id: number){
    if(id)  {
      this.buscarReservaPorId(id);
      console.log("ID " + id);
      this.mostrarLista = true;
      console.log(this.mostrarLista);
    }
  }

  constructor(private reservasService: ReservasService, private formBuilder: FormBuilder
    , private salasService: SalasService, private equipamentosService: EquipamentosService
    , private clientesService: ClientesService, private reservasComponent:ReservasComponent) { 
    this.initForm();
      if(!this.reservaId){
        this.mostrarLista = false;
      }
    }
  ngOnInit(): void {

    this.initForm();

    this.listarSalas();
    this.listarClientes();
    
    this.formulario2 = this.formBuilder.group({});

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

  atualizarForm() {
    var equipamentos = this.equipamentosOpcionaisNew.map(e => {return { idReserva: null, idEquipamento: e.idEquipamento, quantidade: e.quantidade }});

    this.formulario.get('idCliente').setValue(this.reserva.idCliente);
    this.formulario.get('idSala').setValue(this.reserva.idSala);
    this.formulario.get('dataInicio').setValue(this.reserva.dataInicio);
    this.formulario.get('dataFim').setValue(this.reserva.dataFim);
    this.formulario.get('total').setValue(this.reserva.total);
    // this.formulario.get('equipamentos').patchValue(equipamentos);

    console.log("AAAAAAAAA", this.reserva);
    console.log("BBBBBBBBB", this.formulario.value);

  }

  private initForm() {
    this.formulario = this.formBuilder.group({
      idSala: new FormControl(null,Validators.required),
      idCliente: new FormControl(null,Validators.required),
      dataInicio: new FormControl(null,Validators.required),
      dataFim: new FormControl(null,Validators.required),
      total: new FormControl()
    })
  }

  private buscarReservaPorId(id: number){
    this.reservasService.getByid(id).subscribe((data)=>{
      this.reserva = data;
      this.atualizarForm();
      console.log("DATA", data);
      console.log("RESERVA", this.reserva);
      this.equipamentosOpcionaisNew = this.reserva.equipamentos;
      console.log(this.equipamentosOpcionaisNew);
    }, err =>{
      console.log(err);
    });

  }

  removerEquipamento(index: number){
    this.equipamentosOpcionaisNew.splice(index, 1);
  }

  removerTodosEquipamentos(){
    this.equipamentosOpcionaisNew = [];
  }

  clear(){
    this.equipamentos.clear();
  }

  criarEquipamento(){
    return this.formBuilder.group({
      idReserva: null,
      idEquipamento: new FormControl(),
      quantidade: new FormControl()
    })
  }

  onSubmit(){
    if(this.formulario.valid){
      if(this.reserva.id){
        console.log('sala editada' , this.reserva);

        this.reservasService.atualizarReserva(this.construirObjetoReserva()).subscribe(
          success => {
            console.log('PUT' + this.reserva)
            this.reservasComponent.throwMessageSuccess('Atualizada com sucesso!');
            },
          error => console.error(error),
          () => {console.log('request completo')
         debounce(this.criarReservaEvento.emit(), 2)
        });
     
      }
      else{
       console.log('nova sala', this.construirObjetoReserva());
       
        this.reservasService.salvar(this.construirObjetoReserva()).subscribe(
          success => {
            console.log('POST')
            this.reservasComponent.throwMessageSuccess('Criada com sucesso!');
          },
          error => console.error(error),
          () => {console.log('request completo')
         debounce(this.criarReservaEvento.emit(), 2)
        });
     
      }
      this.formulario.reset();
      //window.location.reload();
    }
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
    const idReserva = this.reserva.id;
    this.reserva = {
      ...this.formulario.value,
    }
    this.reserva.id = idReserva;
    var lista = this.equipamentosOpcionaisNew;
    this.reserva.equipamentos = []
    lista.forEach(element => {
      if(element.idEquipamento != null){
        this.reserva.equipamentos.push(element);
      }
      else{
        this.reserva.equipamentos = []
      }
    });
    console.log(this.reserva,'reserva valor');
    
    this.reserva.total = 0;
    this.getTotal(this.reserva);
  }
  getTotal(reserva: Reserva) {
    console.log(reserva,'chegou aqui');
    this.reservasService.getTotal(reserva).subscribe((dado) => {
      this.formulario.patchValue({ total: dado.total });
      this.reserva.total = dado.total;
      console.log(this.reserva,'total');
      
    });
  }


  construirObjetoReserva(): Reserva {
    const reserva = new Reserva();
    reserva.id = this.reserva.id? this.reserva.id : null;
    reserva.idSala = this.formulario.get('idSala').value;
    reserva.idCliente = this.formulario.get('idCliente').value;
    reserva.dataInicio = this.formulario.get('dataInicio').value;
    reserva.dataFim = this.formulario.get('dataFim').value;
    reserva.total = this.formulario.get('total').value;

    reserva.equipamentos = this.juntarListas()
    .map(item=>{
      //console.log('item lista', item);
      
      if(item.idEquipamento && item.quantidade){
        return item;
      }
      });
    //console.log("EQUIPAMENTOS SALA EDITADA", sala.equipamentos);
    return reserva;
  }
  
  alterarIdEquipamento(idEquipamento: number, index: number){
    this.equipamentosOpcionaisNew[index].idReserva = null;
    this.equipamentosOpcionaisNew[index].idEquipamento = idEquipamento;
  }

  alterarQuantidade(quantidade: number, index: number){
    console.log(quantidade, index);
    this.equipamentosOpcionaisNew[index].quantidade = Number(quantidade);
  }

  getNomeEquipamento(idEquipamento: number): string {
    let item = this.equipamentoOpcionais.find(i => i.value === idEquipamento);
    return item ? item.label : '';
  }

  addEquipamento(){
    this.equipamentosOpcionaisAdicionados.push(new EquipamentoOpcional());
  }

  alterarIdEquipamentoAdicionado(idEquipamento: number, index: number){
    this.equipamentosOpcionaisAdicionados[index].idReserva = null;
    this.equipamentosOpcionaisAdicionados[index].idEquipamento = idEquipamento;
  }

  removerEquipamentoAdicionado(index: number){
    this.equipamentosOpcionaisAdicionados.splice(index, 1);
  }

  alterarQuantidadeAdicionado(quantidade: number, index: number){
    //console.log(quantidade, index);
    this.equipamentosOpcionaisAdicionados[index].quantidade = Number(quantidade);
  }

  juntarListas(): EquipamentoOpcional[]{
    var listaCompleta :EquipamentoOpcional[];
    listaCompleta = this.equipamentosOpcionaisAdicionados;
    for (let index = 0; index < this.equipamentosOpcionaisNew.length; index++) {
       var salaEquipamento: EquipamentoOpcional = new EquipamentoOpcional(); 
       
       salaEquipamento.idReserva = null;
       salaEquipamento.idEquipamento = this.equipamentosOpcionaisNew[index].idEquipamento;
       salaEquipamento.quantidade = this.equipamentosOpcionaisNew[index].quantidade;
       
      listaCompleta.push(salaEquipamento);
    }
    //console.log("LISTA COMPLETA", listaCompleta);
    return listaCompleta;
  }

  resetarReserva(){
    this.reserva.id = null;
    this.reserva.idSala = null;
    this.reserva.idCliente = null;
    this.reserva.dataInicio = null;
    this.reserva.dataFim = null;
    this.reserva.total = null;

    this.removerTodosEquipamentos();
  }

}
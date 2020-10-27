import { EquipamentosService } from './../equipamentos/equipamentos.service';
import { SalasService } from './../salas/salas.service';
import { Sala } from './../salas/sala';
import { ReservasService } from './reservas.service';
import { Component, OnInit } from '@angular/core';
import { ConfirmationService, SortEvent } from 'primeng';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Reserva } from './reserva';

@Component({
  selector: 'app-reservas',
  templateUrl: './reservas.component.html',
  styleUrls: ['./reservas.component.css'],
  providers: [ConfirmationService]
})
export class ReservasComponent implements OnInit {

  openPopUp: boolean = false;

  //Reservas2: any;
  //clonedReservas: { [s: string]: Reserva; } = {};

  reservas: Reserva[];
  reservaSelecionadaId: number;
  opcionais: any[];
  
  sala:Sala;
  equipamento: any[];

  constructor(
    private reservasService: ReservasService, private confirmationService:ConfirmationService,
    private salasService:SalasService, private equipamentosService: EquipamentosService){
    // private formBuilder: FormBuilder,
    // private confirmationService: ConfirmationService) {
    // this.formulario = this.formBuilder.group({
    //   sala: ['', [Validators.required]],
    //   cliente: ['', [Validators.required]], 
    //   dtIni: ['', [Validators.required]],
    //   dtFim: ['', [Validators.required]],
    //   total: ['', [Validators.required]],
    // });

  }

  ngOnInit(){
    this.listar();
    this.listarEquipamentos();
  }


  popUpOpen(){
    this.openPopUp=true;
  }

  //adicionarReserva() {
    //this.Reservas2 = this.ReservasService.adicionarReserva(this.formulario.getRawValue());
    //console.log(this.Reservas)
    //this.formulario.reset()
  //}


  listarEquipamentos(){
    this.equipamentosService.listarEquipamentos().subscribe((data)=>{
      this.equipamento = data.map(e => {return { label: e.nome, value: e.id }}), err =>{
      console.log(err);
      }
    })
  }

  getNomeEquipamento(id: number){
    let item = this.equipamento.find(i => i.value === id);
    return item ? item.label : '';
  }

  listar(){
    console.log;
    this.reservasService.getAllReservas().subscribe((dados) => {
      this.reservas = dados;
    }, err => {
      console.log('erro', err);
    })
      
  }

  deletar(id: number){
    this.confirmationService.confirm({
      message: "Tem certeza que deseja excluir esta reserva?",
      accept: () => {
        this.reservasService.deletar(id).subscribe(
          s => {
            this.listar();
          }
        )
      }
    })
  }

   criarNovaReserva(){
    this.reservaSelecionadaId = null;
    this.popUpOpen();
  }

   editar(id: number){
    this.reservaSelecionadaId = id;
    this.popUpOpen();
  }
}

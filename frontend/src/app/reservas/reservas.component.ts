import { EquipamentosService } from './../equipamentos/equipamentos.service';
import { SalasService } from './../salas/salas.service';
import { Sala } from './../salas/sala';
import { ReservasService } from './reservas.service';
import { Component, OnInit } from '@angular/core';
import { ConfirmationService, SortEvent } from 'primeng';
import { Reserva } from './reserva';

@Component({
  selector: 'app-reservas',
  templateUrl: './reservas.component.html',
  styleUrls: ['./reservas.component.css'],
  providers: [ConfirmationService]
})
export class ReservasComponent implements OnInit {

  openPopUp: boolean = false;

  reservas: Reserva[];
  reservaSelecionadaId: number;
  opcionais: any[];
  
  sala:Sala;
  equipamento: any[];

  constructor(
    private reservasService: ReservasService, private confirmationService:ConfirmationService,
    private salasService:SalasService, private equipamentosService: EquipamentosService){}

  ngOnInit(){
    this.listar();
    this.listarEquipamentos();
  }


  popUpOpen(){
    this.openPopUp=true;
  }

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

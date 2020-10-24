import { EquipamentosService } from './equipamentos.service';
import { Component, OnInit, Output, ViewChild } from '@angular/core';
import { Equipamento } from './equipamento';
import { ConfirmationService, MessageService, Message } from 'primeng';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-equipamentos',
  templateUrl: './equipamentos.component.html',
  styleUrls: ['./equipamentos.component.css'],
  providers:[ConfirmationService],
})
export class EquipamentosComponent implements OnInit {
 
  
  displayCreation:boolean = false;
  equipamentos = [];
  equipamento = new Equipamento();
  equipament: Array<Equipamento>;
  equipamentoId:number;

  constructor(private confirmationService: ConfirmationService, public equipamentosService: EquipamentosService,
    private messageService:MessageService) { 
    
  }

  ngOnInit() {
    this.listar();
  }

  getTipoEquipamento(equipamento: Equipamento): string{
    switch(equipamento.idTipoEquipamento){
      case 1:
        return "Móvel";
      case 2:
        return "Eletrodoméstico";
      case 3:
        return "Informática";
      default:
        return null;
    }
  }
  listar(){
    this.equipamentosService.listarEquipamentos().subscribe((data)=>{
      this.equipamentos = data;
      console.log(data);
    }, err =>{
      console.log(err);
      
    })
  }

  deletar(id:any){
    this.confirmationService.confirm({
      message:'Deseja mesmo deletar esse equipamento?',
      header:'Atenção',
      accept: () => {
        this.equipamentosService.deletar(id).subscribe(
          r => {
            this.listar()
          }
        )
        this.messageService.add({severity:'success', summary:'Sucesso!', detail:'Requisição efetuada com sucesso'})
      }
    })
  }

  salvar(equipamento:Equipamento){
    console.log('equipamento', this.equipamento);
    this.equipamentosService.salvar(this.equipamento).subscribe(response=>{
      this.equipamento = response;
      this.listar()
    },
    error=>
    alert("ERROR!"))
  }

  abrirPopUp(){
    this.displayCreation = true;

  }
  messagemErro(){
    this.messageService.add({severity:'error', summary:'Erro', detail:'Algo de errado aconteceu...'});
  }
  mensagemSucesso(){
    this.messageService.add({severity:'success', summary:'Sucesso', detail:'Requisição efetuada com sucesso'});
  }


}

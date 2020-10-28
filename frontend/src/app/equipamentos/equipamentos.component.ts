import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { EquipamentosService } from './equipamentos.service';
import { Component, OnInit, Output, ViewChild } from '@angular/core';
import { Equipamento } from './models/equipamento';
import { ConfirmationService, MessageService, Message } from 'primeng';

@Component({
  selector: 'app-equipamentos',
  templateUrl: './equipamentos.component.html',
  styleUrls: ['./equipamentos.component.css'],
  providers:[ConfirmationService, MessageService],
})
export class EquipamentosComponent implements OnInit {
 
  
  displayCreation:boolean = false;
  equipamentos = [];
  equipamento = new Equipamento();
  equipament: Array<Equipamento>;
  equipamentoId:number;
  formulario:FormGroup;
  tipos:TipoEquipamento[];
  tipoSelecionado:TipoEquipamento

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
    }, err =>{
      if(err.status === 500 ){
        this.throwMessageError("Algo inesperado aconteceu, tente novamente mais tarde...")
      }
    })
  }

  deletar(id:any){
    this.confirmationService.confirm({
      message:'Deseja mesmo deletar esse equipamento?',
      header:'Atenção',
      icon:'pi pi-exclamation-triangle',
      accept: () => {
        this.equipamentosService.deletar(id).subscribe(
          result=>{
            this.throwMessageSuccess('Deletado com sucesso!');
            this.listar()
          },
          error=>{
            if(error.status===500){
              this.throwMessageError('O equipamento é obrigatório em alguma sala, remova a sala antes...')
              this.listar();
            }
          }
        )
      },
      reject:() =>{
        this.throwMessageInfo('Você recusou a axclusão do equipamento');
      },
      key: 'equipamentoDel'
    },
    )}

  abrirPopUp(){
    this.displayCreation = true;
  }
  
  getTipoEquipamentoForm(equipamento:Equipamento):TipoEquipamento{
    switch(equipamento.idTipoEquipamento){
      case 1:
        return this.tipoSelecionado = {idTipoEquipamento:1, nome:"Móvel"};
      case 2:
        return this.tipoSelecionado = {idTipoEquipamento:2, nome:"Eletrodoméstico"};
      case 3:
        return this.tipoSelecionado = {idTipoEquipamento:3, nome:"Informática"};
    }
  }

  throwMessageSuccess(detail:string){
    this.messageService.add({severity:'success', summary:'Sucesso',detail:detail})
  } 

  throwMessageError(detail:string){
    this.messageService.add({severity:'error', summary:'Erro', detail:detail})
  }

  throwMessageInfo(detail:string){
    this.messageService.add({severity:'info', summary:'Aviso', detail:detail})
  }
}

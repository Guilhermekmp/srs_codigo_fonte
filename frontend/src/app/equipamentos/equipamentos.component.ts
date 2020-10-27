import { Observable } from 'rxjs';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { EquipamentosService } from './equipamentos.service';
import { Component, OnInit, Output, ViewChild } from '@angular/core';
import { Equipamento } from './models/equipamento';
import { ConfirmationService, MessageService, Message } from 'primeng';
import { EventEmitter } from '@angular/core';
import { EquipamentosFormComponent } from './equipamentos-form/equipamentos-form.component';

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
        this.throwMessageSuccess('Deletado com sucesso!')
      }
    })
  }

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
}

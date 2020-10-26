import { Observable } from 'rxjs';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { EquipamentosService } from './equipamentos.service';
import { Component, OnInit, Output, ViewChild } from '@angular/core';
import { Equipamento } from './models/equipamento';
import { ConfirmationService, MessageService, Message } from 'primeng';
import { EventEmitter } from '@angular/core';

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
    private messageService:MessageService, private formBuilder:FormBuilder) { 
    this.formulario=this.formBuilder.group({
      nome:['',[Validators.compose([Validators.required, Validators.maxLength(255)])]],
      idTipoEquipamento:['',[Validators.required]],
      precoDiario:['',[Validators.required]]
    }),
    this.tipos=[
      {nome:"Móvel", idTipoEquipamento:1},
      {nome:"Eletrodoméstico", idTipoEquipamento:2},
      {nome:"Informática", idTipoEquipamento:3}
    ]
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

  salvar(){
    if(this.formulario.valid){
      if(this.equipamentoId){
        const equipamentoComId = this.constroiObjetoEquipamento();
        equipamentoComId.id = this.equipamentoId;
        this.equipamentosService.atualizarEquipamento(equipamentoComId).subscribe(
          response=>{
            this.messageService.add({severity:'success', summary:'Sucesso', detail:'Atualizado com sucesso'});
            this.listar();
            this.formulario.reset();
          },
          error=>{
            this.messageService.add({severity:'error', summary:'Erro', detail:'Algo aconteceu de errado...'});
          }
        )
      }else{
     const equipamentoSemId = this.constroiObjetoEquipamento();
     this.equipamentosService.salvar(equipamentoSemId).subscribe(
       result=>{
         this.messageService.add({severity:'success', summary:'Sucesso',detail:'Cadastrado com sucesso!'});
        },
         error=>alert("Algo de errado aconteceu... \n Verifique os campos"),
         ()=>{
         this.listar()
        })
        this.formulario.reset();
        this.displayCreation=false;
    }
  }else{
    console.log(this.equipamentoId)
    this.messageService.add({severity:'error', summary:'Erro',detail:'Verifique os campos'});
  }
}

  atualizarEquipamento(equipamentoId:number){
    this.equipamentoId = equipamentoId
    this.abrirPopUp()
    var equipamentoAtualizar;
    this.equipamentosService.buscar(equipamentoId).subscribe(
      res => 
      this.preencheForm(res))
  }

  abrirPopUp(){
    this.displayCreation = true;
    this.formulario.reset();
  }

  preencheForm(equipamento:Equipamento){
    this.formulario.patchValue(equipamento);
    this.formulario.get('idTipoEquipamento').setValue(this.getTipoEquipamentoForm(equipamento))
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

  constroiObjetoEquipamento():Equipamento{
    var equipamento = new Equipamento();
    equipamento = this.formulario.getRawValue();
    equipamento.idTipoEquipamento = this.tipoSelecionado.idTipoEquipamento
    return equipamento;
  }

  constroiFormularioEquipamento(equipamento:Equipamento){


  }

}

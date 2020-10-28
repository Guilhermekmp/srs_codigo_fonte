import { HttpClient } from '@angular/common/http';
import { EquipamentosComponent } from './../equipamentos.component';
import { EquipamentosService } from './../equipamentos.service';
import { MessageService } from 'primeng';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Equipamento } from '../models/equipamento';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-equipamentos-form',
  templateUrl: './equipamentos-form.component.html',
  styleUrls: ['./equipamentos-form.component.css'],
  providers:[MessageService, EquipamentosService]
})
export class EquipamentosFormComponent implements OnInit {

  formulario:FormGroup;
  tipos:TipoEquipamento[];
  tipoSelecionado:TipoEquipamento;
  equipamentoId:number;

  constructor(private formBuilder:FormBuilder, private equipamentoComponent:EquipamentosComponent,
    private messageService:MessageService, private equipamentosService:EquipamentosService) { 
    this.formulario=this.formBuilder.group({
      id:[''],
      nome:['',[Validators.compose([Validators.required, Validators.maxLength(255)])]],
      idTipoEquipamento:['',[Validators.required]],
      precoDiario:['',[Validators.required]]
    }),
    this.tipos=[
      {nome:"Móvel", idTipoEquipamento:1},
      {nome:"Eletrodoméstico", idTipoEquipamento:2},
      {nome:"Informática", idTipoEquipamento:3}
    ]}

  ngOnInit(): void {
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
    equipamento.idTipoEquipamento = this.tipoSelecionado.idTipoEquipamento;
    return equipamento;
  }

  salvar(){
    if(this.formulario.valid){
      if(this.equipamentoId){
        const equipamentoComId = this.constroiObjetoEquipamento();
        equipamentoComId.id = this.equipamentoId;
        this.equipamentosService.atualizarEquipamento(equipamentoComId).subscribe(
          response=>{
            this.equipamentoComponent.throwMessageSuccess('Atualizado com Sucesso!');
            this.equipamentoComponent.listar();
            this.formulario.reset();
            this.equipamentoComponent.displayCreation=false;
            this.equipamentoId = null;
          },
          error=>{
            if(error.status===400){
              this.equipamentoComponent.throwMessageError('O equipamento já existe, verifique os equipamentos já existentes e altere o correspondente')
            }
            this.validaForm();
          }
        )
      }else{
     const equipamentoSemId = this.constroiObjetoEquipamento();
     this.equipamentosService.salvar(equipamentoSemId).subscribe(
       result=>{
         this.equipamentoComponent.throwMessageSuccess('Cadastrado com sucesso!')
        },
         error=>
         this.validaForm(),
         ()=>{
         this.equipamentoComponent.listar();
        })
        this.formulario.reset();
        this.equipamentoComponent.displayCreation=false;
    }
  }else{
    this.validaForm();
  }
}

preencheForm(equipamento:Equipamento){
  this.formulario.patchValue(equipamento);
  this.formulario.get('idTipoEquipamento').setValue(this.getTipoEquipamentoForm(equipamento));
}

resetaForm(){
  this.formulario.reset();
  this.equipamentoId = null;
}

atualizarEquipamento(equipamentoId:number){
  this.equipamentoId = equipamentoId;
  this.equipamentoComponent.abrirPopUp()
  var equipamentoAtualizar;
  this.equipamentosService.buscar(equipamentoId).subscribe(
    res => 
    this.preencheForm(res));
}

validaForm(){
  if(this.formulario.get('nome').value == null && this.formulario.get('idTipoEquipamento').value == null 
    || this.formulario.get('nome').value === "" && this.formulario.get('precoDiario').value == null){

      this.equipamentoComponent.throwMessageError('Campos vazios, insira um nome e um preço e escolha um tipo para o equipamento');

    }else if(this.formulario.get('nome').value == null || this.formulario.get('nome') == undefined 
    || this.formulario.get('nome').value === "" && this.formulario.get('idTipoEquipamento').value == null){

      this.equipamentoComponent.throwMessageError('Digite um nome e escolha o tipo para o equipamento');

    }else if(this.formulario.get('nome').value == null && this.formulario.get('precoDiario').value == null){

      this.equipamentoComponent.throwMessageError('Digite um nome e um preço para o equipamento');

    }else if(this.formulario.get('idTipoEquipamento').value == null && this.formulario.get('precoDiario').value == null){

      this.equipamentoComponent.throwMessageError('Escolha um tipo e digite um preço para o equipamento');

    }else if(this.formulario.get('nome').value == null || this.formulario.get('nome').value == undefined || this.formulario.get('nome').value == "" ){


      this.equipamentoComponent.throwMessageError('Digite um nome para o equipamento');

    }else if(this.formulario.get('idTipoEquipamento').value == null){

      this.equipamentoComponent.throwMessageError('Selecione um tipo para o equipamento');

    }else if(this.formulario.get('precoDiario').value == null){

      this.equipamentoComponent.throwMessageError('Digite um preço para o equipamento');

    }else if(this.formulario.get('precoDiario').value == 0){
      this.equipamentoComponent.throwMessageError('Digite um preço válido')
    }
}
}

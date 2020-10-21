import { EquipamentosService } from './equipamentos.service';
import { Component, OnInit } from '@angular/core';
import { style } from '@angular/animations';
import { Equipamento } from './equipamento';
import { ConfirmationService } from 'primeng';

@Component({
  selector: 'app-equipamentos',
  templateUrl: './equipamentos.component.html',
  styleUrls: ['./equipamentos.component.css'],
  providers:[ConfirmationService]
})
export class EquipamentosComponent implements OnInit {
  displayCreation:boolean = false;
  equipamentos = [];
  equipamento = new Equipamento();
  

  constructor(private confirmationService: ConfirmationService, public equipamentosService: EquipamentosService) { 
    
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
      message: 'Tem certeza que deseja excluir esse registro?',
      accept: () => {
        this.equipamentosService.deletar(id).subscribe(
          r => {
            this.listar()
          }
        )

      }
    })
  }

  salvar(){
    console.log('equipamento', this.equipamento);
    this.equipamentosService.salvar(this.equipamento).subscribe(response=>{
      this.equipamento = response;
    },
    error=>
    alert("ERROR!"))
  }

  abrirPopUp(){
    this.displayCreation = true;
  }

}


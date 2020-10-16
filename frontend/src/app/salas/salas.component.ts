import { ConfirmationService } from 'primeng';
import { EquipamentosService } from './../equipamentos/equipamentos.service';
import { Equipamento } from './../equipamentos/equipamento';
import { SalasService } from './salas.service';
import { Component, OnInit } from '@angular/core';
import { Sala } from './sala';

@Component({
  selector: 'app-salas',
  templateUrl: './salas.component.html',
  styleUrls: ['./salas.component.css'],
  preserveWhitespaces: true 
})
export class SalasComponent implements OnInit { 

  salas: Sala[];

  equipamentos: Equipamento[];

  displayCreation: boolean = false;

  constructor(private  salasService: SalasService, private equipamentosService: EquipamentosService, private confirmationService: ConfirmationService) { }

  ngOnInit(): void {
    this.listar();
  }

  listar(){
    this.salasService.listarSalas().subscribe((data)=>{
      this.salas = data;
      console.log(data);
    }, err =>{
      console.log(err);
    })
  }

  deletar(id:any){
    this.confirmationService.confirm({
      message: "Tem certeza que deseja excluir esta sala?",
      accept: () => {
        this.salasService.deletar(id).subscribe(
          s => {
            this.listar();
          }
        )
      }
    })
  }

  getTipoSala(sala: Sala): string{
    switch(sala.idTipoSala){
      case 1:
        return "Reunião";
      case 2:
        return "Trabalho";
      case 3:
        return "Palestras";
      case 4:
        return "Video";
      default:
        return null;
    }
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

  abrirPopUp(){
    this.displayCreation = true;
  }

}

import { ConfirmationService, MessageService } from 'primeng';
import { EquipamentosService } from './../equipamentos/equipamentos.service';
import { Equipamento } from './../equipamentos/models/equipamento';
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

  salaSelecionadaId: number;

  equipamentos: Equipamento[] = [];

  listaEquipamentos: any[] = [];

  displayCreation: boolean = false;

  constructor(private  salasService: SalasService,
    private equipamentosService: EquipamentosService, 
    private confirmationService: ConfirmationService,
    private messageService: MessageService) { }

  ngOnInit(): void {
    this.listar();
    this.listarEquipamentos();
    console.log("Lista Equipamentos " + this.listaEquipamentos);
  }

  listar(){
    this.salasService.listarSalas().subscribe((data)=>{
      this.salas = data;
      console.log(data);
    }, err =>{
      console.log(err);
    })
  }

  listarEquipamentos(){
    this.equipamentosService.listarEquipamentos().subscribe((data)=>{
      this.listaEquipamentos = data.map(e => {return { label: e.nome, value: e.id }}), err =>{
      console.log(err);
      }
    })
  }

  getNomeEquipamento(id: number){
    let item = this.listaEquipamentos.find(i => i.value === id);
    return item ? item.label : '';
  }

  editar(id: number){
    this.salaSelecionadaId = id;
    this.abrirPopUp();
  }

  deletar(id: number){
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
      case 5:
        return "Auditório";
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


  criarNovaSala(){
    this.salaSelecionadaId = null;
    this.abrirPopUp();
  }

  abrirPopUp(){
    this.displayCreation = true;
  }

  throwMessageSuccess(mensagem: string){
    this.messageService.add({severity: 'success', summary: 'Sucesso', detail: mensagem});
  }

}

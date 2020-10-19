import { Component, OnInit } from '@angular/core';

interface TipoEquipamento{
  name : string;
  idTipoEquipamento : number;
}

@Component({
  selector: 'app-equipamentos-form',
  templateUrl: './equipamentos-form.component.html',
  styleUrls: ['./equipamentos-form.component.css']
})
export class EquipamentosFormComponent implements OnInit {

  tipos : TipoEquipamento[];
  tipoSelecionado : TipoEquipamento;
  constructor() {
    this.tipos=[
      {name:'Móvel', idTipoEquipamento:1},
      {name:'Eletrodoméstico', idTipoEquipamento:2},
      {name:'Informática', idTipoEquipamento:3}
    ]
  }

  ngOnInit(){

  }
  

}

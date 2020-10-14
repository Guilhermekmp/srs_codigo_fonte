import { EquipamentosService } from './equipamentos.service';
import { Component, OnInit } from '@angular/core';
import { style } from '@angular/animations';

@Component({
  selector: 'app-equipamentos',
  templateUrl: './equipamentos.component.html',
  styleUrls: ['./equipamentos.component.css']
})
export class EquipamentosComponent implements OnInit {

  equipamentos = [];

  constructor(public equipamentosService: EquipamentosService) { 
    this.equipamentosService.listarEquipamentos().subscribe((data)=>{
      this.equipamentos = data;
      console.log(data);
    }, err =>{
      console.log(err);
      
    })
  }

  ngOnInit(): void {
  }

  adicionarEquipamentos(){

  }


}

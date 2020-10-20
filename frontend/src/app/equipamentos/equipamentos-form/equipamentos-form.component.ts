import { EquipamentosComponent } from './../equipamentos.component';
import { EquipamentosService } from './../equipamentos.service';
import { FormGroup, FormBuilder, FormControl } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Equipamento } from '../equipamento';

interface TipoEquipamento{
  idTipoEquipamento:number,
  nome : string
}
@Component({
  selector: 'app-equipamentos-form',
  templateUrl: './equipamentos-form.component.html',
  styleUrls: ['./equipamentos-form.component.css']
})
export class EquipamentosFormComponent implements OnInit {

  tipos: TipoEquipamento[];
  tipoSelecionado : TipoEquipamento;
  equipamento = new Equipamento();

  constructor(private equipamentosService : EquipamentosService,private equipamentosComponent:EquipamentosComponent) {
    this.tipos=[
      {nome : "Móvel", idTipoEquipamento:1},
      {nome:"Eletrodoméstico",idTipoEquipamento:2},
      {nome:"Informática",idTipoEquipamento:3}
    ]
  }

  ngOnInit(){

  }
  onSubmit(Equipamento){
    this.equipamento.idTipoEquipamento = this.tipoSelecionado.idTipoEquipamento;
    console.log('Equipamento', this.equipamento);
    this.equipamentosService.salvar(this.equipamento).subscribe(
      r =>{
        this.equipamento = r,
        this.equipamentosComponent.listar(),
        this.limpar()
      },
      error => {
        alert("ERROR")
      }
    )
    }
  limpar(){
    this.equipamento = new Equipamento();
  }
  }
 //   console.log(this.formulario.value);
   // const reserva: Reserva = {
     // ...this.formulario.value,
    //}
    //console.log('submit');
    //this.reservasService.salvar(reserva).subscribe(
     // success => console.log('sucesso'),
      //error => console.error(error),
      //() => console.log('request completo')
    //);


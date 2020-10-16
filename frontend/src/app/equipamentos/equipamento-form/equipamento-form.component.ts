import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { ConfirmationService } from 'primeng';

@Component({
  selector: 'app-equipamento-form',
  templateUrl: './equipamento-form.component.html',
  styleUrls: ['./equipamento-form.component.css']
})
export class EquipamentoFormComponent implements OnInit {

  formulario: FormGroup;
  
  constructor(private FormBuilder:FormBuilder, private confimationService:ConfirmationService) {
    this.formulario = this.FormBuilder.group({
      nome:['',[Validators.required, Validators.maxLength(255)]],
      idTipoEquipamento:['',[Validators.required, Validators.min(0), Validators.max(1)]],
      precoDiario:['',[Validators.required, Validators.min(0)]],
      obrigatorio:['',[Validators.required, Validators.min(0), Validators.max(1)]]
    })
  }

  ngOnInit(){
    
  }

}

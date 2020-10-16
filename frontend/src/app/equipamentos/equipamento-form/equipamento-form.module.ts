import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ButtonModule } from 'primeng/button';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { InputTextModule } from 'primeng/inputtext';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { EquipamentoFormComponent } from './equipamento-form.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    EquipamentoFormComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    InputTextModule,
    InputTextareaModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    ConfirmDialogModule
  ]
})
export class EquipamentoFormModule { }

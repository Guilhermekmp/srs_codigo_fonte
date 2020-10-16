import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { EquipamentoFormModule } from './equipamento-form/equipamento-form.module';
import { EquipamentosService } from './equipamentos.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EquipamentosComponent } from './equipamentos.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [EquipamentosComponent],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    EquipamentoFormModule,
    ConfirmDialogModule
  ],
  exports: [
    EquipamentosComponent
  ],
  providers: [
    EquipamentosService
  ]
})
export class EquipamentosModule { }

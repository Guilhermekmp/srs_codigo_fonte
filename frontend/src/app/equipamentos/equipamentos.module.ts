import { SharedModule } from './../shared/shared.module';
import { TableModule } from 'primeng/table';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { EquipamentosService } from './equipamentos.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EquipamentosComponent } from './equipamentos.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { EquipamentosFormModule } from './equipamentos-form/equipamentos-form.module';


@NgModule({
  declarations: [EquipamentosComponent],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    EquipamentosFormModule,
    ConfirmDialogModule,
    TableModule,
    SharedModule
  ],
  exports: [
    EquipamentosComponent
  ],
  providers: [
    EquipamentosService
  ]
})
export class EquipamentosModule { }

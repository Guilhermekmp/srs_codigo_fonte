import { CurrencyMaskModule } from 'ng2-currency-mask';
import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';
import { SharedModule } from './../shared/shared.module';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { EquipamentosService } from './equipamentos.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EquipamentosComponent } from './equipamentos.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { EquipamentosFormComponent } from './equipamentos-form/equipamentos-form.component';
import { InputNumberModule } from 'primeng';


@NgModule({
  declarations: [EquipamentosComponent, EquipamentosFormComponent],
  imports: [
    CommonModule,
    MessageModule,
    MessagesModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
    CurrencyMaskModule,
    InputNumberModule
  ],
  exports: [
  ],
  providers: [
    EquipamentosService
  ]
})
export class EquipamentosModule { }

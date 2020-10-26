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


@NgModule({
  declarations: [EquipamentosComponent],
  imports: [
    CommonModule,
    MessageModule,
    MessagesModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
    CurrencyMaskModule
  ],
  exports: [
  ],
  providers: [
    EquipamentosService
  ]
})
export class EquipamentosModule { }

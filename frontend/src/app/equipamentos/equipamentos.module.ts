import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';
import { SharedModule } from './../shared/shared.module';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
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
    MessageModule,
    MessagesModule,
    SharedModule
  ],
  exports: [
  ],
  providers: [
    EquipamentosService
  ]
})
export class EquipamentosModule { }

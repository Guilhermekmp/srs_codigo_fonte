import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { SharedModule } from './../shared/shared.module';
import { SalasFormComponent } from './salas-form/salas-form.component';
import { ButtonModule } from 'primeng/button';
import { SalasService } from './salas.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { SalasComponent } from './salas.component';
import { ConfirmationService } from 'primeng';
import { CurrencyMaskModule } from 'ng2-currency-mask';

@NgModule({
  declarations: [SalasComponent, SalasFormComponent],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    ButtonModule,
    ReactiveFormsModule,
    SharedModule,
    ConfirmDialogModule,
    CurrencyMaskModule
  ],
  exports: [
    SalasComponent
  ],
  providers: [
    SalasService,
    ConfirmationService
  ]
})
export class SalasModule { }

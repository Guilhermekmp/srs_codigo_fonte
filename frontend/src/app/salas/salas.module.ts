<<<<<<< HEAD
import { ConfirmDialogModule } from 'primeng/confirmdialog';
=======
>>>>>>> 5be359b0023994fd35f4c6c68e8b7fe791e5f7db
import { SharedModule } from './../shared/shared.module';
import { SalasFormComponent } from './salas-form/salas-form.component';
import { ButtonModule } from 'primeng/button';
import { SalasService } from './salas.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { SalasComponent } from './salas.component';
<<<<<<< HEAD
import { ConfirmationService } from 'primeng';
=======
>>>>>>> 5be359b0023994fd35f4c6c68e8b7fe791e5f7db
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
<<<<<<< HEAD
    ConfirmDialogModule,
=======
>>>>>>> 5be359b0023994fd35f4c6c68e8b7fe791e5f7db
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

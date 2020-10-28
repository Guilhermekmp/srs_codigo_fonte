import { SharedModule } from './../shared/shared.module';
import { ReservasService } from './reservas.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReservasComponent } from './reservas.component';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ReservasFormComponent } from './reservas-form/reservas-form.component';
import { CurrencyMaskModule } from 'ng2-currency-mask';
import { ConfirmationService, InputNumberModule } from 'primeng';

@NgModule({
  declarations: [ReservasComponent, ReservasFormComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    CurrencyMaskModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule,
    InputNumberModule
    ],
  exports: [
    ReservasComponent,
  ],
  providers: [
    ReservasService,
    ConfirmationService
  ],
})
export class ReservasModule { }

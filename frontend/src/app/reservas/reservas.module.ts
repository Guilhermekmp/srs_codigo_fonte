import { AutoCompleteModule } from 'primeng/autocomplete';
import { MultiSelectModule } from 'primeng/multiselect';
import { SharedModule } from './../shared/shared.module';
import { ReservasService } from './reservas.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReservasComponent } from './reservas.component';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { InputTextModule } from 'primeng/inputtext';
import { DialogModule } from 'primeng/dialog';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import { ReservasFormComponent } from './reservas-form/reservas-form.component';
import { CurrencyMaskModule } from 'ng2-currency-mask';


@NgModule({
  declarations: [ReservasComponent, ReservasFormComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    InputTextModule,
    CurrencyMaskModule,
    ButtonModule,
    FormsModule,
    TableModule,
    ReactiveFormsModule,
    ConfirmDialogModule,
    DialogModule,
    SharedModule,
    MultiSelectModule,
    AutoCompleteModule
    ],
  exports: [
    ReservasComponent,
  ],
  providers: [
    ReservasService
  ],
})
export class ReservasModule { }

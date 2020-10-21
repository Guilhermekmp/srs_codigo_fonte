import { ClientesService } from './clientes.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClientesComponent } from './clientes.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import {TableModule} from 'primeng/table';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import { SharedModule } from '../shared/shared.module';
import {InputMaskModule} from 'primeng/inputmask';


@NgModule({
  declarations: [ClientesComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    TableModule,
    ReactiveFormsModule,
    ConfirmDialogModule,
    SharedModule,
    InputMaskModule
  ],
  exports: [
    ClientesComponent,
  ],
  providers: [
    ClientesService
  ],
})
export class ClientesModule { }

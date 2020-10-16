import { InputTextModule } from 'primeng/inputtext';
import { SharedModule } from './../shared/shared.module';
import { SalasFormComponent } from './salas-form/salas-form.component';
import { ButtonModule } from 'primeng/button';
import { SalasService } from './salas.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { SalasComponent } from './salas.component';

@NgModule({
  declarations: [SalasComponent, SalasFormComponent],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    ButtonModule,
    ReactiveFormsModule,
    SharedModule
  ],
  exports: [
    SalasComponent
  ],
  providers: [
    SalasService
  ]
})
export class SalasModule { }

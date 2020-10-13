import { SalasService } from './salas.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { SalasComponent } from './salas.component';


@NgModule({
  declarations: [SalasComponent],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule
  ],
  exports: [
    SalasComponent
  ],
  providers: [
    SalasService
  ]
})
export class SalasModule { }

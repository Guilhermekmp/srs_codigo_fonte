import { TableModule } from 'primeng/table';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReservasComponent } from './reservas.component';



@NgModule({
  declarations: [ReservasComponent],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    TableModule
  ]
})
export class ReservasModule { }

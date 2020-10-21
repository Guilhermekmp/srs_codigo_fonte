import { SharedModule } from './../../shared/shared.module';
import { DropdownModule } from 'primeng/dropdown';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EquipamentosFormComponent } from './equipamentos-form.component';
import { ConfirmDialogModule, InputNumberModule } from 'primeng';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CurrencyMaskModule } from 'ng2-currency-mask';



@NgModule({
  declarations: [EquipamentosFormComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    InputNumberModule,
    SharedModule,
    CurrencyMaskModule
  ]
})
export class EquipamentosFormModule { }

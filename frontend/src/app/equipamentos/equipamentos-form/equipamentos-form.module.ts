import { DropdownModule } from 'primeng/dropdown';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from 'src/app/shared/shared.module';
import { EquipamentosFormComponent } from './equipamentos-form.component';
import { ConfirmDialogModule } from 'primeng';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [EquipamentosFormComponent],
  imports: [
    CommonModule
  ]
})
export class EquipamentosFormModule { }

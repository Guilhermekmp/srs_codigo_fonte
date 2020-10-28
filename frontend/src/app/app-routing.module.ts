import { InputTextModule } from 'primeng/inputtext';
import { ReservasComponent } from './reservas/reservas.component';
import { ClientesComponent } from './clientes/clientes.component';
import { EquipamentosComponent } from './equipamentos/equipamentos.component';
import { SalasComponent } from './salas/salas.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DiarioErrosComponent } from './components/diario-erros/diario-erros.component';
import { LoginSuccessComponent } from '@nuvem/angular-base';

const routes: Routes = [
    { path: 'diario-erros', component: DiarioErrosComponent, data: { breadcrumb: 'Diário de Erros'}},
    { path: 'login-success', component: LoginSuccessComponent }, 
    { path: 'clientes', component: ClientesComponent, data: { breadcrumb: 'Clientes'} },
    { path: 'equipamentos', component: EquipamentosComponent, data: { breadcrumb: 'Equipamentos'} },
    { path: 'reservas', component: ReservasComponent, data: { breadcrumb: 'Reservas'} },
    { path: 'salas', component: SalasComponent, data: { breadcrumb: 'Salas'}  }
    
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule,
    InputTextModule
  ]
})
export class AppRoutingModule { }

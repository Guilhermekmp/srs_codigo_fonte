


import { EquipamentosComponent } from './equipamentos/equipamentos.component';
import { SalasFormComponent } from './salas/salas-form/salas-form.component';
import { SalasComponent } from './salas/salas.component';

import { ReservasComponent } from './reservas/reservas.component';
import { ButtonModule } from 'primeng/button';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SharedModule } from './shared/shared.module';
import { AppTopbarComponent } from './components/topbar/app.topbar.component';
import { AppFooterComponent } from './components/footer/app.footer.component';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';
import { environment } from '../environments/environment';
import { HttpClientModule } from '@angular/common/http';
import { PageNotificationModule, BreadcrumbModule, MenuModule, ErrorStackModule } from '@nuvem/primeng-components';
import { SecurityModule, VersionTagModule } from '@nuvem/angular-base';
import { DiarioErrosComponent } from './components/diario-erros/diario-erros.component';
import { BlockUIModule } from 'ng-block-ui';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ClientesModule } from './clientes/clientes.module';
import { CurrencyMaskModule } from 'ng2-currency-mask';

@NgModule({
    declarations: [
        AppComponent,
        AppTopbarComponent,
        AppFooterComponent,
        DiarioErrosComponent,
        ReservasComponent,
        EquipamentosComponent,
        SalasComponent,
        SalasComponent
    ],
    imports: [
        BlockUIModule.forRoot({
            message: "Carregando..."
          }),
        BrowserModule,
        BrowserAnimationsModule,
        AppRoutingModule,
        SharedModule,
        HttpClientModule,
        PageNotificationModule,
        BreadcrumbModule,
        ErrorStackModule,
        VersionTagModule,
        ButtonModule,
        SecurityModule.forRoot(environment.auth),
        MenuModule,
        ReactiveFormsModule,
<<<<<<< HEAD
        FormsModule,
        ClientesModule

=======
        CurrencyMaskModule,
        SharedModule
>>>>>>> O POST ta dando 400 provavelmente por causa do array
    ],
    providers: [
        { provide: LocationStrategy, useClass: HashLocationStrategy }
    ],
    bootstrap: [AppComponent],
})
export class AppModule { }

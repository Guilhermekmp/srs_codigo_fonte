import { SalasModule } from './salas/salas.module';
import { ReservasModule } from './reservas/reservas.module';
import { SalasComponent } from './salas/salas.component';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SecurityModule, VersionTagModule } from '@nuvem/angular-base';
import { BreadcrumbModule, ErrorStackModule, MenuModule, PageNotificationModule } from '@nuvem/primeng-components';
import { BlockUIModule } from 'ng-block-ui';
import { CurrencyMaskModule } from 'ng2-currency-mask';
import { ConfirmationService, InputNumberModule } from 'primeng';
import { ButtonModule } from 'primeng/button';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { TableModule } from 'primeng/table';
import { environment } from '../environments/environment';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientesComponent } from './clientes/clientes.component';
import { DiarioErrosComponent } from './components/diario-erros/diario-erros.component';
import { EquipamentosModule } from './equipamentos/equipamentos.module';
import { AppFooterComponent } from './components/footer/app.footer.component';
import { AppTopbarComponent } from './components/topbar/app.topbar.component';
import { ReservasComponent } from './reservas/reservas.component';
import { SalasFormComponent } from './salas/salas-form/salas-form.component';
import { SharedModule } from './shared/shared.module';
import { ClientesModule } from './clientes/clientes.module';
import { InputTextModule } from 'primeng/inputtext';


@NgModule({
    declarations: [
        AppComponent,
        AppTopbarComponent,
        AppFooterComponent,
        DiarioErrosComponent
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
        FormsModule,
        ClientesModule,
        ConfirmDialogModule,
        ReactiveFormsModule,
        CurrencyMaskModule,
        SalasModule,
        SharedModule,
        ReservasModule,
        EquipamentosModule,
        InputNumberModule,
        TableModule
    ],
    providers: [
        { provide: LocationStrategy, useClass: HashLocationStrategy },
        ConfirmationService
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }

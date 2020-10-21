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
import { AppFooterComponent } from './components/footer/app.footer.component';
import { AppTopbarComponent } from './components/topbar/app.topbar.component';
import { EquipamentosFormComponent } from './equipamentos/equipamentos-form/equipamentos-form.component';
import { EquipamentosComponent } from './equipamentos/equipamentos.component';
import { ReservasComponent } from './reservas/reservas.component';
import { SalasFormComponent } from './salas/salas-form/salas-form.component';
import { SharedModule } from './shared/shared.module';

@NgModule({
    declarations: [
        AppComponent,
        AppTopbarComponent,
        AppFooterComponent,
        DiarioErrosComponent, SalasComponent,
        SalasFormComponent,
        EquipamentosComponent,
        ReservasComponent,
        ClientesComponent,
        EquipamentosFormComponent,
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
        ConfirmDialogModule,
        ReactiveFormsModule,
        CurrencyMaskModule,
        SharedModule,
        FormsModule,
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

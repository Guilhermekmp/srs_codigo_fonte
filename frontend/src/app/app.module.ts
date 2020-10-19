<<<<<<< HEAD
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { FormsModule } from '@angular/forms';
import { EquipamentosFormComponent } from './equipamentos/equipamentos-form/equipamentos-form.component';
=======
import { SalasFormComponent } from './salas/salas-form/salas-form.component';
>>>>>>> 238074666d3dca134695c686c1e5d621edc0914e
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
import { EquipamentosComponent } from './equipamentos/equipamentos.component';
<<<<<<< HEAD
import { InputTextModule } from 'primeng/inputtext';

=======
import { ReactiveFormsModule } from '@angular/forms';
import { CurrencyMaskModule } from 'ng2-currency-mask';
>>>>>>> 238074666d3dca134695c686c1e5d621edc0914e

@NgModule({
    declarations: [
        AppComponent,
        AppTopbarComponent,
        AppFooterComponent,
        DiarioErrosComponent,
        ReservasComponent,
        SalasComponent,
<<<<<<< HEAD
        EquipamentosComponent,
        EquipamentosFormComponent
=======
        EquipamentosComponent
        SalasFormComponent
>>>>>>> 238074666d3dca134695c686c1e5d621edc0914e
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
<<<<<<< HEAD
        FormsModule,
        ConfirmDialogModule
=======
        ReactiveFormsModule,
        CurrencyMaskModule,
        SharedModule
>>>>>>> 238074666d3dca134695c686c1e5d621edc0914e
    ],
    providers: [
        { provide: LocationStrategy, useClass: HashLocationStrategy }
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }

import { HttpClient } from '@angular/common/http';
import { ReservasService } from './reservas.service';
import { Component, OnInit } from '@angular/core';
import { reserva } from './reserva';

@Component({
  selector: 'app-reservas',
  templateUrl: './reservas.component.html',
  styleUrls: ['./reservas.component.css']
})
export class ReservasComponent implements OnInit {

  constructor(public reservasServices :ReservasService,public reserva: reserva, private http: HttpClient) { }

  ngOnInit(): void {
  }

  consultarReservas(){
    this.http.get(`http://localhost:8080/api/reservas`);
  }

}

import { Reserva } from './reserva';
import { Observable } from 'rxjs';
import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReservasService {

  private readonly API = environment.apiUrl + '/reservas';

  constructor(private http: HttpClient) { }

  // adicionarReserva(reserva: Reserva) {
  //   this.reservas.push(reserva);
  //   return this.reservas;
  //   //return this.http.post(this.API, reserva);
  // }

  getAllReservas(){
    return this.http.get<Reserva[]>(this.API,{});
  }

  deletar(id:number):Observable<any>{
    return this.http.delete(this.API + "/" + id );
  }

  getByid(id:number):Observable<Reserva>{
    return this.http.get<Reserva>(this.API + "/" + id);
  }

  salvar(reserva: Reserva):Observable<Reserva>{
    return this.http.post<Reserva>(this.API, reserva);
  }

  editar(reserva: Reserva):Observable<Reserva>{
    return this.http.put<Reserva>(this.API, reserva);
  }

  getTotal(){
    return this.http.get<Number>(this.API + "/total");
  }
}

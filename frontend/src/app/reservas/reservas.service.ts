import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReservasService {

  private resouceUrl = environment.apiUrl + '/reservas';

  constructor(private http: HttpClient) { }

  getAllReservas(){
    return this.http.get(this.resouceUrl,{});
  }
}

import { environment } from './../../environments/environment';
import { Sala } from './sala';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SalasService {

  private readonly API = environment.apiUrl + '/salas';

  constructor(private http: HttpClient) { }

  listarSalas(){
    return this.http.get<Sala[]>(this.API, {});
  }
}

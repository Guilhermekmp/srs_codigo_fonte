import { environment } from './../../environments/environment';
import { Sala } from './sala';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { take } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SalasService {

  private readonly API = environment.apiUrl + '/salas';

  constructor(private http: HttpClient) { }

  listarSalas(){
    return this.http.get<Sala[]>(this.API, {});
  }

  criar(sala: Sala){
    return this.http.post(this.API, sala).pipe(take(1));
  }
}

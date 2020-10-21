import { SalasComponent } from './salas.component';
import { EquipamentosService } from './../equipamentos/equipamentos.service';
import { Observable } from 'rxjs';
import { environment } from './../../environments/environment';
import { Sala } from './sala';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { take } from 'rxjs/operators';
import { Equipamento } from '../equipamentos/equipamento';

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

  deletar(id: any):Observable<any>{
    return this.http.delete(this.API + "/" + id);
  }

  buscarSala(id: any): Observable<Sala>{
    return this.http.get<Sala>(this.API + "/" + id);
  }

  listarEquipamentoOpcionais(id:any){
    return this.http.get<Equipamento[]>(this.API + "/" + id + "/equipamentos");
  }

  atualizarSala(sala: Sala): Observable<Sala>{
    return this.http.put<Sala>(this.API, sala);
  }
}

import { Observable } from 'rxjs';
import { Equipamento } from './equipamento';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EquipamentosService {

  private url = environment.apiUrl + '/equipamentos';
  
  equipamentos = [];

  constructor(private http:HttpClient) { }
  
  adicionarEquipamento(equipamento:Equipamento){
    this.equipamentos.push(equipamento);
    return this.equipamentos;
  }

  listarEquipamentos(){
    return this.http.get<Equipamento[]>(this.url,{});
  }

  //Observable para transformar
  deletar(id:any):Observable<any>{
    return this.http.delete(this.url+"/"+id);
  }

  salvar(equipamento:Equipamento):Observable<Equipamento>{
    return this.http.post<Equipamento>(this.url, equipamento);
  }

  buscar(id:any):Observable<any>{
    return this.http.get<Equipamento>(this.url+"/",id)
  }
  
  atualizarEquipamento(equipamento:Equipamento): Observable<Equipamento> {
    return this.http.put<Equipamento>(this.url, equipamento);
  }
  
}

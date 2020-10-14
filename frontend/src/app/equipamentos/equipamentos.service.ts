import { Equipamento } from './equipamento';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EquipamentosService {

  private url = environment.apiUrl + '/equipamentos';

  constructor(private http:HttpClient) { }

  listarEquipamentos(){
    return this.http.get<Equipamento[]>(this.url,{});
  }
  
}

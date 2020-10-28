import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { Cliente } from './models/cliente.interface';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  private readonly API = environment.apiUrl + '/clientes';


  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<Cliente[]>(`${this.API}`);
  }

  buscarPorId(id: number):Observable<Cliente>{
    return this.http.get<Cliente>(`${this.API}/${id}`);
  }

  salvar(cliente: Cliente):Observable<Cliente>{
    return this.http.post<Cliente>(this.API, cliente)
  }

  atualizarCliente(cliente: Cliente): Observable<Cliente> {
    return this.http.put<Cliente>(this.API, cliente)
  }

  deletar(id:any):Observable<any>{
    return this.http.delete(this.API + "/" + id )
  }

}

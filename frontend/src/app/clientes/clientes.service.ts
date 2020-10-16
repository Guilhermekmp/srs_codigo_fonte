import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { Cliente } from './models/cliente.interface';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ClientesComponent } from './clientes.component';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  private readonly API = environment.apiUrl + '/clientes';


  clientes: Array<Cliente> = new Array<Cliente>();



  constructor(private http: HttpClient) { }

  adicionarCliente(cliente: Cliente) {
    this.clientes.push(cliente);
    return this.clientes;
    //return this.http.post(this.API, cliente);
  }

  listar(){
    return this.http.get<Cliente[]>(`${this.API}`);
  }

  deletar(id:any):Observable<any>{
    return this.http.delete(this.API + "/" + id )
  }

  salvar(cliente: Cliente):Observable<Cliente>{
    return this.http.post<Cliente>(this.API, cliente)
  }

  


}

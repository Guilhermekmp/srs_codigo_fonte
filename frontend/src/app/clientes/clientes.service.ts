import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  private readonly API = environment.apiUrl + '/clientes';

  constructor() { }
}

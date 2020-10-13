import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EquipamentosService {

  private readonly API = environment.apiUrl + '/equipamentos';

  constructor() { }
}

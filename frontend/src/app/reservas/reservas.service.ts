import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReservasService {

  private readonly API = environment.apiUrl + '/reservas';

  constructor() { }
}

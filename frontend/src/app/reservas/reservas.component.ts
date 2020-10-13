import { ReservasService } from './reservas.service';
import { Component, OnInit } from '@angular/core';
import { SortEvent } from 'primeng';

@Component({
  selector: 'app-reservas',
  templateUrl: './reservas.component.html',
  styleUrls: ['./reservas.component.css']
})
export class ReservasComponent implements OnInit {

  reservas = [{
    cliente:'Eu',
    sala:'Do lado',
    dtIni:'Data inicio',
    dtFim:'Data fim',
    total:10
  },
  {
    cliente:'Eu',
    sala:'Do lado',
    dtIni:'Data inicio',
    dtFim:'Data fim',
    total:10
  }];

  constructor(public reservaService: ReservasService) { }

  ngOnInit(): void {

    this.reservaService.getAllReservas().subscribe((data)=>{

    }, err =>{
      console.log(err);
      
    })
  }

  customSort(event: SortEvent) {}

}

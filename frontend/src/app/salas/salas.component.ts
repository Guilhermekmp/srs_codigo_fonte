import { SalasService } from './salas.service';
import { Component, OnInit } from '@angular/core';
import { Sala } from './sala';

@Component({
  selector: 'app-salas',
  templateUrl: './salas.component.html',
  styleUrls: ['./salas.component.css']
})
export class SalasComponent implements OnInit {

  salas: Sala[];

  constructor(public salasService: SalasService) { }

  ngOnInit(): void {
    this.salasService.list().subscribe(console.log);
  }

}

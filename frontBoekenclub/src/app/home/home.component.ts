import { Component, OnInit } from '@angular/core';
import { BesprekingService } from '../services/bespreking.service';
import { BoekService } from '../services/boek.service';
import { RecensieService } from '../services/recensie.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

    boeken: any[] = [];
    besprekingen: any[] = [];
    recensies: any[] = []; // Declare recensies property
  
    constructor(
      private besprekingService: BesprekingService,
      private boekService: BoekService,
      private recensieService: RecensieService
    ) { }
  
    ngOnInit(): void {
      this.besprekingService.getbesprekingen().subscribe((data: any) => {
        this.besprekingen = data;
      });

      this.boekService.getBoeken().subscribe((data: any) => {
        this.boeken = data;
      });

      this.recensieService.getRecensies().subscribe((data: any) => {
        this.recensies = data; // Assign the data to recensies
      });
    }
}


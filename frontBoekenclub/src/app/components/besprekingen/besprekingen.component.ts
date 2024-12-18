import { Component, OnInit } from '@angular/core';
import { BesprekingService } from '../../services/bespreking.service';

@Component({
  selector: 'app-besprekingen',
  standalone: true,
  imports: [],
  templateUrl: './besprekingen.component.html',
  styleUrl: './besprekingen.component.css'
})
export class BesprekingenComponent implements OnInit {
  besprekingen: any[] = [];

  constructor(private besprekingService: BesprekingService) { }

  ngOnInit(): void {
    this.besprekingService.getbesprekingen().subscribe((data: any) => {
      this.besprekingen = data;
    });
  }

}

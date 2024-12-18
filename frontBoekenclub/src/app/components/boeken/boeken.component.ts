import { Component, OnInit } from '@angular/core';
import { BoekService } from '../../services/boek.service';

@Component({
  selector: 'app-boeken',
  standalone: true,
  imports: [],
  templateUrl: './boeken.component.html',
  styleUrl: './boeken.component.css'
})
export class BoekenComponent implements OnInit {
  boeken: any[] = [];

  constructor(private boekService: BoekService) { }

  ngOnInit(): void {
    this.boekService.getBoeken().subscribe((data: any) => {
      this.boeken = data;
    });
  }

}

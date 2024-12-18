import { Component, OnInit } from '@angular/core';
import { RecensieService } from '../../services/recensie.service';

@Component({
  selector: 'app-recensies',
  standalone: true,
  imports: [],
  templateUrl: './recensies.component.html',
  styleUrl: './recensies.component.css'
})
export class RecensiesComponent implements OnInit {
  recensies: any[] = [];

  constructor(private recensieService: RecensieService) { }

  ngOnInit(): void {
    this.recensieService.getRecensies().subscribe((data: any) => {
      this.recensies = data;
    });
  }

}

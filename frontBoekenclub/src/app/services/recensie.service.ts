import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecensieService {

  constructor(private http: HttpClient) { }

  getRecensies(): Observable<any> {
    return this.http.get('http://localhost:8084/api/recensies');
  }
}

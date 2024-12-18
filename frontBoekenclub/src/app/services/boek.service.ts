import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BoekService {

  constructor(private http: HttpClient) { }

  getBoeken(): Observable<any> {
    return this.http.get('http://localhost:8084/api/boek');
  }
}

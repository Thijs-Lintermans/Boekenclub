import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BesprekingService {

  constructor(private httpClient: HttpClient) { }

  getbesprekingen(): Observable<any> {
    return this.httpClient.get('http://localhost:8084/api/bespreking');
  }
}

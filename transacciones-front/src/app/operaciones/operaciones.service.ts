import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { OperacionRequest } from '../models/operacion-request';
import { OperacionResponse } from '../models/operacion-response';


@Injectable({
  providedIn: 'root'
})
export class OperacionesService {

  private url = 'http://localhost:8080/operaciones';


  constructor(
    private http: HttpClient
  ) {}


  registrarOperacion(
    request: OperacionRequest
  ): Observable<OperacionResponse> {

    return this.http.post<OperacionResponse>(
      this.url,
      request
    );
  }

}
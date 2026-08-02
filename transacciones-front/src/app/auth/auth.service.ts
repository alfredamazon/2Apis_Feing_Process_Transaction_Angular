import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { LoginRequest } from '../models/login-request';
import { LoginResponse } from '../models/login-response';


@Injectable({
  providedIn: 'root'
})
export class AuthService {


  private url = 'http://localhost:8081/auth/login';


  constructor(
    private http: HttpClient
  ) {}


  login(
    request: LoginRequest
  ): Observable<LoginResponse> {


    return this.http.post<LoginResponse>(
      this.url,
      request
    );

  }

}
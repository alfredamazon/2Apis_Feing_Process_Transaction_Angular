import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

import { AuthService } from '../auth.service';

import { LoginRequest } from '../../models/login-request';
import { LoginResponse } from '../../models/login-response';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {


  usuario = '';

  password = '';

  mensaje = '';


  constructor(
    private authService: AuthService,
    private router: Router
  ) {

    console.log('CONSTRUCTOR LOGIN EJECUTADO');

  }



  ingresar(){


    console.log('SI ENTRO AL BOTON LOGIN');


    const request: LoginRequest = {

      usuario: this.usuario,
      password: this.password

    };


    this.authService.login(request)
    .subscribe({

      next: (response: LoginResponse) => {


        console.log(response);


        this.mensaje = response.mensaje;


        if(response.mensaje === 'Login correcto'){

          this.router.navigate(['/operaciones']);

        }


      },


      error: (error: any) => {


        console.error(error);


        this.mensaje = 'Usuario o contraseña incorrectos';


      }


    });


  }


}
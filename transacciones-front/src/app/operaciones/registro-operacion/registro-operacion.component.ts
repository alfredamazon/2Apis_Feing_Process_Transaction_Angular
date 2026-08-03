import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-registro-operacion',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './registro-operacion.component.html',
  styleUrl: './registro-operacion.component.css'
})
export class RegistroOperacionComponent {


  operacion = {

    operacion: '',
    importe: '',
    cliente: '',
    secreto: ''

  };


  mensaje = '';

  private url = 'http://localhost:8080/operaciones';


  constructor(
    private http: HttpClient
  ) {}


  registrarOperacion(){

    console.log('Datos enviados:', this.operacion);


    this.http.post<any>(
      this.url,
      this.operacion
    )
    .subscribe({

      next: (respuesta) => {

        console.log('Respuesta backend:', respuesta);

        this.mensaje =
          'Operación capturada correctamente. Referencia: '
          + respuesta.referencia;

      },

      error: (error) => {

        console.error('Error:', error);

        this.mensaje =
          'Error al registrar operación';

      }

    });

  }

}
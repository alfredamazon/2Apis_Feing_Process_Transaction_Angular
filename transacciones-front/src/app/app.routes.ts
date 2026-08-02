import { Routes } from '@angular/router';

import { LoginComponent } from './auth/login/login.component';
import { RegistroOperacionComponent } 
from './operaciones/registro-operacion/registro-operacion.component';


export const routes: Routes = [

  {
    path: '',
    component: LoginComponent
  },

  {
    path: 'operaciones',
    component: RegistroOperacionComponent
  }

];
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from './cliente';
import { CLIENTES } from './clientes.json';
import { of } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class ClienteService {



  constructor() { }


  getClientes(): Observable<Cliente[]>{
    
    // lo convertimos en un flujo de datos
    // porque los datos se pedirán de manera asíncrona 
    // cuando nos conectemos al servidor
    return of(CLIENTES) 
  }
}

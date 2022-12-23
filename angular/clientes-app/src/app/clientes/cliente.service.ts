import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from './cliente';
import { CLIENTES } from './clientes.json';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';

import { HttpClient } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private urlEndPoint: string = 'http://localhost:8080/api/clientes'


  constructor(private http: HttpClient) { }


  getClientes(): Observable<Cliente[]>{
    
    // lo convertimos en un flujo de datos
    // porque los datos se pedirán de manera asíncrona 
    // cuando nos conectemos al servidor
   // return of(CLIENTES) 

 //  return this.http.get<Cliente[]>(this.urlEndPoint)

    return this.http.get(this.urlEndPoint)
        .pipe(
         map( response => response as Cliente[] )
          )
          
  }
}

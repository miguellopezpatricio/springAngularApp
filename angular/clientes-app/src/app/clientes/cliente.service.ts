import { Injectable } from '@angular/core';
import { formatDate } from '@angular/common';
import { Cliente } from './cliente';
import { CLIENTES } from './clientes.json';
import { of, Observable, throwError } from 'rxjs';
import { map, catchError } from 'rxjs/operators';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';



@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private urlEndPoint: string = 'http://localhost:8080/api/clientes'

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' })

  constructor(private http: HttpClient, private router: Router) { }


  getClientes(): Observable<Cliente[]> {

    // lo convertimos en un flujo de datos
    // porque los datos se pedirán de manera asíncrona 
    // cuando nos conectemos al servidor
    // return of(CLIENTES) 

    //  return this.http.get<Cliente[]>(this.urlEndPoint)

    return this.http.get(this.urlEndPoint)
      .pipe(
        map(response => {
          let clientes = response as Cliente[]
          return clientes.map(cliente => {
            cliente.nombre = cliente.nombre.toUpperCase()
            cliente.createAt = formatDate(cliente.createAt, 'dd-MM-yyyy','es-ES')
            return cliente
          })
        }
        )
      )

  }

  create(cliente: Cliente): Observable<any> {

    return this.http.post<any>(this.urlEndPoint, cliente, { headers: this.httpHeaders })
      .pipe(
        catchError(e => {
          if (e.status == 400) {
            return throwError(e)
          }
          console.log(e.error.mensaje)
          Swal.fire(e.error.mensaje, e.error.error, 'error')
          return throwError(e)
        })
      )

  }

  getCliente(id): Observable<Cliente> {

    return this.http.get<Cliente>(`${this.urlEndPoint}/${id}`)
      .pipe(
        catchError(e => {

          this.router.navigate(['/clientes'])
          console.log(e.error.mensaje)
          Swal.fire('Error al editar', e.error.mensaje, 'error')
          return throwError(e)
        })
      )
  }

  update(cliente: Cliente): Observable<any> {

    return this.http.put<any>(`${this.urlEndPoint}/${cliente.id}`, cliente, { headers: this.httpHeaders })
      .pipe(
        catchError(e => {
          if (e.status == 400) {
            return throwError(e)
          }
          console.log(e.error.mensaje)
          Swal.fire('Error al actualizar', e.error.mensaje, 'error')
          return throwError(e)
        })
      )
  }

  delete(id: number): Observable<Cliente> {


    return this.http.delete<Cliente>(`${this.urlEndPoint}/${id}`, { headers: this.httpHeaders })
      .pipe(
        catchError(e => {
          console.log(e.error.mensaje)
          Swal.fire('Error al eliminar', e.error.mensaje, 'error')
          return throwError(e)
        })
      )
  }
}

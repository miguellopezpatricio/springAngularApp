import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import swal from 'sweetalert2';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit{

  public cliente: Cliente = new Cliente()
  public titulo: string = 'Crear cliente'
  public errores: string[]

  constructor(private clienteService: ClienteService, private router: Router, private activatedRoute:ActivatedRoute){}

  ngOnInit(){

    this.cargarCliente()

  }


  create(): void{

    this.clienteService.create(this.cliente)
    .subscribe(json => {
      this.router.navigate(['/clientes'])
    swal.fire('Nuevo cliente',`${json.mensaje}: ${json.cliente.nombre}`, 'success')
    },
    err=>{
      this.errores = err.error.errors as string[]
      console.error('Cṕdigo de error desde el backend: ' + err.status)
      console.error(err.error.errors)
    })
  }

  cargarCliente():void{
    this.activatedRoute.params.subscribe(params => {
        let id = params['id']
        if(id){
          this.clienteService.getCliente(id)
          .subscribe((cliente)=> this.cliente = cliente)
        }
      }
    )
  }

  update():void{
    this.clienteService.update(this.cliente)
    .subscribe(json => {
      this.router.navigate(['/clientes'])
      swal.fire('Cliente actualizado',`${json.mensaje}: ${json.cliente.nombre}`,'success')
    },
    err=>{
      this.errores = err.error.errors as string[]
      console.error('Cṕdigo de error desde el backend: ' + err.status)
      console.error(err.error.errors)
    })
    
  }

}

import { Component } from '@angular/core';
import Swal from 'sweetalert2';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';



@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html'
})
export class ClientesComponent {

  clientes: Cliente[]

  constructor(private clienteService:ClienteService){}


  ngOnInit(){

    this.clienteService.getClientes()
    .subscribe(
      clientes => this.clientes = clientes
    )
  }

  delete(cliente: Cliente):void{

    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })
    
    swalWithBootstrapButtons.fire({
      title: '¿Está seguro?',
      text: `¿Seguro que quiere eliminar al cliente ${cliente.nombre}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'SI',
      cancelButtonText: 'NO',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        //this.clienteService.delete(cliente.id)
        // .subscribe(response => {
        //   this.clientes = this.clientes.filter(cliente)
        swalWithBootstrapButtons.fire(
          '¡Eliminado!',
          'El registro ha sido eliminado.',
          'success'
        )
      } 
    })

  }

}

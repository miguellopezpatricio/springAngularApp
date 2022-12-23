import { Component } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';



@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html'
})
export class ClientesComponent {

  constructor(private clienteService:ClienteService){}

  clientes: Cliente[] = this.clienteService.getClientes()


}

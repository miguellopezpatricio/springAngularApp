import { Component } from '@angular/core';

@Component({
  selector: 'app-directiva',
  templateUrl: './directiva.component.html'
})
export class DirectivaComponent {

  listaCurso: string [] = ['TypeScript','JavaScript','Java','C#','P']

  habilitar: boolean = true

  setHabilitar(){
    this.habilitar = (this.habilitar == true)? false:true
  }

}

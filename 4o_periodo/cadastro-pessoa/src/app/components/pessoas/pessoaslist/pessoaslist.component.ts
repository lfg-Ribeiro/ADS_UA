import { Component } from '@angular/core';
import { Pessoa } from '../../../models/pessoa';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-pessoaslist',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './pessoaslist.component.html',
  styleUrl: './pessoaslist.component.scss',
})
export class PessoaslistComponent {
  lista: Pessoa[] = [];

  constructor() {
    this.lista.push(new Pessoa(1, 'Ribeiro', '12345678900', 'ribas@ribas.com'));
    this.lista.push(new Pessoa(2, 'Nicholas', '45678900123', 'tcholas@tcholas.com'));
    this.lista.push(new Pessoa(3, 'Hoesel', '78900123456', 'hoesa@hoesa.com'));
    this.lista.push(new Pessoa(4, 'Inácio', '00123456789', 'nana@nana.com'));
  }

  editar(){
  
    }

  deletar(){

  }
}

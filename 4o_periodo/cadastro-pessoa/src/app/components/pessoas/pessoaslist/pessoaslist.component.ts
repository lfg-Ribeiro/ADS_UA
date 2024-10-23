import { Component } from '@angular/core';
import { Pessoa } from '../../../models/pessoa';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-pessoaslist',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './pessoaslist.component.html',
  styleUrl: './pessoaslist.component.scss'
})
export class PessoaslistComponent {

  lista: Pessoa[] = [];

  constructor() {
    let pessoa: Pessoa = new Pessoa();
    pessoa.id = 1;
    pessoa.nome = 'Ribeiro';
    pessoa.documento = '12345678900';
    pessoa.email = 'ribas@ribas.com';

    let pessoa2: Pessoa = new Pessoa();
    pessoa2.id = 2;
    pessoa2.nome = 'Nicholas';
    pessoa2.documento = '45678900123';
    pessoa2.email = 'tcholas@tcholas.com';

    let pessoa3: Pessoa = new Pessoa();
    pessoa3.id = 3;
    pessoa3.nome = 'Hoesel';
    pessoa3.documento = '78900123456';
    pessoa3.email = 'hoesa@hoesa.com';

    let pessoa4: Pessoa = new Pessoa();
    pessoa4.id = 4;
    pessoa4.nome = 'Inácio';
    pessoa4.documento = '00123456789';
    pessoa4.email = 'nana@nana.com';

    this.lista.push(pessoa);
    this.lista.push(pessoa2);
    this.lista.push(pessoa3);
    this.lista.push(pessoa4);
}
}

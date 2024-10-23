import { Component } from '@angular/core';
import { Pessoa } from '../../../models/pessoa';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import Swal from 'sweetalert2';

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

    let pessoaNova = history.state.pessoaNova;
    let pessoaEditada = history.state.pessoaEditada;

    if (pessoaNova) {
      pessoaNova.id = this.lista.length + 1;
      this.lista.push(pessoaNova);
    }
    if (pessoaEditada) {
      let indice = this.lista.findIndex((x) => {
        return x.id == pessoaEditada.id;
      });
      this.lista[indice] = pessoaEditada;
    }
  }

  deleteById(pessoa: Pessoa) {
    Swal.fire({
      title: 'Tem certeza que deseja deletar o usuário?',
      icon: 'warning',
      showConfirmButton: true,
      confirmButtonText: 'Sim',
      showCancelButton: true,
      cancelButtonText: 'Cancelar',
    }).then((result) => {
      if (result.isConfirmed) {
        let indice = this.lista.findIndex((x) => {
          return x.id == pessoa.id;
        });
        this.lista.splice(indice, 1);

        Swal.fire({
          title: 'Deletado com sucesso',
          icon: 'success',
          confirmButtonText: 'OK',
        });
      }
    });
  }
}

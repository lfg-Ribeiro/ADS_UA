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

  findAll(){
    
  }

  constructor() {

    this.findAll();

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

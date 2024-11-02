import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Campeonato } from '../../models/campeonatos/campeonato';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-campeonatos',
  standalone: true,
  imports: [RouterLink, CommonModule],
  templateUrl: './campeonatos.component.html',
  styleUrl: './campeonatos.component.scss',
})
export class CampeonatosComponent {
  lista: Campeonato[] = [];

  findAll() {}

  deleteById(campeonato: Campeonato) {
    Swal.fire({
      title: 'Tem certeza que deseja deletar o campeonato?',
      icon: 'warning',
      showConfirmButton: true,
      confirmButtonText: 'Sim',
      showCancelButton: true,
      cancelButtonText: 'Cancelar',
    }).then((result) => {
      if (result.isConfirmed) {
        let indice = this.lista.findIndex((x) => {
          return x.id == campeonato.id;
        });
        this.lista.splice(indice, 1);

        Swal.fire({
          title: 'Campeonato deletado com sucesso',
          icon: 'success',
          confirmButtonText: 'OK',
        });
      }
    });
  }
}
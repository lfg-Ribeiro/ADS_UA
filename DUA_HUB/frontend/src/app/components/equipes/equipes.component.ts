import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Equipe } from '../../models/equipes/equipe';
import { CommonModule } from '@angular/common';
import Swal from 'sweetalert2';
import { EquipeService } from '../../services/equipe.service';

@Component({
  selector: 'app-equipes',
  standalone: true,
  imports: [RouterLink, CommonModule],
  templateUrl: './equipes.component.html',
  styleUrl: './equipes.component.scss',
})
export class EquipesComponent {
  constructor(private readonly service:EquipeService){}
  lista: Equipe[] = [];

  async findAll() {
    this.lista=await this.service.obterEquipes()
    }

  deleteById(equipe: Equipe) {
    Swal.fire({
      title: 'Tem certeza que deseja deletar a equipe?',
      icon: 'warning',
      showConfirmButton: true,
      confirmButtonText: 'Sim',
      showCancelButton: true,
      cancelButtonText: 'Cancelar',
    }).then((result) => {
      if (result.isConfirmed) {
        let indice = this.lista.findIndex((x) => {
          return x.id == equipe.id;
        });
        this.service.deletarEquipe(equipe.id)
        this.lista.splice(indice, 1);

        Swal.fire({
          title: 'Equipe deletada com sucesso',
          icon: 'success',
          confirmButtonText: 'OK',
        });
      }
    });
  }
}

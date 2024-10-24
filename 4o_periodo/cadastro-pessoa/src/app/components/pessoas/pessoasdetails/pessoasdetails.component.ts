import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import { Pessoa } from '../../../models/pessoa';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-pessoasdetails',
  standalone: true,
  imports: [MdbFormsModule, FormsModule],
  templateUrl: './pessoasdetails.component.html',
  styleUrl: './pessoasdetails.component.scss',
})
export class PessoasdetailsComponent {
  pessoa: Pessoa = new Pessoa(0, '', '', '');
  router = inject(ActivatedRoute);
  router2 = inject(Router);

  constructor() {
    let id = this.router.snapshot.params['id'];
    if (id > 0) {
      this.findById(id);
    }
  }

  findById(id: number) {
    let pessoaRetornado: Pessoa = new Pessoa(
      id,
      'Fulano Teste',
      '11122233344',
      'fulano@fulano.com'
    );
    this.pessoa = pessoaRetornado;
  }

  salvar() {
    if (this.pessoa.id > 0) {
      Swal.fire({
        title: 'Editado com sucesso',
        icon: 'success',
        confirmButtonText: 'OK',
      });
      this.router2.navigate(['/admin/pessoas'], {
        state: { pessoaEditada: this.pessoa },
      });
    } else {
      Swal.fire({
        title: 'Salvo com sucesso',
        icon: 'success',
        confirmButtonText: 'OK',
      });
      this.router2.navigate(['/admin/pessoas'], {
        state: { pessoaNova: this.pessoa },
      });
    }
  }
}

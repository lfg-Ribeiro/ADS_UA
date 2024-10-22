import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import Swal from 'sweetalert2'
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [MdbFormsModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  user!: string;
  pass!: string;

  router = inject(Router);

  logar() {
    if (this.user == 'admin' && this.pass == 'admin'){
      this.router.navigate(['/admin/pessoas']);

      Swal.fire({
        title: 'Acesso Liberado!',
        icon: 'success',
        confirmButtonText: 'Prosseguir'
      });
    }
  }
}

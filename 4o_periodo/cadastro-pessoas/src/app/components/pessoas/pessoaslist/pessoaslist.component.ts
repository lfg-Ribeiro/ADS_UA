import { Component } from '@angular/core';
import { MdbTabsModule } from 'mdb-angular-ui-kit/tabs';

@Component({
  selector: 'app-pessoaslist',
  standalone: true,
  imports: [MdbTabsModule],
  templateUrl: './pessoaslist.component.html',
  styleUrl: './pessoaslist.component.scss'
})
export class PessoaslistComponent {

  id!: number;
  nome!: string;
  documento!: string;
  email!: string;
  status!: string;

  pessoas:Pessoa[] = [];
  tableHeader:string[] = [
    "ID","Nome","Documento","Email","Status"
  ]

  constructor() {
    let pessoa1:Pessoa = new PessoaslistComponent()
    pessoa1.id = 1;
    pessoa1.nome = "Hoesel";
    pessoa1.documento = "123.456.789-00";
    pessoa1.email = "Hoesa@Hoesa.com";
    pessoa1.status = "Ativo";

    let pessoa2:Pessoa = new PessoaslistComponent()
    pessoa2.id = 2;
    pessoa2.nome = "Ribeiro";
    pessoa2.documento = "987.654.321-00";
    pessoa2.email = "ribeiro@ribeiro.com";
    pessoa2.status = "Inativo";

    let pessoa3:Pessoa = new PessoaslistComponent()
    pessoa3.id = 3;
    pessoa3.nome = "Nicholas";
    pessoa3.documento = "456.789.123-00";
    pessoa3.email = "tchola@tchola.com";
    pessoa3.status = "Ativo";

    let pessoa4:Pessoa = new PessoaslistComponent()
    pessoa4.id = 4;
    pessoa4.nome = "Inácio";
    pessoa4.documento = "789.123.456-00";
    pessoa4.email = "inacio@inacio.com";
    pessoa4.status = "Inativo";

    this.pessoas.push(pessoa1);
    this.pessoas.push(pessoa2);
    this.pessoas.push(pessoa3);
}
}

import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { PrincipalComponent } from './components/principal/principal.component';
import { PessoaslistComponent } from './components/pessoas/pessoaslist/pessoaslist.component';
import { PessoadetailsComponent } from './components/pessoas/pessoadetails/pessoadetails.component';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  {
    path: 'admin',
    component: PrincipalComponent,
    children: [
      { path: 'pessoas', component: PessoaslistComponent },
      { path: 'pessoas/add', component: PessoadetailsComponent },
      { path: 'pessoas/edit/:id', component: PessoadetailsComponent },
    ],
  },
];

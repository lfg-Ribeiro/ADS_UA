import { Routes } from '@angular/router';
import { PessoaslistComponent } from './components/pessoas/pessoaslist/pessoaslist.component';
import { LoginComponent } from './components/layout/login/login.component';
import { PrincipalComponent } from './components/layout/principal/principal.component';
import { PessoasdetailsComponent } from './components/pessoas/pessoasdetails/pessoasdetails.component';

export const routes: Routes = [
    {path: "", redirectTo: "login", pathMatch: "full"},
    {path: "login", component: LoginComponent},
    {path: "admin", component: PrincipalComponent, children: [
        {path: "pessoas", component: PessoaslistComponent},
        {path: "pessoas/new", component: PessoasdetailsComponent},
        {path: "pessoas/edit/:id", component: PessoasdetailsComponent}
    ]}
];

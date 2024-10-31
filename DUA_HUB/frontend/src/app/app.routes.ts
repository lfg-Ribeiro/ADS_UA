import { Routes } from '@angular/router';
import { LoginComponent } from './components/layout/login/login.component';
import { PrincipalComponent } from './components/layout/principal/principal.component';
import { MainComponent } from './components/layout/main/main.component';
import { EquipesComponent } from './components/equipes/equipes.component';
import { CampeonatosComponent } from './components/campeonatos/campeonatos.component';

export const routes: Routes = [
    {path: "", redirectTo: "home", pathMatch: "full"},
    {path: "home", component: MainComponent}, // construir página principal do usuario
    {path: "login", component: LoginComponent}, // página de login para ADM
    {path: "admin", component: PrincipalComponent, children: [ // página principal do ADM
        {path: "equipes", component: EquipesComponent}, // página de equipes
       // {path: "pessoas/new", component: PessoasdetailsComponent},
       // {path: "pessoas/edit/:id", component: PessoasdetailsComponent}
       {path: "campeonatos", component: CampeonatosComponent}, // página de campeonatos
       // {path: "campeonatos/new", component: CampeonatosdetailsComponent},
       // {path: "campeonatos/edit/:id", component: CampeonatosdetailsComponent}
    ]}
];

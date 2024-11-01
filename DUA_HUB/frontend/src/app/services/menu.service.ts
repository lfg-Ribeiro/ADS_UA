// menu.service.ts
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MenuService {
  obterItensMenu() {
    return [
      { nome: 'Inicio', rota: '/inicio' },
      { nome: 'Campeonatos', rota: '/campeonatos' },
      { nome: 'Equipes', rota: '/equipes' },
      { nome: 'Inscrições', rota: '/inscricoes' },
      { nome: 'Login', rota: '/login' }
    ];
  }
}

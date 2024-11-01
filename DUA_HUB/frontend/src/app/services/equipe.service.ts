// equipe.service.ts
import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EquipeService {
  private apiUrl = `${environment.apiUrl}/equipes`;

  async obterEquipes() {
    return await axios.get(this.apiUrl);
  }

  async adicionarEquipe(dados: any) {
    return await axios.post(this.apiUrl, dados);
  }
}

// campeonato.service.ts
import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CampeonatoService {
  private apiUrl = `${environment.apiUrl}/campeonatos`;

  async obterCampeonatos() {
    return await axios.get(this.apiUrl);
  }

  async criarCampeonato(dados: any) {
    return await axios.post(this.apiUrl, dados);
  }
}

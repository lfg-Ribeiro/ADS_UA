// inscricao.service.ts
import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InscricaoService {
  private apiUrl = `${environment.apiUrl}/inscricoes`;

  async listarInscricoes() {
    return await axios.get(this.apiUrl);
  }

  async realizarInscricao(dados: any) {
    return await axios.post(this.apiUrl, dados);
  }
}

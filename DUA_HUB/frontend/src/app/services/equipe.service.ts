// equipe.service.ts
import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from '../environment';
import { ApiService } from '../api/api.service';

@Injectable({
  providedIn: 'root'
})
export class EquipeService {

  constructor(private readonly apiService:ApiService){}
  
  private readonly route = 'equipe'

  async obterEquipes() {
    return await this.apiService.get(this.route);
  }

  async adicionarEquipe(dados: any) {
    return await this.apiService.post(this.route, dados);
  }

  async atualizarEquipe(id: any, dados: any) {
    return await this.apiService.put(this.route, id, dados);
  }

  async deletarEquipe(id: any) {
    return await this.apiService.delete(this.route, id);
  }
  
}

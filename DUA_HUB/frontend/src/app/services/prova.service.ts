import { Injectable } from '@angular/core';
import { ApiService } from '../api/api.service';

@Injectable({
  providedIn: 'root'
})
export class ProvaService {

  private readonly route = 'provas';

  constructor(private readonly apiService: ApiService) {}

 
  async obterProvas() {
    return await this.apiService.get(this.route);
  }

  
  async criarProva(dados: any) {
    return await this.apiService.post(this.route, dados);
  }

 
  async atualizarProva(id: any, dados: any) {
    return await this.apiService.put(`${this.route}/${id}`,id, dados);
  }

  
  async deletarProva(id: any) {
    return await this.apiService.delete(`${this.route}/${id}`,id);
  }

  
  async obterProvaPorNome(nome: string) {
    const route = `${this.route}/findByNome`;
    return await this.apiService.get(route, { params: { nome } });
  }

 
  async obterProvaPorLocal(local: string) {
    const route = `${this.route}/findByLocal`;
    return await this.apiService.get(route, { params: { local } });
  }

  
  async obterProvaPorParticipante(idParticipante: number) {
    const route = `${this.route}/findByParticipante`;
    return await this.apiService.get(route, { params: { idParticipante } });
  }
}

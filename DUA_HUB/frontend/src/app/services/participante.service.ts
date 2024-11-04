import { Injectable } from '@angular/core';
import axios from 'axios';
import { ApiService } from '../api/api.service';

@Injectable({
  providedIn: 'root'
})
export class ParticipanteService {

  constructor(private readonly apiService: ApiService) {}

  private readonly route = 'participantes';

  async salvarParticipante(dados: any) {
    return await this.apiService.post(this.route, dados);
  }

  async atualizarParticipante(id: any, dados: any) {
    return await this.apiService.put(`${this.route}/${id}`, dados, null);
  }

  async deletarParticipante(id: any,) {
    return await this.apiService.delete(`${this.route}/${id}`, id );
  }

  async obterTodosParticipantes() {
    return await this.apiService.get(this.route);
  }

  async obterParticipantePorId(id: any) {
    return await this.apiService.get(`${this.route}/${id}`);
  }

  async deletarTodosParticipantes(id:any) {
    const route = `${this.route}/all`;
    return await this.apiService.delete(route, id);
  }

  async obterParticipantesPorNome(nome: string) {
    const route = `${this.route}/findByNome`;
    return await this.apiService.get(route, { params: { nome } });
  }

  async obterParticipantesPorMatricula(matricula: string) {
    const route = `${this.route}/findByMatricula`;
    return await this.apiService.get(route, { params: { matricula } });
  }

  async obterParticipantesPorCurso(curso: string) {
    const route = `${this.route}/findByCurso`;
    return await this.apiService.get(route, { params: { curso } });
  }
}

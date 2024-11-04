// campeonato.service.ts
import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from '../environment';
import { ApiService } from '../api/api.service';

@Injectable({
  providedIn: 'root'
})
export class CampeonatoService {

  constructor(private readonly apiService: ApiService){}

  private readonly route='campeonatos'

  async obterCampeonatos() {
    return await this.apiService.get(this.route);
  }

  async criarCampeonato(dados: any) {
    return await this.apiService.post(this.route, dados);
  }

  async atualizarCampeonato(id:any, data:any) {
    return await this.apiService.put(this.route, id, data)
  }

  async deletarCampeonato(id:any,) {
    return await this.apiService.delete(this.route, id, )
  }
  
  async obterCampeonatoPorId(id:any,) {
    return await this.apiService.get(this.route, id,)
  }

  async obterCampeonatoPorNome(nome:string, ) {
    const route=`${this.route}/nome`
    return await this.apiService.get( route, nome, )
  }
}


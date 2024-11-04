// inscricao.service.ts
import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from '../environment';
import { ApiService } from '../api/api.service';



@Injectable({
  providedIn: 'root'
})
export class InscricaoService {
   private readonly route='inscricoes'
   constructor(private readonly apiService:ApiService){}

  async obterInscricoes() {
    return await this.apiService.get(this.route);
  }

  async obterInscricaoPorId(id: any) {
    return await this.apiService.get(this.route, id);
  }

  async criarInscricao(dados: any) {
    return await this.apiService.post(this.route, dados );
  }

  async atualizarInscricao(id: any, dados:any) {
    return await this.apiService.put(this.route, dados, id );
  }

  async deletarInscricao(id: any,) {
    return await this.apiService.delete(this.route, id );
  }
}
 
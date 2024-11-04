// principal.service.ts
import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from '../environment';

@Injectable({
  providedIn: 'root'
})
export class PrincipalService {
  private apiUrl = `${environment.apiUrl}/principal`;

  async obterDadosPrincipais() {
    return await axios.get(this.apiUrl);
  }
}

// login.service.ts
import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private apiUrl = `${environment.apiUrl}/login`;

  async login(usuario: string, senha: string) {
    return await axios.get(`${this.apiUrl}?usuario=${usuario}&senha=${senha}`);
  }
}

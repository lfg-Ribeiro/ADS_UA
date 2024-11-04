// login.service.ts
import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from '../environment';
import { ApiService } from '../api/api.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private readonly route='autenticacao'

  constructor(private readonly apiService:ApiService){

  }
  async login(username: string, password: string ) {
    const route=`${this.route}/login`
    return await this.apiService.login(route, username,password);
  }
  async User(username: string, password: string ) {
    const route=`${this.route}/user`
    return await this.apiService.login(route, username,password);
  }
  async admin(username: string, password: string ) {
    const route=`${this.route}/admin`
    return await this.apiService.login(route, username,password);
  }
 
}


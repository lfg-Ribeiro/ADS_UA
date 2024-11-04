// login.service.ts
import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from '../environment';
import { ApiService } from '../api/api.service';

@Injectable({
  providedIn: 'root'
})
export class RegistrarService {
  private readonly route='autenticacao'

  constructor(private readonly apiService:ApiService){

  }
  async registrar(data: any, ) {
    const route=`${this.route}/register`
    return await this.apiService.post(route, data);
  }

}


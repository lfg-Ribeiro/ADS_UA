import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pessoa } from '../models/pessoa';

@Injectable({
  providedIn: 'root'
})
export class PessoaserviceService {

  http = inject(HttpClient);

    API = "http://localhost:8080/pessoa";

    findAll(): Observable<Pessoa[]>{
      return this.http.get<Pessoa[]>(this.API);
    }

  constructor() { }
}

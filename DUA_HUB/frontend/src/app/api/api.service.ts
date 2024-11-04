import { Injectable } from '@angular/core';
import axios, { AxiosInstance } from 'axios';
import { environment } from '../environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private axiosInstance: AxiosInstance;

  constructor() {
    this.axiosInstance = axios.create({
      baseURL: environment.apiUrl,
      timeout: 5000, 
    });
  }

  get(route: string, params?: any) {
    return this.axiosInstance.get(route, { params })
      .then(response => response.data)
      .catch(this.handleError);
  }

  getById(route: string, id: string | number) {
    return this.get(`${route}/${id}`);
  }

  post(route: string, data: any) {
    return this.axiosInstance.post(route, data)
      .then(response => response.data)
      .catch(this.handleError);
  }

  put(route: string, id: string | number, data: any) {
    return this.axiosInstance.put(`${route}/${id}`, data)
      .then(response => response.data)
      .catch(this.handleError);
  }

  delete(route: string, id: string | number) {
    return this.axiosInstance.delete(`${route}/${id}`)
      .then(response => response.data)
      .catch(this.handleError);
  }

  login(route: string, username: string, password: string) {
    const params = new URLSearchParams();
    params.append('username', username);
    params.append('password', password);
  
    return this.axiosInstance.get(`${route}?${params.toString()}`)
      .then(response => {
        if (response.data ) {
          localStorage.setItem('isLogger', 'true'); 
        }
        return response.data;
      })
      .catch(this.handleError);
  }
  

  private handleError(error: any) {
    console.error('Erro na requisição:', error);
    throw error;
  }
}

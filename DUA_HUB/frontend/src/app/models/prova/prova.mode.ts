// participante.model.ts
export interface Participante {
    id: number;
    nome: string;
    // Adicione outros atributos que o Participante pode ter
  }
  
  // prova.model.ts
  import { Participante } from './participante.model';
  
  export interface Prova {
    id: number;
    nome: string;
    data: string; // Use 'string' para representar LocalDateTime, você pode converter isso em um objeto Date no front-end
    local: string;
    participantes: Participante[];
  }
  
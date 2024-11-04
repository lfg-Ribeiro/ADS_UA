import { Participante } from './participante.model';
import { Prova } from './prova.model';

export interface Inscricao {
  id: number;
  participante: Participante;
  prova: Prova;
  dataInscricao: string; // LocalDateTime pode ser representado como uma string ISO (ex.: "2024-11-04T10:15:30")
  status: string;
}

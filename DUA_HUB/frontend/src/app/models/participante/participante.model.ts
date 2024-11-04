export interface Participante {
    id: number;
    nome: string;
    matricula?: string; // Opcional, pois não possui a anotação @NotNull no backend
    curso?: string;     // Opcional, pois não possui a anotação @NotNull no backend
    telefone?: string;  // Opcional, pois não possui a anotação @NotNull no backend
  }
  
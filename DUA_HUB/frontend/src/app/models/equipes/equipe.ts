export class Equipe {
    id!: number;
  nome!: string;
  participantes!: string;
  projeto!: string;

  constructor(id: number, nome: string, participantes: string, projeto: string) {
    this.id = id;
    this.nome = nome;
    this.participantes = participantes;
    this.projeto = projeto;
  }

}

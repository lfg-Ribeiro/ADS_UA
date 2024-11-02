export class Campeonato {
    id!: number;
  nome!: string;
  equipes!: string;
  vencedor!: string;

  constructor(id: number, nome: string, equipes: string, vencedor: string) {
    this.id = id;
    this.nome = nome;
    this.equipes = equipes;
    this.vencedor = vencedor;
}
}

export class Pessoa {
    id!: number;
    nome!: string;
    documento!: string;
    email!: string;

    constructor(id: number, nome: string, documento: string, email: string) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.email = email;
    }
}

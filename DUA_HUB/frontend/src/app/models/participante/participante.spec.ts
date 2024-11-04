import { Participante } from './participante.model';

describe('Participante', () => {
  let participante: Participante;

  beforeEach(() => {
    // Instanciando o objeto antes de cada teste
    participante = new Participante();
  });

  it('should create an instance', () => {
    expect(participante).toBeTruthy(); // Verifica se o objeto foi criado
  });

  it('should set and get properties correctly', () => {
    // Supondo que o modelo tenha propriedades como `id`, `nome`, etc.
    participante.id = 1;
    participante.nome = 'João';

    expect(participante.id).toBe(1); // Verifica se o id foi definido corretamente
    expect(participante.nome).toBe('João'); // Verifica se o nome foi definido corretamente
  });

  // Você pode adicionar mais testes aqui para validar outros comportamentos ou métodos da classe
});

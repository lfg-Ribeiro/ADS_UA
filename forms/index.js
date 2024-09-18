document.getElementById("cadastroForm").addEventListener("submit", function (event) {
    event.preventDefault();
    if (validateForm()) {
    }
});

document.getElementById("buscarCep").addEventListener("click", function () {
    const cep = document.getElementById("cep").value;
    fetch(`https://viacep.com.br/ws/${cep}/json/`)
        .then(response => response.json())
        .then(data => {
            document.getElementById("endereco").value = data.logradouro;
        })
        .catch(error => console.error(error));
});

document.getElementById("cadastroForm").addEventListener("submit", function (event) {
    event.preventDefault();
    if (validateForm()) {
        sendEmail();
    }
});

function sendEmail() {
    const nome = document.getElementById("nome").value;
    const cpf = document.getElementById("cpf").value;
    const idade = document.getElementById("idade").value;
    const email = document.getElementById("email").value;
    const cep = document.getElementById("cep").value;
    const endereco = document.getElementById("endereco").value;
    const sexo = document.getElementById("sexo").value;
    const dataNascimento = document.getElementById("dataNascimento").value;
    const mensagem = document.getElementById("mensagem").value;

    const emailContent = `
    Nome: ${nome}
    CPF: ${cpf}
    Idade: ${idade}
    E-mail: ${email}
    CEP: ${cep}
    Endereço: ${endereco}
    Número: ${numero} 
    Sexo: ${sexo}
    Data de Nascimento: ${dataNascimento}
    Mensagem: ${mensagem}
    `;
    console.log("Dados do formulário a serem enviados por e-mail:");
    console.log(emailContent);
}

function validateForm() {
    const nome = document.getElementById("nome").value;
    const cpf = document.getElementById("cpf").value;
    const idade = document.getElementById("idade").value;
    const email = document.getElementById("email").value;
    const cep = document.getElementById("cep").value;
    const endereco = document.getElementById("endereco").value;
    const numero = document.getElementById("numero").value;
    const sexo = document.getElementById("sexo").value;
    const dataNascimento = document.getElementById("dataNascimento").value;
    const mensagem = document.getElementById("mensagem").value;

    return true;
}
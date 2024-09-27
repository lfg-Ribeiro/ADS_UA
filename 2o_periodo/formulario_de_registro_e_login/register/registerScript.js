function register(element) {
    // Obtém os valores inseridos nos campos de entrada
    const user = document.getElementById("user").value;
    const pass = document.getElementById("pass").value;
    const passConfirm = document.getElementById("passConfirm").value;
    const errorMessage = document.getElementById("error-message");

    // Limpa qualquer erro visual anterior antes de uma nova validação
    document.getElementById("user").classList.remove("error");
    document.getElementById("pass").classList.remove("error");
    document.getElementById("passConfirm").classList.remove("error");
    errorMessage.style.display = "none"; // Oculta a mensagem de erro
    errorMessage.textContent = ""; // Limpa o texto da mensagem de erro

    let hasError = false; // Variável para rastrear se há erros

    // Valida o campo de usuário
    if (user === "") {
        document.getElementById("user").classList.add("error");
        hasError = true; 
    }

    // Valida os campos de senha
    if (pass === "" || passConfirm === "") {
        document.getElementById("pass").classList.add("error");
        document.getElementById("passConfirm").classList.add("error");
        errorMessage.textContent = "O campo senha não deve ficar vazio";
        errorMessage.style.display = "block";
        hasError = true;
    } else if (pass !== passConfirm) {
        // Verifica se as senhas são iguais
        document.getElementById("pass").classList.add("error");
        document.getElementById("passConfirm").classList.add("error");
        errorMessage.textContent = "As senhas digitadas não conferem!";
        errorMessage.style.display = "block";
        hasError = true;
    }

    // Se não houver erros, prossegue com o registro
    if (!hasError) {
        alert("Usuário " + user + " registrado com sucesso!!");

        // Limpa os campos após o registro bem-sucedido
        document.getElementById("user").value = "";
        document.getElementById("pass").value = "";
        document.getElementById("passConfirm").value = "";
    }
}

function register(element) {
    const user = document.getElementById("user").value;
    const pass = document.getElementById("pass").value;
    const passConfirm = document.getElementById("passConfirm").value;
    const errorMessage = document.getElementById("error-message");

    // Limpa os erros visuais antes de nova validação
    document.getElementById("user").classList.remove("error");
    document.getElementById("pass").classList.remove("error");
    document.getElementById("passConfirm").classList.remove("error");
    errorMessage.style.display = "none";
    errorMessage.textContent = "";

    let hasError = false;

    if (user === "") {
        document.getElementById("user").classList.add("error");
        hasError = true;
    }

    if (pass === "" || passConfirm === "") {
        document.getElementById("pass").classList.add("error");
        document.getElementById("passConfirm").classList.add("error");
        errorMessage.textContent = "O campo senha não deve ficar vazio";
        errorMessage.style.display = "block";
        hasError = true;
    } else if (pass !== passConfirm) {
        document.getElementById("pass").classList.add("error");
        document.getElementById("passConfirm").classList.add("error");
        errorMessage.textContent = "As senhas digitadas não conferem!";
        errorMessage.style.display = "block";
        hasError = true;
    }

    if (!hasError) {
        alert("Usuário " + user + " registrado com sucesso!!");

        // Limpa os campos após registro bem-sucedido
        document.getElementById("user").value = "";
        document.getElementById("pass").value = "";
        document.getElementById("passConfirm").value = "";
    }
}
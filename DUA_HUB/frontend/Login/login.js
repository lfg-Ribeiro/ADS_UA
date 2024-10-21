function redirectToRegister(){
    window.location.href=`../Registro/regis.html`
}

function login(){
    localStorage.setItem(`logged`, `true`)
    window.location.href=`../Admin/adm.html`
}

function checklogin(){

    const isLogged=localStorage.getItem(`logged`)
    if (isLogged!==`true`)
     window.location.href=`../Login/login.html`
    
}

window.onload=checklogin
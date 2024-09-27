const main = document.querySelector("main");
const root = document.querySelector(":root");
const input = document.getElementById("input");
const resultInput = document.getElementById("result");
const historyc = document.getElementById('historyc');

const historyCalculate = [];
const allowedKeys = ["(", ")", "/", "*", "-", "+", "9", "8", "7", "6", "5", "4", "3", "2", "1", "0", ".", "%", " "];

input.addEventListener('keydown', function (ev) {
    ev.preventDefault();
    if (allowedKeys.includes(ev.key)) {
        input.value += ev.key;
        return;
    }
    if (ev.key === 'Backspace') {
        input.value = input.value.slice(0, -1);
    }
    if (ev.key === 'Enter') {
        calculate();
    }
});

function calculate() {
    try {
        const result = eval(input.value);
        resultInput.value = result;
        resultInput.classList.remove('error');
        historyCalculate.push({ calc: input.value, result: result });
        addToHistoryc();
    } catch (e) {
        resultInput.value = 'ERRO';
        resultInput.classList.add('error');
    }
}

document.querySelectorAll('.charKey').forEach(function (charKeyBtn) {
    charKeyBtn.addEventListener('click', function () {
        const value = charKeyBtn.dataset.value;
        input.value += value;
    });
});

document.getElementById('clear').addEventListener('click', function () {
    input.value = '';
    input.focus();
});

document.getElementById('equal').addEventListener('click', calculate);

document.getElementById('themeSwitcher').addEventListener('click', function () {
    if (main.dataset.theme === 'dark') {
        root.style.setProperty('--bg-color', '#ffffff'); // Fundo branco
        root.style.setProperty('--border-color', '#aaa'); 
        root.style.setProperty('--primary-color', '#4aa4ff'); // Botões azul celeste
        root.style.setProperty('--font-color', '#000000'); // Texto preto
        main.dataset.theme = 'light';
    } else {
        root.style.setProperty('--bg-color', '#000000'); // Fundo preto
        root.style.setProperty('--border-color', '#666'); 
        root.style.setProperty('--primary-color', '#4aa4ff'); // Botões azul celeste
        root.style.setProperty('--font-color', '#ffffff'); // Texto branco
        main.dataset.theme = 'dark';
    }
});

document.getElementById('copyToClipboard').addEventListener('click', function (ev) {
    const button = ev.currentTarget;

    if (button.innerText === 'Copiar') {
        button.innerText = 'Copiado!';
        button.classList.add('success');
        navigator.clipboard.writeText(resultInput.value);
    }
    setTimeout(function () {
        button.innerText = 'Copiar';
        button.classList.remove('success');
    }, 1000);
});

document.getElementById('historySect').addEventListener('click', function () {
    historyc.style.display = (historyc.style.display === "none") ? "block" : "none";
});

function addToHistoryc() {
    // Limpa o histórico antes de adicionar novos cálculos
    historyc.innerHTML = '';
    historyCalculate.forEach((op) => {
        const newDiv = document.createElement('div');
        newDiv.className = 'operation';
        const newH1 = document.createElement('h1');
        newH1.innerText = op.calc;
        const newH2 = document.createElement('h2');
        newH2.innerText = op.result;

        newDiv.append(newH1, newH2);
        historyc.appendChild(newDiv);
    });
}

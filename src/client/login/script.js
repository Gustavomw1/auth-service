let token = null;
let userId = null;

async function login() {
    const username = document.getElementById('login-username').value;
    const password = document.getElementById('login-password').value;

    try {
        const res = await fetch('http://localhost:8080/api/auth/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username, password })
        });

        const data = await res.json();

        if (res.ok) {
            userId = data.id;
            token = data.token;

            localStorage.setItem('userId', userId);
            localStorage.setItem('token', token);

            showToast('Logado como ' + data.username);
        } else {
            showToast('Erro: ' + (data.message || JSON.stringify(data)));
        }
    } catch (error) {
        showToast('Erro ao fazer login: ' + error.message);
    }
}

function showToast(message) {
    const toast = document.getElementById('toast');
    toast.textContent = message;
    toast.classList.add('show');
    setTimeout(() => {
        toast.classList.remove('show');
    }, 3000);
}

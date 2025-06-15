let token = null;
let userId = null;

async function register() {
    const user = document.getElementById('reg-user').value;
    const username = document.getElementById('reg-username').value;
    const password = document.getElementById('reg-password').value;

    try {
        const res = await fetch('http://localhost:8080/api/auth/register', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ user, username, password })
        });

        const result = await res.text();
        alert(result);

        if (res.ok) {
            // Redireciona para a tela de login
            window.location.href = '../login/login.html';
        }
    } catch (error) {
        alert('Erro ao registrar: ' + error.message);
    }
}

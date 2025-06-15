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

            // Salvar no localStorage
            localStorage.setItem('userId', userId);
            localStorage.setItem('token', token);

            alert('Logado como ' + data.username);

            // Redirecionar conforme role
            if (data.role === 'ADMIN') {
                window.location.href = '../adm/adm.html';
            } else {
                window.location.href = '../cliente/cliente.html';
            }
        } else {
            alert('Erro: ' + data.message || JSON.stringify(data));
        }
    } catch (error) {
        alert('Erro ao fazer login: ' + error.message);
    }
}

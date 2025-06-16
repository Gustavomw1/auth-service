let token = null;
let userId = null;

async function register() {
    const username = document.getElementById('reg-username').value;
    const password = document.getElementById('reg-password').value;
    const user = document.getElementById('reg-user').value;

    try {
        const res = await fetch('http://localhost:8080/api/auth/register', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username, password, user })
        });

        const result = await res.text();
        showToast(result);

        if (res.ok) {
            setTimeout(() => {
                window.location.href = '../login/login.html';
            }, 2000);
        }
    } catch (error) {
        showToast('Erro ao registrar: ' + error.message);
    }
}

function showToast(message) {
    const toast = document.getElementById('toast');
    toast.textContent = message;
    toast.classList.add('show');
    setTimeout(() => {
        toast.classList.remove('show');
    }, 6000);
}

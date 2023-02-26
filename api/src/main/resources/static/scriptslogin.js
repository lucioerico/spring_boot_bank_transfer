// Seleciona os elementos HTML relevantes
const modal = document.getElementById("modal");
const loginForm = document.getElementById("loginForm");

// Adiciona um evento de clique ao botão de login
document.getElementById("btnOpenModal").addEventListener("click", function() {
  modal.style.display = "block";
});

// Adiciona um evento de clique ao botão de fechar da janela modal
document.getElementById("btnCloseModal").addEventListener("click", function() {
  modal.style.display = "none";
});

// Adiciona um evento de envio ao formulário de login
loginForm.addEventListener("submit", function(event) {
  event.preventDefault();

  // Obtém as informações de login do formulário
  const formData = new FormData(loginForm);
  const username = formData.get("username");
  const password = formData.get("password");

  // Cria um objeto com as informações de login
  const loginData = { login: username, senha: password };

  // Envia as informações de login para o backend
  fetch("/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(loginData)
  })
  .then(response => {
    // Verifica se a autenticação foi bem-sucedida
    if (response.ok) {
      // Armazena o token de autenticação no local storage
      response.json().then(data => {
        const token = data.tokenJWT;
        localStorage.setItem('tokenJWT', token);
        // Redireciona para a página de produtos
        const url = new URL("http://localhost:8080/produto/crud");
        url.searchParams.set("tokenJWT", token);
        window.location.href = url.toString();
      });
      // Fecha a janela modal
      modal.style.display = "none";
    } else {
      // Exibe uma mensagem de erro caso a autenticação tenha falhado
      alert("Não foi possível fazer o login. Tente novamente.");
    }
  })
  .catch(error => {
    console.error(error);
  });
});


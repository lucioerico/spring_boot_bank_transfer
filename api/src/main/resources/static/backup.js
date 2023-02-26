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
               // Armazena o token de autenticação no local storage
               alert("Login feito com sucesso.");
               response.text().then(token => {
                 localStorage.setItem('token', token);
                 // Redireciona para a página de produtos
                 const url = new URL("http://localhost:8080/produto");
                 url.searchParams.set(token);
                 window.location.href = url.toString();
               });
               // Fecha a janela modal
               modal.style.display = "none";


          } else {
            // Exibe uma mensagem de erro caso a autenticação tenha falhado
            alert("Login falhou. Tente novamente.");
          }
        })
        .catch(error => {
          console.error(error);
        });
      });
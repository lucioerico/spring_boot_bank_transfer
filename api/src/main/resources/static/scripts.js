<!-- Consultar clientes -->
        function consultarClientes() {
            limparConteudo();

            fetch('/clientes/listar')
                .then(response => response.json())
                .then(clientes => {
                    var tabela = document.createElement('table');
                    tabela.innerHTML = '<tr><th>CPF</th><th>Nome</th></tr>';
                    clientes.forEach(cliente => {
                        var linha = document.createElement('tr');
                        linha.innerHTML = '<td>' + cliente.cpf + '</td><td>' + cliente.nome + '</td>';
                        tabela.appendChild(linha);
                    });
                    document.body.appendChild(tabela);
                });
        }
        <!-- Consultar contas -->

        function consultarContas() {
            limparConteudo();

            fetch('/contas/listar')
                .then(response => response.json())
                .then(contas => {
                    var tabela = document.createElement('table');
                    tabela.innerHTML = '<tr><th>Cpf</th><th>Agencia</th><th>Conta</th><th>Saldo</th></tr>';
                    contas.forEach(conta => {
                        var linha = document.createElement('tr');
                        linha.innerHTML = '<td>' + conta.cpf + '</td><td>' + conta.agencia + '</td><td>' + conta.nconta + '</td><td>' + conta.saldo + '</td>';
                        tabela.appendChild(linha);
                    });
                    document.body.appendChild(tabela);
                });
        }

 <!-- Mostrar formuário de transferência -->
        function mostrarFormulario() {
        var formulario = document.getElementById('formTransferenciaSaldo');
        formulario.style.display = 'block';
		}

 <!-- Função transferir -->

		function transferir() {
        var formulario = document.getElementById('formTransferenciaSaldo');
        var dados = new FormData(formulario);

        const jsonData = {
        origem: {
        cpf: dados.get('cpfOrigem'),
        agencia: dados.get('agenciaOrigem'),
        nconta: dados.get('ncontaOrigem'),
        valorTransferencia: Number(dados.get('valorTransferencia')),
        operacao: Number(dados.get('operacao'))
        },
        destino: {
        cpf: dados.get('cpfDestino'),
        agencia: dados.get('agenciaDestino'),
        nconta: dados.get('ncontaDestino')
        }
        };

        fetch('/transferencias/transferir', {
        method: 'POST',
        headers: {
        'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonData)
        })
        .then(response => {
         if (response.ok) {
      response.text().then(mensagem => {
        alert(mensagem);
      });
    } else {
      response.text().then(mensagem => {
        alert(mensagem);
      });
    }
  })
  .catch(error => {
    console.error('Ocorreu um erro ao tentar realizar a transferência:', error);
    alert('Ocorreu um erro ao tentar realizar a transferência!');
  });

    formulario.reset();
    formulario.style.display = 'none';
	}

	var botaoTransferir = document.getElementById('btnTransferir');
	botaoTransferir.addEventListener('click', mostrarFormulario);

	var formulario = document.getElementById('formTransferenciaSaldo');
	formulario.addEventListener('submit', function(event) {
    event.preventDefault();
    transferir();
	});

<!-- Mostrar formulário de cadastro de cliente -->

function mostrarFormularioCliente() {
var formulario = document.getElementById('formCadastroCliente');
formulario.style.display = 'block';
}

<!-- Função cadastrar cliente -->

function cadastrarCliente() {
var formulario = document.getElementById('formCadastroCliente');
var formData = new FormData(formulario);

const jsonData = {
nome: formData.get('nome'),
cpf: formData.get('cpf'),
senha: formData.get('senha')
};

fetch('/clientes/criar', {
method: 'POST',
headers: {
'Content-Type': 'application/json'
},
body: JSON.stringify(jsonData)
})
.then(response => {
if (response.ok) {
response.text().then(mensagem => {
alert(mensagem);
});
} else {
response.text().then(mensagem => {
alert(mensagem);
});
}
})
.catch(error => {
console.error('Ocorreu um erro ao tentar cadastrar o cliente:', error);
alert('Ocorreu um erro ao tentar cadastrar o cliente!');
});
  formulario.reset();
  formulario.style.display = 'none';
}
var botaoCadastrar = document.getElementById('btnCadastrarCliente');
botaoCadastrar.addEventListener('click', mostrarFormularioCliente);

var formularioCadastroCliente = document.getElementById('formCadastroCliente');
formularioCadastroCliente.addEventListener('submit', function(event) {
event.preventDefault();
cadastrarCliente();
});



        <!-- Limpa conteúdo -->

        function limparConteudo() {
            // Remove a tabela, se existir
            var tabela = document.querySelector('table');
            if (tabela) {
                tabela.remove();
            }
        }

        <!-- Mostrar formulário de cadastro de conta -->

        function mostrarFormularioConta() {
        var formulario = document.getElementById('formCadastroConta');
        formulario.style.display = 'block';
        }


<!-- Função cadastrar conta -->

function cadastrarConta() {
var formulario = document.getElementById('formCadastroConta');
var formData = new FormData(formulario);

const jsonData = {
agencia: formData.get('agencia'),
cpf: formData.get('cpf'),
nconta: formData.get('nconta'),
saldo: Number(formData.get('saldo'))
};

fetch('/contas/criar', {
method: 'POST',
headers: {
'Content-Type': 'application/json'
},
body: JSON.stringify(jsonData)
})
.then(response => {
if (response.ok) {
response.text().then(mensagem => {
alert(mensagem);
});
} else {
response.text().then(mensagem => {
alert(mensagem);
});
}
})
.catch(error => {
console.error('Ocorreu um erro ao tentar cadastrar o cliente:', error);
alert('Ocorreu um erro ao tentar cadastrar o cliente!');
});
  formulario.reset();
  formulario.style.display = 'none';
}

var botaoCadastrar = document.getElementById('btnCadastrarConta');
botaoCadastrar.addEventListener('click', mostrarFormularioConta);

var formularioCadastroConta = document.getElementById('formCadastroConta');
formularioCadastroConta.addEventListener('submit', function(event) {
  event.preventDefault();
  cadastrarConta();
});


<!-- Logout -->

           function logout() {
                   const logoutUrl = "http://localhost:8080/logout";
                   window.location.href = logoutUrl;
                 }

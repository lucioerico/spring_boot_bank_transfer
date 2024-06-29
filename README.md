<!-- Início do README.md -->

<h1 align="center">Projeto Spring Boot</h1>

<p align="center">Este é um projeto de demonstração da API REST para operações de PIX, TED E DOC, desenvolvido entre os dias 15 e 28 de fevereiro, para fins de estudo do Spring Boot, com conceitos do mercado financeiro. Espero que gostem do código e, caso tenham algum feedback para melhorias, ficarei muito grato em recebê-lo.
</p>

<h2>Pré-requisitos</h2>

<ul>
  <li>Git</li>
  <li>Java 17</li>
  <li>Maven</li>
</ul>

<h2>Instalação</h2>

<p>Para instalar a aplicação, siga os seguintes passos:</p>

<ol>
  <li>Clone o repositório usando o Git:</li>
</ol>

<pre><code>git clone https://github.com/lucioerico/spring_boot_bank_transfer.git
</code></pre>

<ol start="2">
  <li>Execute o comando Maven <code>clean install</code> na pasta raiz do projeto para baixar as dependências e compilar o código:</li>
</ol>

<pre><code>
mvn clean install -DskipTests
</code></pre>

<h2>Execução</h2>

<p>Para executar a aplicação, execute o comando Maven <code>spring-boot:run</code> na pasta raiz do projeto:</p>

<pre><code>mvn spring-boot:run
</code></pre>

<p>A aplicação estará disponível em <a href="http://localhost:8080">http://localhost:8080</a>.</p>

<h2>Login</h2>

<p>Este projeto utiliza o framework Spring Security, o login de teste pode ser feito com os seguintes dados:</p>

<p>USER: itau</p>
<p>PASSWORD: Senh@023</p>

<h2>Tecnologias</h2>

<p>As seguintes tecnologias foram utilizadas no desenvolvimento da API Rest do projeto:</p>

<ul>
  <li>[Java 17](https://www.oracle.com/java)</li>
  <li>[Spring Boot ](https://spring.io/projects/spring-boot)</li>
  <li>[Maven](https://maven.apache.org)</li>
  <li>[Hibernate](https://hibernate.org)</li>
  <li>[Lombok](https://projectlombok.org)</li>
  <li>[H2 Database Engine](https://www.h2database.com)</li>
</ul>

<h2>Banco de Dados</h2>

<p>Para realização do teste, segue os dados do banco de dados</p>

<h3>Dados Clientes</h3>
<table>
  <thead>
    <tr>
      <th>Nome</th>
      <th>CPF</th>
      <th>Senha(criptografada)</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Cliente 2</td>
      <td>40464605040</td>
      <td>$2a$10$bfkagE/FzcMgdC7t6V8aK.8093qHme0a7YMYe/hdo1gnpUM2JZ9pK</td>
    </tr>
    <tr>
      <td>Cliente 3</td>
      <td>80714091030</td>
      <td>$2a$10$bfkagE/FzcMgdC7t6V8aK.8093qHme0a7YMYe/hdo1gnpUM2JZ9pK</td>
    </tr>
    <tr>
      <td>Cliente 4</td>
      <td>47232921012</td>
      <td>$2a$10$bfkagE/FzcMgdC7t6V8aK.8093qHme0a7YMYe/hdo1gnpUM2JZ9pK</td>
    </tr>
    <tr>
      <td>Cliente 5</td>
      <td>46189049095</td>
      <td>$2a$10$bfkagE/FzcMgdC7t6V8aK.8093qHme0a7YMYe/hdo1gnpUM2JZ9pK</td>
    </tr>
    <tr>
      <td>Cliente 6</td>
      <td>50759334080</td>
      <td>$2a$10$bfkagE/FzcMgdC7t6V8aK.8093qHme0a7YMYe/hdo1gnpUM2JZ9pK</td>
    </tr>
    <tr>
      <td>Cliente 7</td>
      <td>65813400060</td>
      <td>$2a$10$bfkagE/FzcMgdC7t6V8aK.8093qHme0a7YMYe/hdo1gnpUM2JZ9pK</td>
    </tr>
  </tbody>
</table>
    
<h3>Dados Contas</h3>
    <table>
  <thead>
    <tr>
      <th>Agência</th>
      <th>Número da conta</th>
      <th>Saldo</th>
      <th>CPF</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>001</td>
      <td>00002-1</td>
      <td>00.00</td>
      <td>40464605040</td>
    </tr>
    <tr>
      <td>002</td>
      <td>00003-1</td>
      <td>00.00</td>
      <td>80714091030</td>
    </tr>
    <tr>
      <td>003</td>
      <td>00004-1</td>
      <td>0</td>
      <td>47232921012</td>
    </tr>
    <tr>
      <td>004</td>
      <td>00005-1</td>
      <td>200000000</td>
      <td>46189049095</td>
    </tr>
    <tr>
      <td>005</td>
      <td>00006-1</td>
      <td>0</td>
      <td>50759334080</td>
    </tr>
    <tr>
      <td>006</td>
      <td>00007-1</td>
      <td>0</td>
      <td>50759334080</td>
    </tr>
    <tr>
      <td>007</td>
      <td>00008-1</td>
      <td>00.00</td>
      <td>65813400060</td>
    </tr>
  </tbody>
</table>

<h2>Tipos de dados</h2>
  <p>Abaixo segue a relação de dados e os seus tipos:</p>
  
  <h3>Dados</h3>
<table>
  <thead>
    <tr>
      <th>Atributo</th>
      <th>Tipo</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Nome</td>
      <td>String</td>
    </tr>
    <tr>
      <td>CPF</td>
      <td>String</td>
    </tr>
    <tr>
      <td>Senha</td>
      <td>String</td>
    </tr>
    <tr>
      <td>Agência</td>
      <td>String</td>
    </tr>
    <tr>
      <td>Número da Conta (nconta)</td>
      <td>String</td>
    </tr>
    <tr>
      <td>Saldo</td>
      <td>BigDecimal</td>
    </tr>
    <tr>
      <td>Valor Transferência (valorTransferencia)</td>
      <td>BigDecimal</td>
    </tr>
  </tbody>
</table>
    
<h2>Regras de cadastro</h2>
   
    
<ul>
  <li>Para cadastrar uma conta, é necessário ter o cliente cadastrado primeiro, o sistema não aceita conta sem cliente</li>
  <li>Ao cadastrar cliente, é gerado automaticamente um usuario, sendo o login o CPF.</li>
  <li>Para acessar o banco de dados diretamente você pode procurar o arquivo database.sql ou localhost:8080/h2-console (login é sa, e não tem senha)</li>
</ul>
    


<h2>ROADMAP</h2>
    
<p>Segue abaixo as futuras implementações pensadas para o projeto</p>
    
<ul>
  <li>Aperfeiçoar o tratamento de erros</li>
  <li>Aprimorar a segurança com habilitação de token por tempo</li>
  <li>Criar niveis de acesso</li>
  <li>Transferências ao serem realizadas por cliente, terem como padrão o login como conta de origem</li>
  <li>Implementação de JUnit</li>
</ul>
    

<!-- Fim do README.md -->

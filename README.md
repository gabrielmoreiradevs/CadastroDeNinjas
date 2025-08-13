<h1>🥷 Sistema de Cadastro de Ninjas</h1>

<p>Bem-vindo ao repositório do <strong>Sistema de Cadastro de Ninjas</strong>!</p>
<p>Este projeto está sendo desenvolvido como parte do meu aprendizado no curso de Spring Boot, com o objetivo de aplicar conceitos fundamentais de desenvolvimento de APIs REST com Java.</p>

<h2>🚀 Sobre o Projeto</h2>
<p>O <strong>Sistema de Cadastro de Ninjas</strong> é uma aplicação web construída em <strong>arquitetura em camadas</strong> utilizando <strong>Spring Boot</strong>, com foco em boas práticas de desenvolvimento, versionamento de código e organização de banco de dados.</p>

<h3>🧭 Funcionalidades</h3>
<ul>
  <li>Cadastro de ninjas com:
    <ul>
      <li>Nome</li>
      <li>Idade</li>
      <li>E-mail</li>
      <li>Rank</li>
    </ul>
  </li>
  <li>Cadastro de missões com:
    <ul>
      <li>Título</li>
      <li>Descrição</li>
    </ul>
  </li>
  <li>Atribuição de <strong>uma missão por ninja</strong></li>
  <li>Uma <strong>missão pode ser atribuída a múltiplos ninjas</strong></li>
</ul>

<h2>🛠️ Tecnologias e Ferramentas</h2>
<ul>
  <li><strong>Spring Boot</strong> – Framework principal para construção da API</li>
  <li><strong>Spring Data JPA</strong> – Interação com o banco de dados via ORM</li>
  <li><strong>H2 Database</strong> – Banco de dados em memória, ideal para testes</li>
  <li><strong>Flyway</strong> – Gerenciamento de versionamento/migração de banco de dados</li>
  <li><strong>Maven</strong> – Gerenciador de dependências e build</li>
  <li><strong>Git & GitHub</strong> – Controle e hospedagem do código-fonte</li>
  <li><strong>Docker</strong> – Para build e execução externa do banco de dados (em aulas extras)</li>
  <li><strong>SQL</strong> – Criação e manipulação do banco de dados</li>
</ul>

<h2>🧩 Modelagem de Dados</h2>

<h3>🥷 Ninja</h3>
<table>
  <thead>
    <tr><th>Campo</th><th>Tipo</th><th>Descrição</th></tr>
  </thead>
  <tbody>
    <tr><td>id</td><td>Long</td><td>Identificador único</td></tr>
    <tr><td>nome</td><td>String</td><td>Nome do ninja</td></tr>
    <tr><td>idade</td><td>int</td><td>Idade do ninja</td></tr>
    <tr><td>email</td><td>String</td><td>E-mail do ninja</td></tr>
    <tr><td>rank</td><td>String</td><td>Rank (graduação)</td></tr>
  </tbody>
</table>

<h3>🎯 Missão</h3>
<table>
  <thead>
    <tr><th>Campo</th><th>Tipo</th><th>Descrição</th></tr>
  </thead>
  <tbody>
    <tr><td>id</td><td>Long</td><td>Identificador único</td></tr>
    <tr><td>titulo</td><td>String</td><td>Título da missão</td></tr>
    <tr><td>descricao</td><td>String</td><td>Descrição da missão</td></tr>
  </tbody>
</table>

<h3>🔄 Relacionamento</h3>
<ul>
  <li>Um <strong>ninja</strong> pode estar em <strong>apenas uma missão</strong></li>
  <li>Uma <strong>missão</strong> pode conter <strong>vários ninjas</strong></li>
</ul>

<h2>📁 Estrutura do Projeto</h2>

<pre>
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── meuProjeto/
│   │           ├── controller/
│   │           ├── model/
│   │           ├── repository/
│   │           ├── service/
│   │           └── dto/
│   └── resources/
│       ├── application.properties
│       └── db/migration/
│           └── V1__create_tables.sql
</pre>

<h2>📌 Observações</h2>
<ul>
  <li>Este projeto está em desenvolvimento contínuo conforme avanço no curso.</li>
  <li>Em breve, pretendo adicionar testes automatizados, validações e tratamento de erros.</li>
  <li>As migrações de banco estão organizadas com Flyway.</li>
</ul>

<h2>📚 Curso</h2>
<p>Projeto baseado nas aulas do curso <strong>Batismo de Spring Boot</strong> do Fiasco</p>

<h2>🧑‍💻 Autor</h2>
<p>
  Desenvolvido por <strong>Gabriel Moreira</strong> 👨‍💻<br/>
  <a href="https://github.com/gabrielmoreiradevs" target="_blank">Meu GitHub</a>
</p>

<h2>📜 Licença</h2>
<p>Este projeto está sob a licença MIT. Veja o arquivo <code>LICENSE</code> para mais detalhes.</p>

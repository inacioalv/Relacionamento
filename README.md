<h1 align="center">
  Relacionamento
</h1>


<p align="center">
  <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-projeto">Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-url">Url</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
</p>


<br>


## 🚀 Tecnologias

Esse projeto foi desenvolvido com as seguintes tecnologias:

- [Spring](https://spring.io/)
- [Jpa](https://spring.io/projects/spring-data-redis)
- [h2](https://www.mysql.com/)
- [lombok](https://projectlombok.org/)
- [swagger](https://swagger.io/)


## 💻 Projeto
Através do Modelo de Entidade e Relacionamento (MER) é possível representar os dados de um sistema de forma lógica e visual. O MER é formado por entidades, relacionamentos e atributos. As entidades são objetos que podem ser identificados de forma única e que descrevem um dado, como por exemplo, um usuário. Os relacionamentos são as ligações entre as entidades, e os atributos são características das entidades que descrevem seu conteúdo, como por exemplo, o nome de um usuário. O MER é usado para descrever o relacionamento entre os dados de um sistema, permitindo que sejam facilmente compreendidos e manipulados.

Existem três tipos de relacionamento entre entidades no banco de dados:

1. Relacionamento Um para Um (1:1) - Um relacionamento entre duas entidades em que cada entidade tem exatamente um registro correspondente na outra entidade.

2. Relacionamento Um para Muitos (1:N) - Um relacionamento entre duas entidades em que uma entidade pode ter vários registros correspondentes na outra entidade.

3. Relacionamento Muitos para Muitos (N:N) - Um relacionamento entre duas entidades em que cada entidade pode ter vários registros correspondentes na outra entidade.

**Relacionamento Um para Um (1:1):**

A relação entre Usuário e Perfil na Figura a baixo é um exemplo de relacionamento de um para um (1:1)
,ou seja, um Usuário não pode ter mais de um Perfil e um Perfil não pode ter mais de um Usuário.

<img alt="Diagrama Usuari Perfil" src="/img/Diagrama_UsuariPerfil.jpg" />


## :hammer: Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

## 💻 Url
Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
Produto
http://localhost:8080/produto/

Cliente
http://localhost:8080/cliente/
```

## 📝 Licença

Este projeto esta sobe a licença MIT. Veja a [LICENÇA](https://opensource.org/licenses/MIT) para saber mais.



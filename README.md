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

**Aplicando o modelo relacional no Spring Boot**

Para trabalharmos com banco de dados relacionados no Spring devemos conhecer algumas anotações Java que são
@OneToOne, @OneToMany, @ManyToOne, @ManyToMany: Estas anotações são usadas para definir relacionamentos 
entre entidades no banco de dados.

@OneToOne: 
Esta anotação é usada para especificar um relacionamento unidirecional entre duas entidades, onde uma entidade tem uma referência para outra entidade. Por exemplo, um usuário pode ter uma conta bancária.

@OneToMany:
Esta anotação é usada para especificar um relacionamento unidirecional de um para muitos entre duas entidades, onde uma entidade tem uma referência para várias entidades. Por exemplo, um professor pode ter vários alunos.

@ManyToOne: 
Esta anotação é usada para especificar um relacionamento unidirecional de muitos para um entre duas entidades, onde várias entidades têm uma referência para uma entidade. Por exemplo, vários alunos podem ter o mesmo professor.

@ManyToMany: 
Esta anotação é usada para especificar um relacionamento bidirecional de muitos para muitos entre duas entidades, onde várias entidades têm referências para várias entidades. Por exemplo, vários alunos podem ter vários professores.


Um relacionamento unidirecional indica que apenas uma das entidades possui referência para a outra. Por exemplo, um relacionamento @OneToMany unidirecional indica que apenas a entidade de origem possui referência à entidade de destino, enquanto a entidade de destino não possui referência à entidade de origem.
Um relacionamento bidirecional indica que ambas as entidades possuem referências à outra. Por exemplo, um relacionamento @OneToOne bidirecional indica que ambas as entidades possuem referências à outra e que qualquer alteração em uma entidade afeta a outra.

**Relacionamento Um para Um (1:1):**

A relação entre Usuário e Perfil na Figura a baixo é um exemplo de relacionamento de um para um (1:1)
,ou seja, um Usuário não pode ter mais de um Perfil e um Perfil não pode ter mais de um Usuário.

<img alt="Diagrama Usuari Perfil" src="/img/Diagrama_UsuariPerfil.jpg" />

No relacionamento unidirecional entre usuário e perfil, o usuário tem acesso ao seu próprio perfil, podendo visualizar e alterar informações sobre si mesmo, mas não pode acessar os perfis de outros usuários. Por outro lado, o perfil não tem acesso a qualquer informação sobre o usuário, exceto as informações que ele próprio forneceu.

No Spring Boot, o relacionamento unidirecional entre usuário e perfil é implementado usando anotações JPA @OneToOne. Esta anotação é usada para indicar que existe uma associação entre dois entidades e, portanto, entre dois objetos. Um usuário possui um perfil e, portanto, a anotação @OneToOne é usada para mapear essa associação. Por exemplo:

```
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = -4834257346219938057L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String email;
	private String senha;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "perfil_id")
	private Perfil perfil;

}
```
```
public class Perfil implements Serializable {
	
	private static final long serialVersionUID = -6493221891289506206L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String idade;
	private String genero;
	private String telefone;
	@OneToOne
	@JsonIgnore
	private Usuario usuario;

}
```




**Relacionamento Um para Muitos (1:N):**

A relação entre proprietário e imóveis é de um para muitos, pois um proprietário pode possuir vários imóveis, enquanto um imóvel só pode ter um proprietário. Essa relação pode ser representada por meio de duas tabelas no banco de dados: uma tabela de proprietários e outra de imóveis. A tabela de proprietários conteria informações como nome, endereço, CPF, etc., e a tabela de imóveis conteria informações como endereço, área, número de quartos, etc.


**Relacionamento Muitos para Muitos (N:N):**
A relação entre produto e vendas e de muitos para muitos, pois um produto pode ser vendido para mais de um cliente, e um cliente pode comprar mais de um produto.

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



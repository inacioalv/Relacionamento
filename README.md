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

A relação entre proprietário e imóveis é de um para muitos, pois um proprietário possuir vários imóveis, enquanto um imóvel só pode ter um proprietário. Essa relação pode ser representada por meio de duas tabelas no banco de dados: uma tabela de proprietários e outra de imóveis. A tabela de proprietários conteria informações como nome, endereço, CPF, etc., e a tabela de imóveis conteria informações como endereço, área, número de quartos, etc. 

<img alt="Diagrama imoveis e proprietario" src="/img/Diagrama_PropietarioImovel.jpg" />

No Spring Boot o relacionamento entre proprietário e imóvel utilizamos notações @OneToMany e @ManyToOne para definir essa relação. O proprietário (@OneToMany) tem vários imóveis associados a ele, e cada imóvel (@ManyToOne) tem somente um proprietário associado. Esta é a forma como a relação é definida no Spring Boot.
 
```
public class Proprietario implements Serializable {
	
	private static final long serialVersionUID = -2530536440519544967L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	@OneToMany(mappedBy = "proprietario",fetch = FetchType.LAZY)
	private Set<Imovel> imovels;
}

```
```
public class Imovel implements Serializable {

	private static final long serialVersionUID = -8654891696196923215L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipo;
	private double area;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	@ManyToOne
	@JoinColumn(name = "proprietario_id")
	@JsonIgnore
	private Proprietario proprietario;
}

```


**Relacionamento Muitos para Muitos (N:N):**

No relacionamento Muitos-para-Muitos usando uma chave composta, temos duas tabelas com chaves primárias relacionadas em uma terceira tabela. A terceira tabela, além das chaves primárias das outras duas tabelas, terá uma chave primária composta formada pelas duas chaves primárias (geralmente em forma de tupla).
Essa abordagem é utilizada quando queremos guardar informações adicionais sobre o relacionamento, como por exemplo, a data de criação, data de atualização, entre outras.

Exemplo a relação entre produto e vendas e de muitos para muitos, pois um produto pode ser vendido para mais de um cliente, e um cliente pode comprar mais de um produto, utilizando a chave composta podemos colocar a informação de data da venda.

<img alt="Diagrama Produto e vendas" src="/img/Diagrama_ProdutoVenda.jpg" />

```
@Data
@Embeddable
public class ProdutoVendaPK implements Serializable{
	
	private static final long serialVersionUID = -4593010746323328532L;

	@ManyToOne
	@JoinColumn
	private Venda venda;
	
	@ManyToOne
	@JoinColumn
	private Produto produto;
	
	@Override
	public int hashCode() 
	
	@Override
	public boolean equals(Object obj) 

```

```
@Entity
public class ProdutoVenda implements Serializable {
	
	private static final long serialVersionUID = 4742293368241589682L;

	@EmbeddedId
	private ProdutoVendaPK id = new ProdutoVendaPK();
	
	public ProdutoVenda() {}

	public ProdutoVenda(Produto produto, Venda venda) {
		super();
		id.setProduto(produto);
		id.setVenda(venda);
		
	}
}
```

```
public class Produto implements Serializable {

	private static final long serialVersionUID = -1248252608293478027L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeProduto;
	private double preco;

	@OneToMany(mappedBy = "id.venda")
	private Set<ProdutoVenda> produtovenda = new HashSet<>();
	
	public List<Venda> getvenda(){
		List<Venda> vendas = new ArrayList<Venda>();
		for(ProdutoVenda o :produtovenda) {
			vendas.add(o.getVenda());
		}
		return vendas;
}

```

```
public class Venda implements Serializable {
	
	private static final long serialVersionUID = 8105771382221692674L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome_cliente;
	private String data;
	private double quantidade;
	
	@OneToMany(mappedBy = "id.venda")
	private Set<ProdutoVenda> produtovenda = new HashSet<>();
	
	public List<Produto> getproduto(){
		List<Produto> produtos = new ArrayList<Produto>();
		for(ProdutoVenda o:produtovenda) {
			produtos.add(o.getProduto());
		}
		return produtos;
}
```


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



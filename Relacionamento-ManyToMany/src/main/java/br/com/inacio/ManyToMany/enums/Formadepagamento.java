package br.com.inacio.ManyToMany.enums;

public enum Formadepagamento {
	
	CREDITO(1, "ROLE_CREDITO"), 
	BOLETO(2, "ROLE_BOLETO");

	private int codigo;
	private String descricao;

	private Formadepagamento(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static Formadepagamento toEnum(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		for(Formadepagamento o : Formadepagamento.values()){
			if(codigo.equals(o.getCodigo())) {
				return o;
			}
		}
		
		throw new IllegalArgumentException("Código inválido: " + codigo);
	}


}

public abstract class Pessoa {
  
  private String nome;
	private double dividaAtiva;

	public Pessoa(String nome, double dividaAtiva) {
		this.nome = nome;
		this.dividaAtiva = dividaAtiva;
	}

	public String getNome() {
		return nome;
	}

	public double getDividaAtiva() {
		return dividaAtiva;
	}

	public abstract String getIdentificacao();
}

class PessoaFisica extends Pessoa {
	private String cpf;

	public PessoaFisica(String nome, double dividaAtiva, String cpf) {
		super(nome, dividaAtiva);
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	@Override
	public String getIdentificacao() {
		return getCpf();
	}
}

class PessoaJuridica extends Pessoa {
	private String cnpj;

	public PessoaJuridica(String nome, double dividaAtiva, String cnpj) {
		super(nome, dividaAtiva);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	@Override
	public String getIdentificacao() {
		return getCnpj();
	}
}

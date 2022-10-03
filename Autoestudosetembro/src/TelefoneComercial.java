import java.time.LocalDate;

public class TelefoneComercial {

	private String nome;
	private String endereco;
	private LocalDate dataInstalacao;
	private float valor;
	private String numero;
	
	private String ramoAtividade; 
	
	
	
	public TelefoneComercial(String nome, String endereco, LocalDate dataInstalacao, String ramoAtividade,
			String numero) {
		setRamoAtividade(ramoAtividade);
		setDataInstalacao(dataInstalacao);
		setEndereco(endereco);
		setNome(nome);
		setNumero(numero);
		
		
	}
	public void setRamoAtividade(String ramoAtividade) {
	
		if (ramoAtividade != null) {
		this.ramoAtividade = ramoAtividade;
		} 
		else {
		throw new IllegalArgumentException("Usuario Invalido");
		}
	}
	
	public String getRamoAtividade() {
		return ramoAtividade;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if (nome != null) {
			this.nome = nome;
		} 
		else {
			throw new IllegalArgumentException("Usuario Invalido");
		}
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if (endereco != null) {
			this.endereco = endereco;
		} 
		else {
			throw new IllegalArgumentException("Usuario Invalido");
		}
		
	}
	public LocalDate getDataInstalacao() {
		return dataInstalacao;
	}
	public void setDataInstalacao(LocalDate dataInstalacao) {
		
		if (dataInstalacao != null) {
			this.dataInstalacao = dataInstalacao;
		} 
		else {
			throw new IllegalArgumentException("Usuario Invalido");
		}
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		LocalDate testeDate = LocalDate.parse("2018-12-31");
		if (dataInstalacao.isAfter(testeDate)) {
			valor = 37.50f;
		}
		else {
			valor = 25f;
		}
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		if (numero != null) {
			this.numero = numero;
		} 
		else {
			throw new IllegalArgumentException("Usuario Invalido");
		}
		
	}

}

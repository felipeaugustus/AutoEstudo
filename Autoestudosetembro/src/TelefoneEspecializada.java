import java.time.LocalDate;

public class TelefoneEspecializada {
	private String nome;
	private String endereco;
	private LocalDate dataInstalacao;
	private float valor;
	private String numero;
	
	private int qtdOcorrencia;
	
	
	
	public TelefoneEspecializada(String nome, String endereco, LocalDate dataInstalacao, int qtdOcorrencia,
			String numero) {
		setQtdOcorrencia(qtdOcorrencia);
		setDataInstalacao(dataInstalacao);
		setEndereco(endereco);
		setNome(nome);
		setNumero(numero);
		
		
	}
	public void setQtdOcorrencia(int qtdOcorrencia) {
		this.qtdOcorrencia = qtdOcorrencia;
	}
	public int getQtdOcorrencia() {
		return qtdOcorrencia;
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
		if (qtdOcorrencia > 50000) {
			valor = 187.82f;
		}
		else if (qtdOcorrencia <= 50000 && qtdOcorrencia >= 10001 ) {
			valor = 123.90f;
		}
		else if (qtdOcorrencia <= 10000 && qtdOcorrencia >= 5001) {
			valor = 98.50f;
		}
		else if (qtdOcorrencia <= 5000 && qtdOcorrencia >= 1001) {
			valor = 67.80f;
		}
		else {
			valor = 50f;
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

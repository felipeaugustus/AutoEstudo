import java.sql.Date;

public class TelefoneResidencial {
	private String nome;
	private String endereco;
	private Date dataInstalacao;
	private float valor;
	private String numero;
	
	private boolean conexaoInternet;
	
	
	
	public TelefoneResidencial(String nome, String endereco, Date dataInstalacao, boolean conexaoInternet,
			String numero) {
		setConexaoInternet(conexaoInternet);
		setDataInstalacao(dataInstalacao);
		setEndereco(endereco);
		setNome(nome);
		setNumero(numero);
		setValor();
		
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
			throw new IllegalArgumentException("Endereço Invalido");
		}
		
	}
	public Date getDataInstalacao() {
		return dataInstalacao;
	}
	public void setDataInstalacao(Date dataInstalacao) {
		if (dataInstalacao != null) {
			this.dataInstalacao = dataInstalacao;
		} 
		else {
			throw new IllegalArgumentException("Data Invalida");
		}
		
	}
	public float getValor() {
		return valor;
	}
	public void setValor() {
		valor = 15f;	
	}
	public boolean isConexaoInternet() {
		return conexaoInternet;
	}
	public void setConexaoInternet(boolean conexaoInternet) {
		this.conexaoInternet = conexaoInternet;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		if (endereco != null) {
			this.numero = numero;
		} 
		else {
			throw new IllegalArgumentException("Valor Invalido");
		}
		
	}

	
}

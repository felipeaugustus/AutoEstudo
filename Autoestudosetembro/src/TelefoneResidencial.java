import java.sql.Date;

public class TelefoneResidencial {
	private String nome;
	private String endereco;
	private Date dataInstalacao;
	private float valor;
	private String numero;
	
	private boolean conexaoInternet;
	
	
	
	public TelefoneResidencial(String nome, String endereco, Date dataInstalacao, float valor, boolean conexaoInternet,
			String numero) {
		setConexaoInternet(conexaoInternet);
		setDataInstalacao(dataInstalacao);
		setEndereco(endereco);
		setNome(nome);
		setNumero(numero);
		setValor(valor);
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if (nome != null) {
			this.nome = nome;
		} 
		else {
			throw new Error("Usuario Invalido");
		}
		
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Date getDataInstalacao() {
		return dataInstalacao;
	}
	public void setDataInstalacao(Date dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
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
		this.numero = numero;
	}

	
}

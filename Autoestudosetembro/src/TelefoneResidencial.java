import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Felipe Araujo e Gustavo Bozzano
public class TelefoneResidencial {
	private String nome;
	private String endereco;
	private LocalDate dataInstalacao;
	private float valor;
	private String numero;

	private DateTimeFormatter df = DateTimeFormatter.ofPattern("d/M/y");

	private boolean conexaoInternet;

	public TelefoneResidencial(String nome, String endereco, LocalDate dataInstalacao, boolean conexaoInternet,
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
		if (nome.length() > 0) {
			this.nome = nome;
		} else {
			throw new Error("Usuario Invalido");
		}
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		if (endereco.length() > 0) {
			this.endereco = endereco;
		} else {
			throw new Error("Endereco Invalido");
		}
	}

	public String getDataInstalacao() {
		return dataInstalacao.format(df);
	}

	public void setDataInstalacao(LocalDate dataInstalacao) {
		if (dataInstalacao != null) {
			this.dataInstalacao = dataInstalacao;
		} else {
			throw new Error("Data Invalido");
		}
	}

	public float getValor() {
		return valor;
	}

	public void setValor() {
		this.valor = 15f;
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
		if (numero.length() > 0) {
			numero = numero.replace(" ", "").replace("-", "").replace("(", "").replace(")", "");
			this.numero = numero;

		} else {
			throw new Error("Numero Invalido");
		}
	}
}

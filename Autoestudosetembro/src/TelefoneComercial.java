import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TelefoneComercial {
	private String nome;
	private String endereco;
	private LocalDate dataInstalacao;
	private float valor;
	private String numero;

	private DateTimeFormatter df = DateTimeFormatter.ofPattern("d/M/y");

	private String ramoAtividade;

	public TelefoneComercial(String nome, String endereco, LocalDate dataInstalacao, String ramoAtividade,
			String numero) {
		setRamoAtividade(ramoAtividade);
		setDataInstalacao(dataInstalacao);
		setEndereco(endereco);
		setNome(nome);
		setNumero(numero);
		setValor();
	}

	public void setRamoAtividade(String ramoAtividade) {

		if (ramoAtividade.length() > 0) {
			this.ramoAtividade = ramoAtividade;
		} else {
			throw new Error("Ramo Invalido");
		}
	}

	public String getRamoAtividade() {
		return ramoAtividade;
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
		LocalDate testeDate = LocalDate.parse("2018-12-31");
		if (dataInstalacao.isAfter(testeDate)) {
			this.valor = 37.50f;
		} else {
			this.valor = 25f;
		}
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

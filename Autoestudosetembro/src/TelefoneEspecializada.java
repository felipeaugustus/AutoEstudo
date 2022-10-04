import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TelefoneEspecializada {
	private String nome;
	private String endereco;
	private LocalDate dataInstalacao;
	private float valor;
	private String numero;

	private DateTimeFormatter df = DateTimeFormatter.ofPattern("d/M/y");

	private int qtdOcorrencia;

	public TelefoneEspecializada(String nome, String endereco, LocalDate dataInstalacao, int qtdOcorrencia,
			String numero) {
		setQtdOcorrencia(qtdOcorrencia);
		setDataInstalacao(dataInstalacao);
		setEndereco(endereco);
		setNome(nome);
		setNumero(numero);
		setValor(qtdOcorrencia);
	}

	public void setQtdOcorrencia(int qtdOcorrencia) {
		if (qtdOcorrencia > 0) {
			this.qtdOcorrencia = qtdOcorrencia;
		} else {
			throw new Error("Quantidade de ocorrencias invalida");
		}
	}

	public int getQtdOcorrencia() {
		return qtdOcorrencia;
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

	public void setValor(int qtdOcorrencia) {
		if (qtdOcorrencia > 50000) {
			this.valor = 187.82f;
		} else if (qtdOcorrencia <= 50000 && qtdOcorrencia >= 10001) {
			this.valor = 123.90f;
		} else if (qtdOcorrencia <= 10000 && qtdOcorrencia >= 5001) {
			this.valor = 98.50f;
		} else if (qtdOcorrencia <= 5000 && qtdOcorrencia >= 1001) {
			this.valor = 67.80f;
		} else {
			this.valor = 50f;
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

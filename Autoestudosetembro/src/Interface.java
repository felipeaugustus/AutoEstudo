import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.util.HashMap;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Interface {
	private DateTimeFormatter df = DateTimeFormatter.ofPattern("d/M/y");
	private JFrame frame;
	private HashMap<String, TelefoneComercial> listaComercial = new HashMap<>();
	private HashMap<String, TelefoneResidencial> listaResidencial = new HashMap<>();
	private HashMap<String, TelefoneEspecializada> listaEspecializada = new HashMap<>();

	private double faturamento = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 534, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnBusca = new JButton("Buscar numero");
		btnBusca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String numero = JOptionPane.showInputDialog("Insira o numero a ser buscado");
				numero = numero.replace(" ", "").replace("-", "").replace("(", "").replace(")", "");

				TelefoneComercial resultadoComercial = listaComercial.get(numero);
				TelefoneResidencial resultadoResidencial = listaResidencial.get(numero);
				TelefoneEspecializada resultadoEspecializada = listaEspecializada.get(numero);
				if (resultadoComercial != null) {
					JOptionPane.showMessageDialog(frame,
							"RESULTADO DA BUSCA:\nTipo de linha: Comercial" + "\nUsuario: "
									+ resultadoComercial.getNome() + "\nEndereco: " + resultadoComercial.getEndereco()
									+ "\nNumero: " + resultadoComercial.getNumero() + "\nData de instalacao: "
									+ resultadoComercial.getDataInstalacao() + "\nRamo de atividade: "
									+ resultadoComercial.getRamoAtividade() + "\nValor a pagar: "
									+ resultadoComercial.getValor());
				} else if (resultadoResidencial != null) {
					String res;
					if (resultadoResidencial.isConexaoInternet()) {
						res = "Sim";
					} else {
						res = "Nao";
					}
					JOptionPane.showMessageDialog(frame, "RESULTADO DA BUSCA:\nTipo de linha: Residencial"
							+ "\nUsuario: " + resultadoResidencial.getNome() + "\nEndereco: "
							+ resultadoResidencial.getEndereco() + "\nNumero: " + resultadoResidencial.getNumero()
							+ "\nData de instalacao: " + resultadoResidencial.getDataInstalacao()
							+ "\nConexao internet: " + res + "\nValor a pagar: " + resultadoResidencial.getValor());
				} else if (resultadoEspecializada != null) {
					JOptionPane.showMessageDialog(frame, "RESULTADO DA BUSCA:\nTipo de linha: Comercial" + "\nUsuario: "
							+ resultadoEspecializada.getNome() + "\nEndereco: " + resultadoEspecializada.getEndereco()
							+ "\nNumero: " + resultadoEspecializada.getNumero() + "\nData de instalacao: "
							+ resultadoEspecializada.getDataInstalacao() + "\nQuantidade de ocorrencias: "
							+ resultadoEspecializada.getQtdOcorrencia() + "\nValor a pagar: "
							+ resultadoEspecializada.getValor());
				} else {
					JOptionPane.showMessageDialog(frame, "Nada consta no sistema");
				}
			}
		});
		btnBusca.setBounds(10, 263, 151, 21);
		frame.getContentPane().add(btnBusca);

		JButton btnFaturamento = new JButton("Faturamento");
		btnFaturamento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame, "Faturamento total: " + faturamento);
			}
		});
		btnFaturamento.setBounds(171, 263, 117, 21);
		frame.getContentPane().add(btnFaturamento);

		JButton btnResidencial = new JButton("Add tel residencial");
		btnResidencial.setBounds(153, 49, 146, 21);
		frame.getContentPane().add(btnResidencial);
		btnResidencial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nome = JOptionPane.showInputDialog("Insira o nome do usuario");
				String endereco = JOptionPane.showInputDialog("Insira o endereço");
				String data = JOptionPane.showInputDialog("Insira a data de instalacao");
				String numero = JOptionPane.showInputDialog("Insira o numero da linha");
				Object[] options = { "Sim", "Nao" };
				int internetOption = JOptionPane.showOptionDialog(null, "Possui conexao com internet?", "Internet",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

				boolean internet;
				if (internetOption == 0) {
					internet = true;
				} else {
					internet = false;
				}

				try {
					if (listaComercial.get(numero) != null && listaEspecializada.get(numero) != null
							&& listaResidencial.get(numero) != null) {
						JOptionPane.showMessageDialog(frame, "O numero cadastrado ja existe, linha nao cadastrada!");
					} else {
						LocalDate dataFormatada = LocalDate.parse(data, df);
						TelefoneResidencial tel = new TelefoneResidencial(nome, endereco, dataFormatada, internet,
								numero);

						listaResidencial.put(tel.getNumero(), tel);
						faturamento += tel.getValor();
						JOptionPane.showMessageDialog(frame, "Linha cadastrada com exito");
					}
				} catch (Exception error) {
					System.err.println(error);
					JOptionPane.showMessageDialog(frame, "Data incorreta, por favor revise e tente novamente (d/m/a)");
				} catch (Error error) {
					System.err.println(error);
					JOptionPane.showMessageDialog(frame,
							"Entrada incorreta:\n" + error.getMessage() + "\nPor favor revise e tente novamente");
				}
			}
		});

		JButton btnComercial = new JButton("Add tel comercial");
		btnComercial.setBounds(10, 49, 133, 21);
		frame.getContentPane().add(btnComercial);
		btnComercial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nome = JOptionPane.showInputDialog("Insira o nome do usuario");
				String endereco = JOptionPane.showInputDialog("Insira o endereço");
				String data = JOptionPane.showInputDialog("Insira a data de instalacao");
				String numero = JOptionPane.showInputDialog("Insira o numero da linha");
				String atividade = JOptionPane.showInputDialog("Insira o ramo de atividade");

				try {
					if (listaComercial.get(numero) != null && listaEspecializada.get(numero) != null
							&& listaResidencial.get(numero) != null) {
						JOptionPane.showMessageDialog(frame, "O numero cadastrado ja existe, linha nao cadastrada!");
					} else {
						LocalDate dataFormatada = LocalDate.parse(data, df);
						TelefoneComercial tel = new TelefoneComercial(nome, endereco, dataFormatada, atividade, numero);

						listaComercial.put(tel.getNumero(), tel);
						faturamento += tel.getValor();
						JOptionPane.showMessageDialog(frame, "Linha cadastrada com exito");
					}
				} catch (Exception error) {
					System.err.println(error);
					JOptionPane.showMessageDialog(frame, "Data incorreta, por favor revise e tente novamente (d/m/a)");
				} catch (Error error) {
					System.err.println(error);
					JOptionPane.showMessageDialog(frame,
							"Entrada incorreta:\n" + error.getMessage() + "\nPor favor revise e tente novamente");
				}
			}
		});

		JButton btnEspecializada = new JButton("Add tel especializada");
		btnEspecializada.setBounds(309, 49, 158, 21);
		frame.getContentPane().add(btnEspecializada);
		btnEspecializada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nome = JOptionPane.showInputDialog("Insira o nome do usuario");
				String endereco = JOptionPane.showInputDialog("Insira o endereço");
				String data = JOptionPane.showInputDialog("Insira a data de instalacao");
				String numero = JOptionPane.showInputDialog("Insira o numero da linha");
				int qtdOcorrencia = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de ocorrencias"));

				try {
					if (listaComercial.get(numero) != null && listaEspecializada.get(numero) != null
							&& listaResidencial.get(numero) != null) {
						JOptionPane.showMessageDialog(frame, "O numero cadastrado ja existe, linha nao cadastrada!");
					} else {
						LocalDate dataFormatada = LocalDate.parse(data, df);
						TelefoneEspecializada tel = new TelefoneEspecializada(nome, endereco, dataFormatada,
								qtdOcorrencia, numero);

						listaEspecializada.put(tel.getNumero(), tel);
						faturamento += tel.getValor();
						JOptionPane.showMessageDialog(frame, "Linha cadastrada com exito");
					}
				} catch (Exception error) {
					System.err.println(error);
					JOptionPane.showMessageDialog(frame, "Data incorreta, por favor revise e tente novamente (d/m/a)");
				} catch (Error error) {
					System.err.println(error);
					JOptionPane.showMessageDialog(frame,
							"Entrada incorreta:\n" + error.getMessage() + "\nPor favor revise e tente novamente");
				}
			}
		});
	}
}

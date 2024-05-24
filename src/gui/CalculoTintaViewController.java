package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.alerter.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.MedidasValorModel;
import service.CalculoService;

/**
 * Controlador da interface gráfica para o cálculo de tinta. Gerencia a
 * interação do usuário com a interface e os cálculos necessários.
 * 
 * @version 1.0
 * @since 2024-05-20
 */
public class CalculoTintaViewController implements Initializable {

	@FXML
	private TextField txtLargura;

	@FXML
	private TextField txtAltura;

	@FXML
	private TextField txtPrecoM2;

	@FXML
	private TextField txtPrecoTotal;

	@FXML
	private TextField txtValorTotal;

	@FXML
	private Button btSalvar;

	@FXML
	private Button btLimpar;

	@FXML
	private TableView<MedidasValorModel> tableView;

	@FXML
	private TableColumn<MedidasValorModel, Double> larguraCol;

	@FXML
	private TableColumn<MedidasValorModel, Double> alturaCol;

	@FXML
	private TableColumn<MedidasValorModel, Double> precoM2Col;

	@FXML
	private TableColumn<MedidasValorModel, Double> totalCol;

	private ObservableList<MedidasValorModel> data;

	/**
	 * Inicializa a TableView e as colunas, configura os dados observáveis.
	 * 
	 * @param uri URL para inicialização.
	 * @param rb  ResourceBundle para inicialização.
	 */
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		larguraCol.setCellValueFactory(new PropertyValueFactory<>("largura"));
		alturaCol.setCellValueFactory(new PropertyValueFactory<>("altura"));
		precoM2Col.setCellValueFactory(new PropertyValueFactory<>("valorM2"));
		totalCol.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));

		Callback<TableColumn<MedidasValorModel, Double>, TableCell<MedidasValorModel, Double>> cellFactory = new Callback<TableColumn<MedidasValorModel, Double>, TableCell<MedidasValorModel, Double>>() {
			@Override
			public TableCell<MedidasValorModel, Double> call(TableColumn<MedidasValorModel, Double> param) {
				return new TableCell<MedidasValorModel, Double>() {
					@Override
					protected void updateItem(Double item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setText(null);
						} else {
							setText(CalculoService.formatarPreco(item));
							setStyle("-fx-alignment: CENTER; -fx-font-size: 14px;");
						}
					}
				};
			}
		};

		larguraCol.setCellFactory(cellFactory);
		alturaCol.setCellFactory(cellFactory);
		precoM2Col.setCellFactory(cellFactory);
		totalCol.setCellFactory(cellFactory);

		data = FXCollections.observableArrayList();
		tableView.setItems(data);
	}

	/**
	 * Ação ao clicar no botão salvar. Verifica se há dados faltando, calcula o
	 * preço e adiciona os dados à tabela.
	 */
	@FXML
	private void onBtSalvarAction() {
		if (faltaDados()) {
			return;
		}
		calcularPreco();
		adicionarDadosTabela();
		atualizarValorTotal();
	}

	/**
	 * Atualiza o valor total com base nos dados da tabela.
	 */
	private void atualizarValorTotal() {
		double soma = 0;
		for (MedidasValorModel valor : data) {
			soma += valor.getValorTotal();
		}
		txtValorTotal.setText(CalculoService.formatarPreco(soma));
	}

	/**
	 * Verifica se há dados faltando nos campos de texto.
	 * 
	 * @return booleano indicando se faltam dados.
	 */
	private boolean faltaDados() {
		if (isCampoVazio(txtLargura, "Favor Informar a Largura!"))
			return true;
		if (isCampoVazio(txtAltura, "Favor Informar a Altura!"))
			return true;
		if (isCampoVazio(txtPrecoM2, "Favor Informar o Preço por Metro Quadrado!"))
			return true;
		return false;
	}

	/**
	 * Verifica se o campo de texto está vazio e exibe uma mensagem de alerta se
	 * estiver.
	 * 
	 * @param campo    O campo de texto a ser verificado.
	 * @param mensagem A mensagem de alerta a ser exibida.
	 * @return booleano indicando se o campo está vazio.
	 */
	private boolean isCampoVazio(TextField campo, String mensagem) {
		if (campo.getText().isEmpty()) {
			Alerts.showAlert("Atenção", null, mensagem, AlertType.WARNING);
			campo.requestFocus();
			return true;
		}
		return false;
	}

	/**
	 * Calcula o preço total com base na largura, altura e preço por metro quadrado.
	 */
	private void calcularPreco() {
		try {
			double largura = CalculoService.obterValorDoCampo(txtLargura);
			double altura = CalculoService.obterValorDoCampo(txtAltura);
			double precoM2 = CalculoService.obterValorDoCampo(txtPrecoM2);

			double area = CalculoService.calcularArea(largura, altura);
			double precoTotal = CalculoService.calcularPrecoTotal(area, precoM2);

			txtPrecoTotal.setText(CalculoService.formatarPreco(precoTotal));
		} catch (NumberFormatException e) {
			txtPrecoTotal.setText("Erro de formato");
		}
	}

	/**
	 * Adiciona os dados calculados à tabela de exibição.
	 */
	private void adicionarDadosTabela() {
		try {
			double largura = CalculoService.obterValorDoCampo(txtLargura);
			double altura = CalculoService.obterValorDoCampo(txtAltura);
			double precoM2 = CalculoService.obterValorDoCampo(txtPrecoM2);

			MedidasValorModel medidas = new MedidasValorModel(largura, altura, precoM2);
			data.add(medidas);
		} catch (NumberFormatException e) {
			Alerts.showAlert("Erro", null, "Erro ao adicionar dados na tabela", AlertType.ERROR);
		}
	}

	/**
	 * Ação ao clicar no botão limpar. Limpa todos os campos de texto.
	 */
	@FXML
	private void onBtLimparAction() {
		limparCampos(txtLargura, txtAltura, txtPrecoM2, txtPrecoTotal);
	}

	/**
	 * Limpa os campos de texto fornecidos.
	 * 
	 * @param campos Os campos de texto a serem limpos.
	 */
	private void limparCampos(TextField... campos) {
		for (TextField campo : campos) {
			campo.clear();
		}
	}
}

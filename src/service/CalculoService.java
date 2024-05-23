package service;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javafx.scene.control.TextField;

/**
 * Serviço para cálculos e formatação relacionados ao cálculo de tinta.
 * 
 * @version 1.0
 * @since 2024-05-20
 */
public class CalculoService {
	private static final Locale brasil = Locale.forLanguageTag("pt-BR");
	private static final DecimalFormatSymbols symbols = new DecimalFormatSymbols(brasil);
	private static final DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);

	/**
	 * Calcula a área com base na largura e altura.
	 * 
	 * @param largura A largura do item.
	 * @param altura  A altura do item.
	 * @return A área calculada.
	 */
	public static double calcularArea(double largura, double altura) {
		return largura * altura;
	}

	/**
	 * Calcula o preço total com base na área e no preço por metro quadrado.
	 * 
	 * @param area    A área do item.
	 * @param precoM2 O preço por metro quadrado.
	 * @return O preço total.
	 */
	public static double calcularPrecoTotal(double area, double precoM2) {
		return area * precoM2;
	}

	/**
	 * Formata o preço para exibição com duas casas decimais.
	 * 
	 * @param precoTotal O preço total a ser formatado.
	 * @return O preço formatado.
	 */
	public static String formatarPreco(double precoTotal) {
		return decimalFormat.format(precoTotal);
	}

	/**
	 * Obtém o valor numérico de um campo de texto.
	 * 
	 * @param campo O campo de texto a ser convertido.
	 * @return O valor numérico do campo.
	 * @throws NumberFormatException Se o campo estiver vazio ou contiver um formato
	 *                               inválido.
	 */
	public static double obterValorDoCampo(TextField campo) throws NumberFormatException {
		String texto = campo.getText().replace(".", "").replace(",", ".");
		if (texto.isEmpty()) {
			throw new NumberFormatException("Campo vazio");
		}
		return Double.parseDouble(texto);
	}
}

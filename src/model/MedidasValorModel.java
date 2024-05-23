package model;

/**
 * Classe de modelo para armazenar medidas e valores relacionados ao cálculo de
 * tinta.
 * 
 * @version 1.0
 * @since 2024-05-20
 */
public class MedidasValorModel {
	private double largura;
	private double altura;
	private double valorM2;
	private double valorTotal;

	/**
	 * Construtor para inicializar o modelo com largura, altura e valor por metro
	 * quadrado.
	 * 
	 * @param largura A largura da área.
	 * @param altura  A altura da área.
	 * @param valorM2 O valor por metro quadrado.
	 */
	public MedidasValorModel(double largura, double altura, double valorM2) {
		this.largura = largura;
		this.altura = altura;
		this.valorM2 = valorM2;
		this.valorTotal = largura * altura * valorM2;
	}

	/**
	 * Obtém a largura da área.
	 * 
	 * @return A largura da área.
	 */
	public double getLargura() {
		return largura;
	}

	/**
	 * Define a largura da área.
	 * 
	 * @param largura A largura da área.
	 */
	public void setLargura(double largura) {
		this.largura = largura;
		calcularValorTotal();
	}

	/**
	 * Obtém a altura da área.
	 * 
	 * @return A altura da área.
	 */
	public double getAltura() {
		return altura;
	}

	/**
	 * Define a altura da área.
	 * 
	 * @param altura A altura da área.
	 */
	public void setAltura(double altura) {
		this.altura = altura;
		calcularValorTotal();
	}

	/**
	 * Obtém o valor por metro quadrado.
	 * 
	 * @return O valor por metro quadrado.
	 */
	public double getValorM2() {
		return valorM2;
	}

	/**
	 * Define o valor por metro quadrado.
	 * 
	 * @param valorM2 O valor por metro quadrado.
	 */
	public void setValorM2(double valorM2) {
		this.valorM2 = valorM2;
		calcularValorTotal();
	}

	/**
	 * Obtém o valor total calculado.
	 * 
	 * @return O valor total calculado.
	 */
	public double getValorTotal() {
		return valorTotal;
	}

	/**
	 * Calcula o valor total com base na largura, altura e valor por metro quadrado.
	 */
	private void calcularValorTotal() {
		this.valorTotal = this.largura * this.altura * this.valorM2;
	}
}

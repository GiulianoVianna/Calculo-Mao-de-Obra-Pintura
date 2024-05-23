package gui.alerter;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Classe utilitária para exibição de alertas na aplicação JavaFX.
 * 
 * @version 1.0
 * @since 2024-05-20
 */
public class Alerts {

	/**
	 * Exibe um alerta com as informações fornecidas.
	 * 
	 * @param title   O título do alerta.
	 * @param header  O cabeçalho do alerta.
	 * @param content O conteúdo da mensagem do alerta.
	 * @param type    O tipo de alerta (informação, aviso, erro, etc.).
	 */
	public static void showAlert(String title, String header, String content, AlertType type) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
	}

}

package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Classe principal para iniciar a aplicação JavaFX.
 */
public class Main extends Application {
	/**
	 * Inicia a aplicação JavaFX.
	 *
	 * @param stage O palco principal da aplicação.
	 */
	@Override
	public void start(Stage stage) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/gui/CalculoTintaView.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setMaximized(false);
			stage.setResizable(false);

			// Adiciona o ícone à janela
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/icons/calculo.png")));

			// Define o título da janela
			stage.setTitle("Cálculo - Mão de Obra de Pintura");

			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método principal para lançar a aplicação.
	 *
	 * @param args Argumentos da linha de comando.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}

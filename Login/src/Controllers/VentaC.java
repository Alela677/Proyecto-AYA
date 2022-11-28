package Controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class VentaC {

	@FXML
	private Pane paneStock;

	@FXML
	private Pane paneResumen;

	@FXML
	void vistaResumen(MouseEvent event) {

	}

	@FXML
	void vistaStockVehiculos(MouseEvent event) throws IOException {
		escenaStock();

	}

	private void escenaStock() throws IOException {
		FXMLLoader loade = new FXMLLoader(getClass().getResource("/Views/ScenaStock.fxml"));
		AnchorPane root = loade.load();

		LoginController.root.setCenter(root);

	}

}

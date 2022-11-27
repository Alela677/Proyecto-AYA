package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.cfg.annotations.ListBinder;

import Models.Vehiculo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class StockC implements Initializable {

	@FXML
	private ScrollPane scrollStock;

	@FXML
	private GridPane gridStock;

	private List<Vehiculo> vehichulos = new ArrayList<Vehiculo>();

	private List<Vehiculo> listaVehiculos() {

		List<Vehiculo> vehichulos = new ArrayList<Vehiculo>();

		for (int i = 0; i < 50; i++) {
			Vehiculo vehiculo = new Vehiculo("SEAT", "IBIZA", "ROJO", 7000, 12, "/images/ibiza.jpg");

			vehichulos.add(vehiculo);
		}

		return vehichulos;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		vehichulos.addAll(listaVehiculos());

		int columna = 0;
		int fila = 0;

		for (int i = 0; i < vehichulos.size(); i++) {

			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Vehiculos.fxml"));
				AnchorPane root = loader.load();

				VehiculosC controlador = loader.getController();
				controlador.setDatos(vehichulos.get(i));

				if (columna == 5) {
					columna = 0;
					fila++;
				}

				gridStock.add(root, columna, fila);
				columna++;
				
				GridPane.setMargin(root, new Insets(15));
				
				gridStock.minWidth(Region.USE_COMPUTED_SIZE);
				gridStock.prefWidth(Region.USE_COMPUTED_SIZE);
				gridStock.setMaxWidth(Region.USE_PREF_SIZE);

				gridStock.minHeight(Region.USE_COMPUTED_SIZE);
				gridStock.prefHeight(Region.USE_COMPUTED_SIZE);
				gridStock.setMaxHeight(Region.USE_PREF_SIZE);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}

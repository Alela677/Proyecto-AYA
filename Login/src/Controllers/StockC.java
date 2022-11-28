package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Models.Vehiculo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class StockC implements Initializable {
	private VehiculosC controlador;

	@FXML
	private ScrollPane scrollVehiculos;

	@FXML
	private GridPane gridVehiculo;

	@FXML
	private MenuButton btnColores;

	@FXML
	private MenuItem itemAzul;

	private List<Vehiculo> vehichulos = new ArrayList<Vehiculo>();
	private List<Vehiculo> vehichulos2;

	@FXML
	void verVehiculosAzules(ActionEvent event) {

	}

	private List<Vehiculo> listaVehiculos() {

		vehichulos2 = new ArrayList<Vehiculo>();

		for (int i = 0; i < 50; i++) {
			Vehiculo vehiculo = new Vehiculo("SEAT", "IBIZA", "ROJO", 7000, 12, "/images/ibiza.jpg");

			vehichulos2.add(vehiculo);

		}

		return vehichulos2;

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

				controlador = loader.getController();
				controlador.setDatos(vehichulos.get(i));

				if (columna == 2) {
					columna = 0;
					fila++;
				}
				gridVehiculo.setVgap(10);
				gridVehiculo.setHgap(500);
				gridVehiculo.add(root, columna, fila);

				columna++;
				GridPane.setMargin(root, new Insets(15));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}

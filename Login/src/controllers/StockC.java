package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import models.Vehiculo;

public class StockC implements Initializable {

	private VehiculosC controlador;

	@FXML
	private BorderPane borderPaneStock;

	@FXML
	private ScrollPane scrollVehiculos;

	@FXML
	private GridPane gridVehiculo;

	@FXML
	private MenuButton btnColores;

	@FXML
	private MenuItem itemAzul;
	
	// Lista de vehiculos
	private List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	
	// Lista  de paneles
	private List<AnchorPane> paneles = new ArrayList<AnchorPane>();

	@FXML
	void verVehiculosAzules(ActionEvent event) throws IOException {
		
		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();
		
		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;

		for (int i = 0; i < 50; i++) {
			Vehiculo nuevo = new Vehiculo("SEAT", "IBIZA", "AZUL", 17000, 21, "ibizaAzul.jpg");
			vehiculos.add(nuevo);

		}

		try {

			for (int i = 0; i < vehiculos.size(); i++) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Vehiculos.fxml"));
				AnchorPane root = loader.load();
				VehiculosC controlador = loader.getController();
				controlador.setDatos(vehiculos.get(i));
				paneles.add(root);
			}

			GridPane nuevo = new GridPane();
			nuevo.setHgap(20);
			nuevo.setVgap(20);

			for (int i = 0; i < paneles.size(); i++) {

				if (columna == 4) {
					columna = 0;
					fila++;
				}

				nuevo.add(paneles.get(i), columna, fila);
				columna++;
			}

			borderPaneStock.setCenter(nuevo);
		} catch (IOException e) {

		}

	}
	
	/**
	 * Antes de nada dentro del scrollpane añadimos un borderpane donde vamos a setear en gridpane en el centro
	 * Inicializamos la vista con un GridPane creandolo desde 0 dentro del metodo
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// Contadores para la posicion dentro del Gridpane
		int columna = 0;
		int fila = 0;
		
		// Genero 50 coches rojos y los añado a una lista de vehiculos
		for (int i = 0; i < 50; i++) {
			Vehiculo nuevo = new Vehiculo("SEAT", "IBIZA", "ROJO", 17000, 21, "ibiza.jpg");
			vehiculos.add(nuevo);

		}

		try {
			
			// Recorremos la lista de vehiculos
			for (int i = 0; i < vehiculos.size(); i++) {
				
				// Cada vuelta del bucle se tiene que generar un panel nuevo para ello cargamos la vista de nuevo todas las veces 
				// para que no salte la excepcion de hijos replicados siempres genera uno nuevo
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Vehiculos.fxml"));
				AnchorPane root = loader.load();
				VehiculosC controlador = loader.getController();
				
				// Enviamos los datos de cada vehiculo al controlador de vehiculos
				controlador.setDatos(vehiculos.get(i));
				
				// Añadimos cada panel a una lista de de AnchorPane en nuestro caso siempre de root que hayamos escogido 
				paneles.add(root);
			}
			
			// Creamos un nuevo gridpane 
			GridPane nuevo = new GridPane();
			// Añadimos separacion vertical de los paneles
			nuevo.setHgap(15);
			// Añadimos separacion lateral  de los paneles
			nuevo.setVgap(15);
			
			//Recorremos la lista de paneles
			for (int i = 0; i < paneles.size(); i++) {
				
				// Contamos las columnas y la filas y indicamos el nuemo de columnas
				if (columna == 4) {
					columna = 0;
					fila++;
				}
				
				// Y añadimos los paneles de la lista y le damos una posicion en el gridpane
				nuevo.add(paneles.get(i), columna, fila);
				columna++;
			}
			
			//Por ultimo seteamos nuestro gridpane en el centro del borderpane
			borderPaneStock.setCenter(nuevo);
		
		} catch (IOException e) {
			System.out.println("ERROR: NO SE PUDO INICIALIZAR EL GRIDPANE");
		}

	}

}

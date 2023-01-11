package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import daos.HibernateUtil;
import daos.UsuariosDAO;
import daos.VehiculosDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import models.Vehiculo;
import utils.Gridpanel;

public class StockC implements Initializable {
	private static SessionFactory sessionFactory;
	private static Session session;
	private VehiculosC controlador;
	private GridPane nuevoGrid;
	private Gridpanel grid = new Gridpanel();

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

	// Lista de paneles
	private List<AnchorPane> paneles = new ArrayList<AnchorPane>();

	@FXML
	void verVehiculosAzules(ActionEvent event) throws IOException {

		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;

		paneles = grid.crearPaneles(vehiculos);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneStock.setCenter(nuevoGrid);
		
	}

	/**
	 * Antes de nada dentro del scrollpane añadimos un borderpane donde vamos a
	 * setear en gridpane en el centro Inicializamos la vista con un GridPane
	 * creandolo desde 0 dentro del metodo
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Contadores para la posicion dentro del Gridpane
		int columna = 0;
		int fila = 0;

		try {
			vehiculos = VehiculosDAO.consultaVehiculos();
			paneles = grid.crearPaneles(vehiculos);
			nuevoGrid = grid.crearGridPane(columna, fila, paneles);
			borderPaneStock.setCenter(nuevoGrid);
		} catch (IOException e) {
			System.out.println("ERROR: NO SE PUDO INICIALIZAR EL GRIDPANE");
		}

	}

}

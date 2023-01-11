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
import utils.GridpanelVehiculos;

public class StockC implements Initializable {
	private static SessionFactory sessionFactory;
	private static Session session;
	private VehiculosC controlador;
	private GridPane nuevoGrid;
	private GridpanelVehiculos grid = new GridpanelVehiculos();
	// Lista de vehiculos
	private List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

	// Lista de paneles
	private List<AnchorPane> paneles = new ArrayList<AnchorPane>();

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

	@FXML
	private MenuItem itemRojo;

	@FXML
	private MenuItem itemVerde;

	@FXML
	private MenuItem itemGris;

	@FXML
	private MenuItem itemNegro;

	@FXML
	private MenuItem itemSeat;

	@FXML
	private MenuItem itemBMW;

	@FXML
	private MenuItem itemCupra;

	@FXML
	private MenuItem itemAudi;

	@FXML
	private MenuItem itemKia;

	@FXML
	private MenuItem itemIbiza;

	@FXML
	private MenuItem itemA3;

	@FXML
	private MenuItem itemUrbaR;

	@FXML
	private MenuItem itemI7;

	@FXML
	private MenuItem itemRio;

	@FXML
	private MenuItem itemFocus;

	@FXML
	private MenuItem itemMenosDiez;

	@FXML
	private MenuItem itemEntre;

	@FXML
	private MenuItem itemMasCincuenta;

	@FXML
	private MenuItem itemFord;

	@FXML
	void verVehiculosFord(ActionEvent event) throws IOException {
		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;
		vehiculos = VehiculosDAO.vehiculosPorMarca(itemFord.getText());
		paneles = grid.crearPaneles(vehiculos);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneStock.setCenter(nuevoGrid);
	}

	@FXML
	void verVehiculosA3(ActionEvent event) throws IOException {
		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;
		vehiculos = VehiculosDAO.vehiculosPorModelo(itemA3.getText());
		paneles = grid.crearPaneles(vehiculos);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneStock.setCenter(nuevoGrid);
	}

	@FXML
	void verVehiculosAudi(ActionEvent event) throws IOException {
		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;
		vehiculos = VehiculosDAO.vehiculosPorMarca(itemAudi.getText());
		paneles = grid.crearPaneles(vehiculos);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneStock.setCenter(nuevoGrid);
	}

	@FXML
	void verVehiculosBMW(ActionEvent event) throws IOException {
		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;
		vehiculos = VehiculosDAO.vehiculosPorMarca(itemBMW.getText());
		paneles = grid.crearPaneles(vehiculos);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneStock.setCenter(nuevoGrid);
	}

	@FXML
	void verVehiculosCupra(ActionEvent event) throws IOException {
		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;
		vehiculos = VehiculosDAO.vehiculosPorMarca(itemCupra.getText());
		paneles = grid.crearPaneles(vehiculos);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneStock.setCenter(nuevoGrid);
	}

	@FXML
	void verVehiculosEntre(ActionEvent event) throws IOException {
		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;
		vehiculos = VehiculosDAO.entreVeinteCincuenta();
		paneles = grid.crearPaneles(vehiculos);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneStock.setCenter(nuevoGrid);
	}

	@FXML
	void verVehiculosFocus(ActionEvent event) throws IOException {
		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;
		vehiculos = VehiculosDAO.vehiculosPorModelo(itemFocus.getText());
		paneles = grid.crearPaneles(vehiculos);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneStock.setCenter(nuevoGrid);
	}

	@FXML
	void verVehiculosI7(ActionEvent event) throws IOException {
		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;
		vehiculos = VehiculosDAO.vehiculosPorModelo(itemI7.getText());
		paneles = grid.crearPaneles(vehiculos);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneStock.setCenter(nuevoGrid);
	}

	@FXML
	void verVehiculosIbiza(ActionEvent event) throws IOException {
		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;
		vehiculos = VehiculosDAO.vehiculosPorModelo(itemIbiza.getText());
		paneles = grid.crearPaneles(vehiculos);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneStock.setCenter(nuevoGrid);
	}

	@FXML
	void verVehiculosKia(ActionEvent event) throws IOException {
		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;
		vehiculos = VehiculosDAO.vehiculosPorMarca(itemKia.getText());
		paneles = grid.crearPaneles(vehiculos);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneStock.setCenter(nuevoGrid);
	}

	@FXML
	void verVehiculosMasCincuenta(ActionEvent event) throws IOException {
		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;
		vehiculos = VehiculosDAO.mayorCincuenta();
		paneles = grid.crearPaneles(vehiculos);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneStock.setCenter(nuevoGrid);
	}

	@FXML
	void verVehiculosMenosVeinte(ActionEvent event) throws IOException {
		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;
		vehiculos = VehiculosDAO.menorVeinte();
		paneles = grid.crearPaneles(vehiculos);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneStock.setCenter(nuevoGrid);
	}

	@FXML
	void verVehiculosRio(ActionEvent event) throws IOException {
		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;
		vehiculos = VehiculosDAO.vehiculosPorModelo(itemRio.getText());
		paneles = grid.crearPaneles(vehiculos);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneStock.setCenter(nuevoGrid);
	}

	@FXML
	void verVehiculosSeat(ActionEvent event) throws IOException {
		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;
		vehiculos = VehiculosDAO.vehiculosPorMarca(itemSeat.getText());
		paneles = grid.crearPaneles(vehiculos);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneStock.setCenter(nuevoGrid);
	}

	@FXML
	void verVehiculosUrbanR(ActionEvent event) throws IOException {
		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;
		vehiculos = VehiculosDAO.vehiculosPorModelo(itemUrbaR.getText());
		paneles = grid.crearPaneles(vehiculos);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneStock.setCenter(nuevoGrid);
	}

	@FXML
	void verVehiculosGris(ActionEvent event) throws IOException {
		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;
		vehiculos = VehiculosDAO.vehiculosPorColor(itemGris.getText());
		paneles = grid.crearPaneles(vehiculos);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneStock.setCenter(nuevoGrid);
	}

	@FXML
	void verVehiculosNegro(ActionEvent event) throws IOException {
		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;
		vehiculos = VehiculosDAO.vehiculosPorColor(itemNegro.getText());
		paneles = grid.crearPaneles(vehiculos);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneStock.setCenter(nuevoGrid);
	}

	@FXML
	void verVehiculosRojos(ActionEvent event) throws IOException {
		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;
		vehiculos = VehiculosDAO.vehiculosPorColor(itemRojo.getText());
		paneles = grid.crearPaneles(vehiculos);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneStock.setCenter(nuevoGrid);
	}

	@FXML
	void verVehiculosVerde(ActionEvent event) throws IOException {
		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;
		vehiculos = VehiculosDAO.vehiculosPorColor(itemVerde.getText());
		paneles = grid.crearPaneles(vehiculos);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneStock.setCenter(nuevoGrid);
	}

	@FXML
	void verVehiculosAzules(ActionEvent event) throws IOException {

		// Antes de generar los nuevos vehiculos hay que limpiar ambas listas
		paneles.clear();
		vehiculos.clear();

		// Repetimos el proceso cuando pulsamos el boton
		int columna = 0;
		int fila = 0;
		vehiculos = VehiculosDAO.vehiculosPorColor(itemAzul.getText());
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

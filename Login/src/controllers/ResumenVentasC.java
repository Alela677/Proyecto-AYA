package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import daos.VentasDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Vendedor;
import models.Ventas;

public class ResumenVentasC implements Initializable {

	private static List<Ventas> listaVentas = new ArrayList<Ventas>();
	private List<Object[]> vendedorList = new ArrayList<Object[]>();
	private static ObservableList<Ventas> ventasLista = null;
	private ObservableList<Vendedor> listaVendedor = null;
	Integer IdVendedor = 2;
	String NombreVendedor;
	Long totalVendido;

	@FXML
	private TableView<Ventas> tablaVentas;

	@FXML
	private TableColumn<Ventas, Integer> columnIdVenta;

	@FXML
	private TableColumn<Ventas, Integer> columnIdVehiculo;

	@FXML
	private TableColumn<Ventas, Integer> columnIdEmpleado;

	@FXML
	private TableColumn<Ventas, String> columnVendedor;

	@FXML
	private TableColumn<Ventas, String> columCliente;

	@FXML
	private TableColumn<Ventas, String> columnFechaCompra;

	@FXML
	private TableView<Vendedor> tablaVendedor;

	@FXML
	private TableColumn<Vendedor, Integer> idVendedor;

	@FXML
	private TableColumn<Vendedor, String> nombreVendedor;

	@FXML
	private TableColumn<Vendedor, Long> totalVendedor;

	@FXML
	void ordenFecha(MouseEvent event) {
		tablaVentas.getItems().clear();
		listaVentas = VentasDAO.ordenarFecha();
		ventasLista = FXCollections.observableArrayList(listaVentas);
		añadirFilasVentas(ventasLista);
	}

	@FXML
	void ordenAño(MouseEvent event) {
		tablaVentas.getItems().clear();
		listaVentas = VentasDAO.ordenarAño();
		ventasLista = FXCollections.observableArrayList(listaVentas);
		añadirFilasVentas(ventasLista);
	}

	@FXML
	void ordenMes(MouseEvent event) {
		tablaVentas.getItems().clear();
		listaVentas = VentasDAO.ordenarMes();
		ventasLista = FXCollections.observableArrayList(listaVentas);
		añadirFilasVentas(ventasLista);
	}

	@FXML
	void ordenNombreCliente(MouseEvent event) {
		tablaVentas.getItems().clear();
		listaVentas = VentasDAO.ordenarCampos("nombreCliente");
		ventasLista = FXCollections.observableArrayList(listaVentas);
		añadirFilasVentas(ventasLista);
	}

	@FXML
	void ordenAlfabetico(MouseEvent event) {
		tablaVentas.getItems().clear();
		listaVentas = VentasDAO.ordenarCampos("nombreEmpleado");
		ventasLista = FXCollections.observableArrayList(listaVentas);
		añadirFilasVentas(ventasLista);
	}

	@FXML
	void ordenEmpleado(MouseEvent event) {
		tablaVentas.getItems().clear();
		listaVentas = VentasDAO.ordenarCampos("empleado");
		ventasLista = FXCollections.observableArrayList(listaVentas);
		añadirFilasVentas(ventasLista);
	}

	@FXML
	void ordenVenta(MouseEvent event) {
		tablaVentas.getItems().clear();
		listaVentas = VentasDAO.ordenarCampos("id");
		ventasLista = FXCollections.observableArrayList(listaVentas);
		añadirFilasVentas(ventasLista);
	}

	@FXML
	void ordenarIdVehiculo(MouseEvent event) {
		tablaVentas.getItems().clear();
		listaVentas = VentasDAO.ordenarCampos("vehiculo");
		ventasLista = FXCollections.observableArrayList(listaVentas);
		añadirFilasVentas(ventasLista);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		listaVentas = VentasDAO.consultarVentas();
		ventasLista = FXCollections.observableArrayList(listaVentas);
		añadirFilasVendedor();
		añadirFilasVentas(ventasLista);
		columnasResizable(false);

	}

	private void añadirFilasVendedor() {

		vendedorList = VentasDAO.consultaVendedor();
		listaVendedor = FXCollections.observableArrayList();

		for (Object[] vendedor : vendedorList) {
			listaVendedor.add(new Vendedor((int) vendedor[0], (String) vendedor[1], (long) vendedor[2]));

		}

		idVendedor.setCellValueFactory(new PropertyValueFactory<>("id"));
		nombreVendedor.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		totalVendedor.setCellValueFactory(new PropertyValueFactory<>("total"));
		tablaVendedor.setItems(listaVendedor);
	}

	private void añadirFilasVentas(ObservableList<Ventas> ventasLista) {

		columnIdVenta.setCellValueFactory(new PropertyValueFactory<>("id"));
		columnIdVehiculo.setCellValueFactory(new PropertyValueFactory<>("vehiculo"));
		columnIdEmpleado.setCellValueFactory(new PropertyValueFactory<>("empleado"));
		columnVendedor.setCellValueFactory(new PropertyValueFactory<>("nombreEmpleado"));
		columCliente.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
		columnFechaCompra.setCellValueFactory(new PropertyValueFactory<>("fechaVenta"));
		tablaVentas.getItems().addAll(ventasLista);
	}

	private void columnasResizable(boolean opc) {
		columCliente.setResizable(opc);
		columnFechaCompra.setResizable(opc);
		columnIdEmpleado.setResizable(opc);
		columnIdVehiculo.setResizable(opc);
		columnIdVenta.setResizable(opc);
		columnVendedor.setResizable(opc);
		idVendedor.setResizable(opc);
		nombreVendedor.setResizable(opc);
		totalVendedor.setResizable(opc);

	}

	private static void limpiarListas() {
		listaVentas.clear();
		ventasLista.clear();
	}
}

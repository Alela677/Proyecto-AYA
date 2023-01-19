package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import daos.ReparacionesDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Reparaciones;

public class ReparacionesC implements Initializable {

	private static List<Reparaciones> listaReparaciones = new ArrayList<Reparaciones>();
	static ObservableList<Reparaciones> reparaciones = null;

	@FXML
	private TableView<Reparaciones> tablaReparaciones;

	@FXML
	private TableView<?> tablaMantenimiento;

	@FXML
	private TableColumn<?, ?> coID;

	@FXML
	private TableColumn<?, ?> colMecanico;

	@FXML
	private TableColumn<?, ?> colMarca;

	@FXML
	private TableColumn<?, ?> colModelo;

	@FXML
	private TableColumn<?, ?> colCliente;

	@FXML
	private TableColumn<?, ?> colPieza;

	@FXML
	private TableColumn<?, ?> colTotal;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		listaReparaciones = ReparacionesDAO.consultarRepaciones();
		reparaciones = FXCollections.observableArrayList(listaReparaciones);
		for (Reparaciones reparaciones : reparaciones) {
			System.out.println(reparaciones);
		}
		rellenarCampos(reparaciones);
	}

	private void rellenarCampos(ObservableList<Reparaciones> lista) {
		coID.setCellValueFactory(new PropertyValueFactory<>("id"));
		colCliente.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
		colModelo.setCellValueFactory(new PropertyValueFactory<>("modeloVehiculo"));
		colMarca.setCellValueFactory(new PropertyValueFactory<>("marcaVehiculo"));
		colMecanico.setCellValueFactory(new PropertyValueFactory<>("nombreEmpleado"));
		colPieza.setCellValueFactory(new PropertyValueFactory<>("idPiezas"));
		colTotal.setCellValueFactory(new PropertyValueFactory<>("totalReparacion"));
		tablaReparaciones.setItems(lista);
	}

}

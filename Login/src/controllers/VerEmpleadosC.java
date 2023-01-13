package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import daos.EmpleadosDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import models.Empleados;
import utils.GridpanelEmpleados;

public class VerEmpleadosC implements Initializable {
	private GridpanelEmpleados grid = new GridpanelEmpleados();

	List<Empleados> listaEmpleados = new ArrayList<Empleados>();

	List<AnchorPane> paneles = new ArrayList<AnchorPane>();

	private GridPane nuevoGrid;

	@FXML
	private ComboBox<String> comboBoxDepartamentos;

	@FXML
	private BorderPane borderPaneEmpleados;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		int fila = 0;
		int columna = 0;

		try {
			listaEmpleados = EmpleadosDAO.consultarEmpleados();
			paneles = grid.crearPaneles(listaEmpleados);
			nuevoGrid = grid.crearGridPane(columna, fila, paneles);
			borderPaneEmpleados.setCenter(nuevoGrid);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		rellenarCamposDepartamento();

	}

	
	
	private void rellenarCamposDepartamento() {
		List<String> departamentos = EmpleadosDAO.consultarDepartamentos();
		departamentos = departamentos.stream().distinct().collect(Collectors.toList());
		ObservableList<String> items = FXCollections.observableArrayList();
		for (String string : departamentos) {
			items.add(string);
		}
		comboBoxDepartamentos.setItems(items);
	}

}

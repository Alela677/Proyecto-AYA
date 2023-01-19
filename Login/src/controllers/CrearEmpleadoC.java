package controllers;

import java.awt.Component;
import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javax.swing.JFileChooser;

import daos.EmpleadosDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import models.Empleados;
import utils.GuardarImagen;

public class CrearEmpleadoC implements Initializable {
	final FileChooser fileChooser = new FileChooser();

	@FXML
	private Button buscarImagen;

	private Component nombreImagen;

	@FXML
	private TextField txtArchivoImg;

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtApellidos;

	@FXML
	private TextField txtDni;

	@FXML
	private TextField txtContraseña;

	@FXML
	private DatePicker boxFechaAlta;

	@FXML
	private ComboBox<String> comboDepartamento;

	@FXML
	private ComboBox<String> comboCargo;

	@FXML
	void buscarImagen(MouseEvent event) throws Exception {
		JFileChooser fc = new JFileChooser(); // Creamos un nuevo objeto JFileChooser
		int seleccion = fc.showOpenDialog(this.nombreImagen); // Abrimos el JFileChooser y guardamos el resultado en
																// seleccion
		if (seleccion == JFileChooser.APPROVE_OPTION) { // Si el usuario ha pulsado la opción Aceptar
			File fichero = fc.getSelectedFile(); // Guardamos en la variable fichero el archivo seleccionado

			if (fichero.getName().contains(".jpg") || fichero.getName().contains(".png")
					|| fichero.getName().contains(".jpeg")) {
				txtArchivoImg.setText(fichero.getName());
				GuardarImagen.guardarImagen(fichero);
			}

		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Image img = new Image("images/lupa.png");
		ImageView view = new ImageView(img);
		view.setFitHeight(12);
		view.setFitWidth(12);
		buscarImagen.setGraphic(view);

		rellenarCamposCargo();
		rellenarCamposDepartamento();
	}

	@FXML
	void borrarCamposFormulario(MouseEvent event) throws IOException {
		actualizarPagina();

	}

	@FXML
	void crearEmpleado(MouseEvent event) throws Exception {

		String nombre = txtNombre.getText();
		String apellidos = txtApellidos.getText();
		String dni = txtDni.getText();
		String departamento = comboDepartamento.getValue();
		String cargo = comboCargo.getValue();
		String fechaAlta = String.valueOf(boxFechaAlta.getValue());
		String imagen = txtArchivoImg.getText();
		String contraseña = txtContraseña.getText();

		if (imagen.isEmpty()) {
			imagen = "user.jpeg";
		}
		Empleados nuevoEmpleado = new Empleados(nombre, apellidos, dni, departamento, cargo, fechaAlta, null, imagen,
				contraseña);

		EmpleadosDAO.crearEmpleado(nuevoEmpleado);
		actualizarPagina();
	}

	private void rellenarCamposCargo() {
		List<String> cargos = EmpleadosDAO.consultarComboBox("cargo");
		cargos = cargos.stream().distinct().collect(Collectors.toList());
		ObservableList<String> items = FXCollections.observableArrayList(cargos);
		comboCargo.setItems(items);
	}

	private void rellenarCamposDepartamento() {
		
		ObservableList<String> items = FXCollections.observableArrayList();
		items.add("Ventas");
		items.add("Mecanico");
		comboDepartamento.setItems(items);
	}

	private void actualizarPagina() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/SceneCrearEmpleado.fxml"));
		AnchorPane root = loader.load();
		LoginController.root.setCenter(root);
	}
}

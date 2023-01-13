package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import daos.EmpleadosDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import models.Empleados;

public class EmpleadoC implements Initializable {
	private Empleados prueba = null;

	@FXML
	private Label lblID;

	@FXML
	private ImageView img;

	@FXML
	private Button buttonEliminar;

	@FXML
	private TextField txtApellidos;

	@FXML
	private TextField txtCargo;

	@FXML
	private TextField txtDepartamento;

	@FXML
	private TextField txtFechaAlta;

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtDNI;

	@FXML
	private Button buttonEditar;

	@FXML
	void editarEmpleado(MouseEvent event) {

		if (buttonEditar.getText().equals("Editar")) {
			buttonEditar.setText("Guardar");
			txtNombre.setEditable(true);
			txtApellidos.setEditable(true);
			txtDepartamento.setEditable(true);
			txtCargo.setEditable(true);
			txtFechaAlta.setEditable(true);
			txtDNI.setEditable(true);

		} else if (buttonEditar.getText().equals("Guardar")) {

			prueba.setNombre(txtNombre.getText());
			prueba.setApellidos(txtApellidos.getText());
			prueba.setDepartamento(txtDepartamento.getText());
			prueba.setCargo(txtCargo.getText());
			prueba.setDni(txtDNI.getText());
			prueba.setFechaAlta(txtFechaAlta.getText());

			EmpleadosDAO.actualizarEmpleado(prueba);

			buttonEditar.setText("Editar");
			txtNombre.setEditable(false);
			txtApellidos.setEditable(false);
			txtDepartamento.setEditable(false);
			txtCargo.setEditable(false);
			txtFechaAlta.setEditable(false);
			txtDNI.setEditable(false);

		}

	}

	@FXML
	void eliminaEmpleados(ActionEvent event) {
		EmpleadosDAO.eliminaEmpleado(prueba);

	}

	public void setDatos(Empleados empleados) {
		prueba = empleados;
		lblID.setText(String.valueOf(empleados.getId()));
		txtNombre.setText(empleados.getNombre());
		txtApellidos.setText(empleados.getApellidos());
		txtDNI.setText(empleados.getDni());
		txtDepartamento.setText(empleados.getDepartamento());
		txtCargo.setText(empleados.getCargo());
		txtFechaAlta.setText(String.valueOf(empleados.getFechaAlta()));
		Image imagen = new Image(getClass().getResourceAsStream("/images/" + empleados.getImagenEmpleado()));
		img.setImage(imagen);

		Circle clipShape = new Circle();
		clipShape.setCenterX(80);
		clipShape.setCenterY(100);
		clipShape.setRadius(80);

		img.setClip(clipShape);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		txtNombre.setEditable(false);
		txtApellidos.setEditable(false);
		txtDepartamento.setEditable(false);
		txtCargo.setEditable(false);
		txtFechaAlta.setEditable(false);
		txtDNI.setEditable(false);

	}

}

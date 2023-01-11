package controllers;

import daos.EmpleadosDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import models.Empleados;

public class EmpleadoC {

	@FXML
	private Label lblID;

	@FXML
	private Label lblNombre;

	@FXML
	private Label lblApellido;

	@FXML
	private Label lblDni;

	@FXML
	private Label lblDepartamento;

	@FXML
	private Label lblCargo;

	@FXML
	private Label lblFechaAlta;

	@FXML
	private Label lblFechaBaja;

	@FXML
	private ImageView img;

	@FXML
	private Button buttonEliminar;

	@FXML
	void eliminaEmpleados(ActionEvent event) {
		System.out.println(lblDni.getText());
		EmpleadosDAO.eliminaEmpleado(lblDni.getText());

	}

	public void setDatos(Empleados empleados) {
		lblID.setText(String.valueOf(empleados.getId()));
		lblNombre.setText(empleados.getNombre());
		lblApellido.setText(empleados.getApellidos());
		lblDni.setText(empleados.getDni());
		lblDepartamento.setText(empleados.getDepartamento());
		lblCargo.setText(empleados.getCargo());
		lblFechaAlta.setText(String.valueOf(empleados.getFechaAlta()));
		lblFechaBaja.setText(String.valueOf(empleados.getFechaBaja()));
		Image imagen = new Image(getClass().getResourceAsStream("/images/" + empleados.getImagenEmpleado()));
		img.setImage(imagen);

		Circle clipShape = new Circle();
		clipShape.setCenterX(80);
		clipShape.setCenterY(100);
		clipShape.setRadius(80);

		img.setClip(clipShape);

	}

}

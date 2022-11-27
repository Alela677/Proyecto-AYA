package Controllers;

import Models.Vehiculo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VehiculosC {

	@FXML
	private ImageView vehiculoImagen;

	@FXML
	private Label vehiculoMarca;

	@FXML
	private Label vehiucloModelo;

	@FXML
	private Label vehiculoColor;

	@FXML
	private Label vehiculoStock;

	@FXML
	private Label vehiculoPrecio;

	public void setDatos(Vehiculo vehiculo) {

		vehiculoMarca.setText(vehiculo.getMarca());
		vehiucloModelo.setText(vehiculo.getModelo());
		vehiculoColor.setText(vehiculo.getColor());
		vehiculoPrecio.setText(String.valueOf(vehiculo.getPrecio()));
		vehiculoStock.setText(String.valueOf(vehiculo.getStock()));
		Image imagen = new Image(getClass().getResourceAsStream(vehiculo.getImagen()));
		vehiculoImagen.setImage(imagen);

	}

}

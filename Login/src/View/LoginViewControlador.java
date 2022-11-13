package View;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;

public class LoginViewControlador implements Initializable {
	String user = "Nuevo";
	String pass = "Nuevo";

	@FXML
	public ImageView insta;
	
	@FXML
	public ImageView face;
	
	@FXML
	public ImageView twet;
	
	@FXML
	public ImageView fondo;
	
	@FXML
	private Button validar;
	
	@FXML
	private Button cancelar;
	
	@FXML
	private TextField username;
	
	@FXML
	private TextField password;

	static Main mainApp;

	@FXML
	public void instagram() {

		URL url = null;
		try {
			url = new URL("http://instagram.com/");
			try {
				Desktop.getDesktop().browse(url.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	public void twitter() {

		URL url = null;
		try {
			url = new URL("https://twitter.com/?lang=es");
			try {
				Desktop.getDesktop().browse(url.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	public void facebook() {

		URL url = null;
		try {
			url = new URL("https://es-es.facebook.com/");
			try {
				Desktop.getDesktop().browse(url.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
	}

	public void setMainApp(Main mainAp) {
		mainApp = mainAp;

	}

	public void vaidarLogin() {

		System.out.println(username.getText() + " " + password.getText());

		if ((username.getText().equals(user)) && (password.getText().equals(pass))) {
			Alert alerta = new Alert(AlertType.CONFIRMATION);
			alerta.setContentText("Bienvenido");
			alerta.showAndWait();

		} else {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setContentText("ERROR: El usuario no existe");
			alerta.showAndWait();
		}

	}

	public void cancel() {
		Platform.exit();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
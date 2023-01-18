package utils;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import java.io.File;

import javax.imageio.ImageIO;

public class GuardarImagen {

	public static void guardarImagen(File fichero) throws Exception {

		String fileName = fichero.getName();
		String ext = "";
		if (fileName.contains(".")) {
			int i = fileName.lastIndexOf('.');
			ext = i > 0 ? fileName.substring(i + 1) : "";
		}

		System.out.println(ext);

		BufferedImage leerImagen = ImageIO.read(fichero);
		System.out.println("Imagen leida");

		BufferedImage output = new BufferedImage(leerImagen.getWidth(), leerImagen.getHeight(), leerImagen.getType());

		Graphics2D g2d = output.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.drawImage(leerImagen, 0, 0, leerImagen.getWidth(), leerImagen.getHeight(), 0, 0, leerImagen.getWidth(),
				leerImagen.getHeight(), null);
		g2d.dispose();

		
		File ficheroGuardar = new File("imagen" +"/"+ fileName);
		System.out.println(ficheroGuardar.toString());
		
		if (!ficheroGuardar.exists()) {
			ficheroGuardar.mkdir();
			ImageIO.write(leerImagen, ext, ficheroGuardar);
		}
	
			ImageIO.write(leerImagen, ext, ficheroGuardar);

		System.out.println("Imagen guardada");
	}

}

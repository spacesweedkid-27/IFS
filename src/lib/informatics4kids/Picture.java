package lib.informatics4kids;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * Picture ist eine einfache Klasse um Bilder zu manipulieren. Bilder können im
 * JPEG oder PNG Format geladen oder gespeichert werden. Es besteht auch die
 * Möglichkeit ein leeres Bild zu erzeugen. 
 * Die einzelnen Farbwerte der Pixel k&#246;nnen gelesen oder geschrieben werden.
 * @see <a href="http://www.informatics4kids.de">www.informatics4kids.de</a>
 */
public final class Picture{

	private BufferedImage image;

	public Picture() {
	}

	/**
	 * @param filename
	 *            &Ouml;ffnet ein Bild (*.png,*.jpg).
	 */
	public Picture(String filename) {
		open(filename);
	}

	/**
	 * 
	 * @param width
	 *            Breite des neuen Bildes.
	 * @param height
	 *            H&oul;he des neuen Bildes.
	 */
	public Picture(int width, int height) {
		create(width, height);
	}




	/**
	 * 
	 * @return Liefert das Bild als BufferedImage zurück.
	 */
	public BufferedImage getPicture() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	/**
	 * Erstellt ein leeres Bild.
	 */

	public void create(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// set to TYPE_INT_ARGB to support transparency
	}

	/**
	 * 
	 * @param filename
	 *            Kompletter Pfad und Dateiname. Die Endung muss .png oder .jpg
	 *            sein.
	 */
	public void open(String filename) {
		try {
			// try to read from file in working directory
			File file = new File(filename);
			if (file.isFile()) {
				image = ImageIO.read(file);
			}

			// now try to read from file in same directory as this .class file
			else {
				URL url = getClass().getResource(filename);
				if (url == null) {
					url = new URL(filename);
				}
				image = ImageIO.read(url);
			}
		} catch (IOException e) {
			// e.printStackTrace();
			throw new RuntimeException("Could not open file: " + filename);
		}

		// check that image was read in
		if (image == null) {
			throw new RuntimeException("Invalid image file: " + filename);
		}
	}

	/**
	 * Return the height of the picture (in pixels).
	 */
	public int heightY() {
		return image.getHeight(null);
	}

	/**
	 * Return the width of the picture (in pixels).
	 */
	public int widthX() {
		return image.getWidth(null);
	}

	/**
	 * Return the Color of pixel (i, j).
	 */
	public Color getColor(int i, int j) {
		return new Color(image.getRGB(i, j));
	}

	/**
	 * Set the Color of pixel (i, j) to c.
	 */
	public void setColor(int i, int j, Color c) {
		if (c == null) {
			throw new RuntimeException("can't set Color to null");
		}
		image.setRGB(i, j, c.getRGB());
	}

	/**
	 * Speichert das Bild unter dem angegebenen Dateinamen. Die Dateiendung muss
	 * .png oder .jpg sein.
	 * 
	 * @param name
	 *            Name des Bildes.
	 */

	public void save(String name) {
		save(new File(name));
	}

	/**
	 * Speichert das Bild unter dem angegebenen Dateinamen.
	 * 
	 * @param filename
	 *            Kompletter Pfad und Dateiname. Die Endung muss .png oder .jpg
	 *            sein.
	 */
	private void save(File filename) {

		String file = filename.getName();

		String suffix = file.substring(file.lastIndexOf('.') + 1);
		suffix = suffix.toLowerCase();

		if (suffix.equals("jpg") || suffix.equals("png")) {
			try {
				ImageIO.write(image, suffix, filename);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Error: filename must end in .jpg or .png");
		}
	}

}

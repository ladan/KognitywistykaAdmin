package pl.edu.uj.kognitywistyka.admin.util;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageConverter {

	public static enum Format {
		JPG, PNG, GIF
	}
	
	/**
	 * Metoda zwracajaca wymiary obrazka.
	 */
	public static Dimension getDimension(String path) throws Exception {
		File file = new File(path);
		return getDimension(file);
	}
	
	/**
	 * Metoda zwracajaca wymiary obrazka.
	 */
	public static Dimension getDimension(File file) throws Exception {
		BufferedImage img = ImageIO.read(file);
		if (img == null)
			throw new Exception("unknown image format");
		return new Dimension(img.getWidth(), img.getHeight());
	}
	
	/**
	 * Metoda skalujaca obrazek do podanych wymiarow z zachowaniem proporcji.<br />
	 * Zapisuje przeskalowany obrazek pod sciezka <code>destPath</code>
	 * w takim samym formacie co plik zrodlowy.<br />
	 * Zwraca wymiary przeskalowanego obrazka.
	 */
	public static Dimension resize(String srcPath, String destPath,
			int targetWidth, int targetHeight) throws Exception {
		File srcFile = new File(srcPath);
		File destFile = new File(destPath);
		return resize(srcFile, destFile, targetWidth, targetHeight);
	}
	
	/**
	 * Metoda skalujaca obrazek do podanych wymiarow z zachowaniem proporcji.<br />
	 * Umozliwia wybranie formatu pliku wynikowego.<br />
	 * Zapisuje przeskalowany obrazek pod sciezka <code>destPath</code>, oraz
	 * zwraca jego wymiary.
	 */
	public static Dimension resize(String srcPath, String destPath,
			int targetWidth, int targetHeight, Format format) throws Exception {
		File srcFile = new File(srcPath);
		File destFile = new File(destPath);
		return resize(srcFile, destFile, targetWidth, targetHeight, format);
	}
	
	/**
	 * Metoda skalujaca obrazek do podanych wymiarow z zachowaniem proporcji.<br />
	 * Zapisuje przeskalowany obrazek w takim samym formacie co plik zrodlowy.<br />
	 * Zwraca wymiary przeskalowanego obrazka.
	 */
	public static Dimension resize(File srcFile, File destFile,
			int targetWidth, int targetHeight) throws Exception {
		return resize(srcFile, destFile, targetWidth, targetHeight, getFormat(srcFile));
	}
	
	/**
	 * Metoda skalujaca obrazek do podanych wymiarow z zachowaniem proporcji.<br />
	 * Umozliwia wybranie formatu pliku wynikowego.<br />
	 * Metoda zwraca wymiary przeskalowanego obrazka.
	 */
	public static Dimension resize(File srcFile, File destFile,
			int targetWidth, int targetHeight, Format format) throws Exception {
		BufferedImage source = ImageIO.read(srcFile);
		if (source == null || format == null)
			throw new Exception("unknown image format");
		BufferedImage result = resize(source, targetWidth, targetHeight);
		
		switch (format) {
		case JPG:
			ImageIO.write(result, "jpg", destFile);
			break;
		case PNG:
			ImageIO.write(result, "png", destFile);
			break;
		case GIF:
			ImageIO.write(result, "gif", destFile);
			break;
		}
		
		return new Dimension(result.getWidth(), result.getHeight());
	}
		
	/**
	 * Metoda skalujaca obrazek do podanych wymiarow z zachowaniem proporcji.
	 */
	public static BufferedImage resize(BufferedImage source, int targetWidth, int targetHeight) {
		int sourceWidth = source.getWidth();
		int sourceHeight = source.getHeight();
		
		float ratio = ((float) sourceHeight / (float) sourceWidth);

		if (ratio <= 1) {
			if (targetWidth == sourceWidth)
				return source;
			targetHeight = Math.round((float) targetWidth * ratio);
		} else {
			if (targetHeight == sourceHeight)
				return source;
			targetHeight = Math.round((float) targetWidth * ratio);
		}

		return scale(source, targetWidth, targetHeight);
	}
	
	/**
	 * Metoda skalujaca obrazek do podanych wymiarow bez zachowania proporcji.
	 */
	public static BufferedImage scale(BufferedImage source, int targetWidth, int targetHeight) {
		if (targetWidth <= 0)
			throw new IllegalArgumentException("width must be greater then 0");
		if (targetHeight <= 0)
			throw new IllegalArgumentException("height must be greater than 0");
		
		int imageType = source.getTransparency() == Transparency.OPAQUE ?
				BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
		BufferedImage result = new BufferedImage(targetWidth, targetHeight, imageType);

		Graphics2D resultGraphics = result.createGraphics();
		resultGraphics.setRenderingHint(
				RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		resultGraphics.drawImage(source, 0, 0, targetWidth, targetHeight, null);
		resultGraphics.dispose();

		return result;
	}
	
	/**
	 * Metoda sprawdzajaca format graficzny pliku znajdujacego sie pod
	 * sciezka <code>path</code>.<br />
	 * Zwraca format pliku lub <code>null</code> jesli format nie jest obslugiwany.
	 */
	public static Format getFormat(String path) throws IOException {
		if (path.contains("jpeg"))
			return Format.JPG;
		else if (path.contains("jpg"))
			return Format.JPG;
		else if (path.contains("png"))
			return Format.PNG;
		else if (path.contains("gif"))
			return Format.GIF;
		return null;
	}
	
	/**
	 * Metoda sprawdzajaca format graficzny pliku <code>file</code>.<br />
	 * Zwraca format pliku lub <code>null</code> jesli format nie jest obslugiwany.
	 */
	public static Format getFormat(File file) throws IOException {
		ImageInputStream iis = ImageIO.createImageInputStream(file);
		Iterator<ImageReader> it = ImageIO.getImageReaders(iis);
		if (!it.hasNext())
			return null;
		ImageReader reader = (ImageReader) it.next();
		iis.close();

		String formatName = reader.getFormatName();

		if ("jpeg".equalsIgnoreCase(formatName))
			return Format.JPG;
		else if ("jpg".equalsIgnoreCase(formatName))
			return Format.JPG;
		else if ("png".equalsIgnoreCase(formatName))
			return Format.PNG;
		else if ("gif".equalsIgnoreCase(formatName))
			return Format.GIF;

		return null;
	}
}

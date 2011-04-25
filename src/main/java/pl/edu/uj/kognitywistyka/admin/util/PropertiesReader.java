package pl.edu.uj.kognitywistyka.admin.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
	private static String pathToConfig = "/config/webapp/";
	private static String nameOfFileProp = "file.properties";
	private static String nameOfGalleryProp = "gallery.properties";

	private static Properties init(String file) {

		try {
			ClassLoader classLoader = Thread.currentThread()
					.getContextClassLoader();
			InputStream is = classLoader.getResourceAsStream(pathToConfig
					+ file);
			Properties properties = new Properties();
			properties.load(is);
			return properties;
		} catch (IOException ioe) {
			System.err.println("Properties loading failed in AppConfig");
			System.out.println("Can't locate file:" + file);
		}

		return null;

	}

	public static String getPropertyOfFile(String property) {
		return init(nameOfFileProp).getProperty(property);

	}
	public static String getPropertyOfGallery(String property) {
		return init(nameOfGalleryProp).getProperty(property);

	}

}

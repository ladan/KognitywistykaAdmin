package pl.edu.uj.kognitywistyka.admin.gallery.bo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import pl.edu.uj.kognitywistyka.admin.gallery.dao.PhotoDao;
import pl.edu.uj.kognitywistyka.admin.gallery.model.Photo;
import pl.edu.uj.kognitywistyka.admin.util.ImageConverter;
import pl.edu.uj.kognitywistyka.admin.util.PropertiesReader;

public class PhotoBoImpl implements PhotoBo, Serializable {

	private static final long serialVersionUID = 1L;
	PhotoDao photoDao;

	public void setPhotoDao(PhotoDao photoDao) {
		this.photoDao = photoDao;
	}
	
	public void addPhoto(Photo photo, UploadedFile uploadedPhoto) {

		photo.setPhoto(serveImage(uploadedPhoto));
		photoDao.addPhoto(photo);

	}

	public void removePhoto(Photo photo) {

		File delFile = new File(PropertiesReader.getPathToStoreFile()
				+ PropertiesReader.getPropertyOfGallery("pathToPhotoImg")
				+ photo.getPhoto());
		File delFileOfMin = new File(PropertiesReader.getPathToStoreFile()
				+ PropertiesReader.getPropertyOfGallery("pathToPhotoMinImg")
				+ photo.getPhoto());

		delFile.delete();
		delFileOfMin.delete();

		photoDao.removePhoto(photo);

	}

	private String serveImage(UploadedFile uploadedFile) {
		try {

			String filename = System.currentTimeMillis()
					+ uploadedFile.getName();

			File destFile = new File(PropertiesReader.getPathToStoreFile()
					+ PropertiesReader.getPropertyOfGallery("pathToPhotoImg")
					+ filename);
			File destFileOfMin = new File(
					PropertiesReader.getPathToStoreFile()
							+ PropertiesReader
									.getPropertyOfGallery("pathToPhotoMinImg")
							+ filename);

			BufferedImage imageBuffer = ImageIO.read(uploadedFile
					.getInputStream());
			BufferedImage imageBufferMin = ImageIO.read(uploadedFile
					.getInputStream());

			imageBufferMin = ImageConverter.resize(imageBufferMin, Integer
					.parseInt(PropertiesReader
							.getPropertyOfGallery("heightOfPhotoMinImg")),
					Integer.parseInt(PropertiesReader
							.getPropertyOfGallery("widthOfPhotoMinImg")));

			ImageIO.write(imageBufferMin, ImageConverter.getFormat(filename)
					.toString(), destFileOfMin);

			ImageIO.write(imageBuffer, ImageConverter.getFormat(filename)
					.toString(), destFile);

			return filename;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}

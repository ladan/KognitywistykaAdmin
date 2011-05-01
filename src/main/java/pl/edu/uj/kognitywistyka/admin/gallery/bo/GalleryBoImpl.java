package pl.edu.uj.kognitywistyka.admin.gallery.bo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import pl.edu.uj.kognitywistyka.admin.gallery.dao.GalleryDao;
import pl.edu.uj.kognitywistyka.admin.gallery.dao.PhotoDao;
import pl.edu.uj.kognitywistyka.admin.gallery.model.Gallery;
import pl.edu.uj.kognitywistyka.admin.gallery.model.Photo;
import pl.edu.uj.kognitywistyka.admin.util.ImageConverter;
import pl.edu.uj.kognitywistyka.admin.util.PropertiesReader;

public class GalleryBoImpl implements Serializable, GalleryBo {
	private static final long serialVersionUID = 1L;
	GalleryDao galleryDao;
	PhotoDao photoDao;

	public void setPhotoDao(PhotoDao photoDao) {
		this.photoDao = photoDao;
	}
	public void setGalleryDao(GalleryDao galleryDao) {
		this.galleryDao = galleryDao;
	}

	public void addGallery(Gallery gallery) {
		galleryDao.addGallery(gallery);
	}

	public void removeGallery(Gallery gallery) {
		galleryDao.removeGallery(gallery);
	}

	public List<Gallery> findAllGalleries() {
		return galleryDao.findAllGalleries();
	}

	public void removeGallery(long galleryId) {
		galleryDao.removeGallery(galleryDao.getGallery(galleryId));
	}

	public Gallery getGallery(long galleryId) {
		return galleryDao.getGallery(galleryId);
	}

	public void addPhoto(long galleryId,UploadedFile uploadedFile) {
		
		Gallery gallery = galleryDao.getGallery(galleryId);
		List<Photo> photos = gallery.getPhotos();
		
		Photo photo = new Photo();
		photo.setGallery(gallery);
		photo.setPhoto(serveImage(uploadedFile));
		
		photos.add(photo);
		gallery.setPhotos(photos);
		galleryDao.addGallery(gallery);		
		
	}

	public void removePhoto(long galleryId,Photo photo) {
		
		File delFile = new File(PropertiesReader.getPathToStoreFile() +
				PropertiesReader.getPropertyOfGallery("pathToPhotoImg")
				+ photo.getPhoto());
		File delFileOfMin = new File(PropertiesReader.getPathToStoreFile() +
				PropertiesReader.getPropertyOfGallery("pathToPhotoMinImg")
				+ photo.getPhoto());
		
		delFile.delete();
		delFileOfMin.delete();
		
		Gallery gallery = galleryDao.getGallery(galleryId);
		List<Photo> photos = gallery.getPhotos();
		photos.remove(photo);
		gallery.setPhotos(photos);
		galleryDao.addGallery(gallery);		
		
	}
	
	private String serveImage(UploadedFile uploadedFile) {
		try {

			String filename = System.currentTimeMillis()
					+ uploadedFile.getName();

			File destFile = new File(PropertiesReader.getPathToStoreFile() +
					PropertiesReader.getPropertyOfGallery("pathToPhotoImg")
							+ filename);	
			File destFileOfMin = new File(PropertiesReader.getPathToStoreFile() +
					PropertiesReader.getPropertyOfGallery("pathToPhotoMinImg")
							+ filename);
			
			BufferedImage imageBuffer = ImageIO.read(uploadedFile
					.getInputStream());	
			BufferedImage imageBufferMin = ImageIO.read(uploadedFile
					.getInputStream());

			imageBufferMin = ImageConverter.resize(imageBufferMin, Integer
					.parseInt(PropertiesReader
							.getPropertyOfGallery("heightOfPhotoMinImg")), Integer
					.parseInt(PropertiesReader
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

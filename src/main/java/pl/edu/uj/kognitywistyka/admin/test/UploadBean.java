package pl.edu.uj.kognitywistyka.admin.test;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FilenameUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;

@ManagedBean
@RequestScoped
public class UploadBean {

    private UploadedFile uploadedFile;

    public void submit() throws IOException {
    	System.out.println("Uploaded file: " + uploadedFile);
        String fileName = FilenameUtils.getName(uploadedFile.getName());
        String contentType = uploadedFile.getContentType();
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(String.format("File '%s' of type '%s' successfully uploaded!", fileName, contentType)));
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
    	System.out.println("Setter invoked");
        this.uploadedFile = uploadedFile;
    }

}

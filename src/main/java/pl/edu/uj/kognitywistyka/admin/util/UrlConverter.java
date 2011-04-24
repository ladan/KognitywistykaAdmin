package pl.edu.uj.kognitywistyka.admin.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.apache.commons.validator.UrlValidator;

@FacesConverter(forClass=URL.class)
public class UrlConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
        	if(!value.contains("://"))
        		value = "http://" + value;
            URL address = new URL(value);
            
    		UrlValidator urlValidator = new UrlValidator();
    		
    		if(!urlValidator.isValid(address.toString())){
     
    		/*	FacesMessage msg = 
    				new FacesMessage("URL Conversion error.", 
    						"Invalid URL format.");
    		*/
    	
    			throw new ConverterException(getErrorMessage(context,"UrlConversionError"));
    		}
    		return address;
            
        } catch (MalformedURLException e) {
            throw new ConverterException(getErrorMessage(context,"UrlUnknownProtocol"), e);
            // new FacesMessage(String.format("Cannot convert %s to URL", value))
        }
       
    }
    
    private FacesMessage getErrorMessage(FacesContext context, String resourceid)
    {
    	UIViewRoot viewRoot = context.getViewRoot();
    	Locale locale = viewRoot.getLocale();
    	ClassLoader loader = Thread.currentThread().getContextClassLoader();
    	ResourceBundle bundle = ResourceBundle.getBundle("messages", locale, loader);
    	String resource = bundle.getString(resourceid);
    	return new FacesMessage(resource);
    }

	@Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }

}

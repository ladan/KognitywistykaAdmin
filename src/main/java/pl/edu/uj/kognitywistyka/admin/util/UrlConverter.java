package pl.edu.uj.kognitywistyka.admin.util;

import java.net.MalformedURLException;
import java.net.URL;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=URL.class)
public class UrlConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
        	if(!value.contains("http://"))
        		value = "http://" + value;
            return new URL(value);
        } catch (MalformedURLException e) {
            throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to URL", value)), e);
        }
    }

	@Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }

}

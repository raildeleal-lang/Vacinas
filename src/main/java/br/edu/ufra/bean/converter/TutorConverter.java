package br.edu.ufra.bean.converter;

import br.edu.ufra.entidade.Tutor;
import br.edu.ufra.rn.TutorRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "tutorConverter")
public class TutorConverter implements Converter {

    private TutorRN RN = new TutorRN();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.trim().isEmpty() || "null".equalsIgnoreCase(string)) {
            return null;
        }
        try {
            return RN.obter(Integer.valueOf(string));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (!(o instanceof Tutor)) {
            return null;
        }
        Tutor tutor = (Tutor) o;
        if (tutor.getId() == null) {
            return null;
        }
        return String.valueOf(tutor.getId());
    }
}

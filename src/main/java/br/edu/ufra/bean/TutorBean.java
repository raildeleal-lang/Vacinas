package br.edu.ufra.bean;

import br.edu.ufra.entidade.Tutor;
import br.edu.ufra.rn.TutorRN;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class TutorBean {

    private List<Tutor> tutores;
    private Tutor tutor = new Tutor();
    private final TutorRN TUTOR_RN = new TutorRN();

    public TutorBean() {
    }

    @PostConstruct
    public void init() {
        tutores = TUTOR_RN.listar();
    }

    public List<Tutor> getTutores() {
        return tutores;
    }

    public void setTutores(List<Tutor> tutores) {
        this.tutores = tutores;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public void excluir() {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        if (TUTOR_RN.excluir(tutor)) {
            FacesMessage fm = new FacesMessage("Sucesso", "Tutor excluído");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            currentInstance.addMessage(null, fm);
            tutores = TUTOR_RN.listar();
        } else {
            FacesMessage fm = new FacesMessage("Erro", "Não foi possível excluir o tutor");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            currentInstance.addMessage(null, fm);
        }
    }

    public void salvar() {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        if (TUTOR_RN.salvar(tutor)) {
            FacesMessage fm = new FacesMessage("Sucesso", "Tutor salvo");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            currentInstance.addMessage(null, fm);
        } else {
            FacesMessage fm = new FacesMessage("Erro", "Não foi possível salvar o tutor");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            currentInstance.addMessage(null, fm);
        }
    }

}

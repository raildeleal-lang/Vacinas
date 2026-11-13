package br.edu.ufra.rn;

import br.edu.ufra.dao.GenericDAO;
import br.edu.ufra.entidade.Tutor;
import java.util.List;

public class TutorRN {

    private final GenericDAO<Tutor> TUTOR_DAO = new GenericDAO<>();

    public boolean salvar(Tutor tutor) {
        if (tutor == null) {
            return false;
        } else {
            if (tutor.getId() == null || tutor.getId() == 0) {
                return TUTOR_DAO.criar(tutor);
            } else {
                return TUTOR_DAO.alterar(tutor);
            }
        }
    }

    public List<Tutor> listar() {
        return TUTOR_DAO.obterTodos(Tutor.class);
    }

    public Tutor obter(Integer id) {
        if (id == null) {
            return null;
        } else {
            return TUTOR_DAO.obter(Tutor.class, id);
        }
    }

    public boolean excluir(Tutor tutor) {
        if (tutor == null) {
            return false;
        } else {
            return TUTOR_DAO.excluir(tutor);
        }
    }
}

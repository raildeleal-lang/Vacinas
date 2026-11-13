package br.edu.ufra.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "animal")
@NamedQueries({
        @NamedQuery(name = "Animal.findAll", query = "SELECT a FROM Animal a"),
        @NamedQuery(name = "Animal.findById", query = "SELECT a FROM Animal a WHERE a.id = :id"),
        @NamedQuery(name = "Animal.findByNome", query = "SELECT a FROM Animal a WHERE a.nome = :nome"),
        @NamedQuery(name = "Animal.findByTipo", query = "SELECT a FROM Animal a WHERE a.tipo = :tipo"),
        @NamedQuery(name = "Animal.findByNascimento", query = "SELECT a FROM Animal a WHERE a.nascimento = :nascimento")})
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private Character tipo;
    @Column(name = "nascimento")
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animal")
    private List<Vacina> vacinaList;
    @JoinColumn(name = "raca", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Raca raca;
    @JoinColumn(name = "tutor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tutor tutor;

    public Animal() {
    }

    public Animal(Integer id) {
        this.id = id;
    }

    public Animal(Integer id, String nome, Character tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public List<Vacina> getVacinaList() {
        return vacinaList;
    }

    public void setVacinaList(List<Vacina> vacinaList) {
        this.vacinaList = vacinaList;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ufra.entidade.Animal[ id=" + id + " ]";
    }

}

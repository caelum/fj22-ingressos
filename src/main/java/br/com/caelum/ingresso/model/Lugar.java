package br.com.caelum.ingresso.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by nando on 03/03/17.
 */
@Entity
public class Lugar {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    private String fileira;

    @NotNull
    private Integer posicao;

    /**
     * @deprecated hibernate only
     */
    public Lugar() {
    }

    public Lugar(String apelido, Integer posicao) {
        this.fileira = apelido;
        this.posicao = posicao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileira() {
        return fileira;
    }

    public void setFileira(String apelido) {
        this.fileira = apelido;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fileira == null) ? 0 : fileira.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((posicao == null) ? 0 : posicao.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Lugar other = (Lugar) obj;
        if (fileira == null) {
            if (other.fileira != null)
                return false;
        } else if (!fileira.equals(other.fileira))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (posicao == null) {
            if (other.posicao != null)
                return false;
        } else if (!posicao.equals(other.posicao))
            return false;
        return true;
    }

}

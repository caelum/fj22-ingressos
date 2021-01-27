package br.com.caelum.ingresso.model.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sala;

public class SalaForm {
    private Integer salaId;

    @NotBlank
    private String nome;

    private List<Lugar> lugares = new ArrayList<>();
    
    @NotNull
    private BigDecimal preco;

    public SalaForm() {
    }

    public SalaForm(Sala sala) {
        this.salaId = sala.getId();
        this.nome = sala.getNome();
        this.lugares = new ArrayList<>(sala.getLugares());
        this.preco = sala.getPreco();
    }

    public Integer getSalaId() {
        return salaId;
    }

    public void setSalaId(Integer salaId) {
        this.salaId = salaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }

    
    public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Sala toSala() {
        Sala sala = new Sala(this.nome, this.preco);
        sala.setId(this.salaId);
        sala.setLugares(new HashSet<>(this.lugares));
        return sala;
    }

}

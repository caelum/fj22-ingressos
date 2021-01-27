package br.com.caelum.ingresso.model;

import javax.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by nando on 03/03/17.
 */
@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Lugar> lugares = new HashSet<>();
    
    private BigDecimal preco = BigDecimal.ZERO;

    /**
     * @deprecated hibernate only
     */
    public Sala() {

    }

    public Sala(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
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


    public void add(Lugar lugar) {
        this.lugares.add(lugar);
    }

    public Set<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(Set<Lugar> lugares) {
        this.lugares = lugares;
    }
    

    public BigDecimal getPreco() {
		return preco.setScale(2, RoundingMode.HALF_UP);
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Map<String, List<Lugar>> getMapaDeLugares() {
        if(!this.lugares.isEmpty()){
            return this.lugares.stream().collect(Collectors.groupingBy(Lugar::getFileira,Collectors.toList()));
        }
        return Collections.emptyMap();
    }

    public Integer lugar(String fileira, Integer posicao){
        Optional<Lugar> optional = this.lugares.stream().filter((x) -> fileira.equals(x.getFileira()) && posicao.equals(x.getPosicao())).findFirst();
        return optional.get().getId();
    }
}

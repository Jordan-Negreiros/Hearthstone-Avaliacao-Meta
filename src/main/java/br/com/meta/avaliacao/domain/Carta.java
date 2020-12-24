package br.com.meta.avaliacao.domain;

import br.com.meta.avaliacao.domain.enums.Classe;
import br.com.meta.avaliacao.domain.enums.Tipo;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
public class Carta extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String nome;

    @NotNull
    private String descricao;

    @NotNull
    @Max(value = 10)
    private Integer ataque;

    @NotNull
    @Max(value = 10)
    private Integer defesa;

    @NotNull
    private Tipo tipo;

    @NotNull
    private Classe classe;

    public Carta() {
    }

    public Carta(Integer id, String nome, String descricao, Integer ataque, Integer defesa, Tipo tipo, Classe classe) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ataque = ataque;
        this.defesa = defesa;
        this.tipo = tipo;
        this.classe = classe;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public static Carta findByNome(String nome) {
        return find("nome", nome).firstResult();
    }

    public static List<Carta> findByClasse(Classe classe) {
        return find("classe", classe).list();
    }
    public static List<Carta> findByTipo(Tipo tipo) {
        return find("tipo", tipo).list();
    }
}

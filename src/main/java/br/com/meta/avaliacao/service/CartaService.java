package br.com.meta.avaliacao.service;

import br.com.meta.avaliacao.domain.Carta;
import br.com.meta.avaliacao.domain.dto.CartaDTO;
import br.com.meta.avaliacao.domain.enums.Classe;
import br.com.meta.avaliacao.domain.enums.Tipo;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class CartaService {

    public List<Carta> listarTodos() {
        return Carta.listAll();
    }

    public Carta buscarPorId(Integer id) {
        Carta carta = Carta.findById(id);

        if (carta == null) {
            throw new WebApplicationException("Carta com id: " + id + " não existe", Response.Status.NOT_FOUND);
        }

        return carta;
    }

    public Carta buscarPorNome(String nome) {
        Carta cartaEntity = Carta.findByNome(nome);

        if (cartaEntity == null) {
            throw new WebApplicationException("Carta com nome: " + nome + " não existe", Response.Status.NOT_FOUND);
        }

        return cartaEntity;
    }

    public List<Carta> buscarPorClasse(Classe classe) {
        List<Carta> cartas = Carta.findByClasse(classe);

        if (cartas.isEmpty()) {
            throw new WebApplicationException("Carta com a classe: " + classe + " não existe", Response.Status.NOT_FOUND);
        }

        return cartas;
    }

    public List<Carta> buscarPorTipo(Tipo tipo) {
        List<Carta> cartas = Carta.findByTipo(tipo);

        if (cartas.isEmpty()) {
            throw new WebApplicationException("Carta com o tipo: " + tipo + " não existe", Response.Status.NOT_FOUND);
        }

        return cartas;
    }

    public Carta atualizar(Integer id, CartaDTO dto) {
        Carta cartaEntity = Carta.findById(id);

        if (cartaEntity == null) {
            throw new WebApplicationException("Carta com id: " + id + " não existe", Response.Status.NOT_FOUND);
        }

        cartaEntity.setNome(dto.getNome());
        cartaEntity.setAtaque(dto.getAtaque());
        cartaEntity.setDefesa(dto.getDefesa());
        cartaEntity.setClasse(dto.getClasse());
        cartaEntity.setTipo(dto.getTipo());
        cartaEntity.setDescricao(dto.getDescricao());

        cartaEntity.persist();

        return cartaEntity;
    }

    public void criar(CartaDTO dto) {
        Carta cartaEntity = new Carta();

        cartaEntity.setNome(dto.getNome());
        cartaEntity.setAtaque(dto.getAtaque());
        cartaEntity.setDefesa(dto.getDefesa());
        cartaEntity.setClasse(dto.getClasse());
        cartaEntity.setTipo(dto.getTipo());
        cartaEntity.setDescricao(dto.getDescricao());

        cartaEntity.persist();
    }

    public void deletarCarta(Integer id) {
        Carta carta = buscarPorId(id);
        carta.delete();
    }
}

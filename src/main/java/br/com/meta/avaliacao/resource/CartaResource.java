package br.com.meta.avaliacao.resource;

import br.com.meta.avaliacao.domain.Carta;
import br.com.meta.avaliacao.domain.dto.CartaDTO;
import br.com.meta.avaliacao.domain.enums.Classe;
import br.com.meta.avaliacao.domain.enums.Tipo;
import br.com.meta.avaliacao.service.CartaService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/carta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Carta")
public class CartaResource {

    @Inject
    CartaService cartaService;

    @GET
    public List<Carta> listar() {
        List<Carta> cartas = cartaService.listarTodos();
        return cartas;
    }

    @GET
    @Path("buscarid/{id}")
    public Response getById(@PathParam("id") Integer id) {
        Carta carta = cartaService.buscarPorId(id);
        return Response.ok(carta).build();
    }

    @GET
    @Path("buscarnome/{nome}")
    public Response getByNome(@PathParam("nome") String nome) {
        Carta carta = cartaService.buscarPorNome(nome);
        return Response.ok(carta).build();
    }

    @GET
    @Path("buscarclasse/{classe}")
    public List<Carta> getByClasse(@PathParam("classe") Classe classe) {
        List<Carta> cartas = cartaService.buscarPorClasse(classe);
        return cartas;
    }

    @GET
    @Path("buscartipo/{tipo}")
    public List<Carta> getByTipo(@PathParam("tipo") Tipo tipo) {
        List<Carta> cartas = cartaService.buscarPorTipo(tipo);
        return cartas;
    }

    @POST
    @Transactional
    public Response criarCarta(@Valid CartaDTO dto) {
        cartaService.criar(dto);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response atualizar(@PathParam("id") Integer id, CartaDTO dto) {
        Carta cartaEntity = cartaService.atualizar(id, dto);
        return Response.ok(cartaEntity).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response removerCarta(@PathParam("id") Integer id) {
        cartaService.deletarCarta(id);
        return Response.ok().build();
    }

}
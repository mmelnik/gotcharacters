package mmelnik.got.characters.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.modelmapper.ModelMapper;

import interfaces.rest.GoTCharacter;
import mmelnik.got.characters.domain.CharacterEntity;
import mmelnik.got.characters.repository.CharacterRepository;

@Path("/characters")
@Produces("application/json")
public class CharactersController {

    private CharacterRepository characters;
    private ModelMapper mapper;

    @Inject
    public CharactersController(CharacterRepository characterRepository, ModelMapper mapper) {
        characters = characterRepository;
        this.mapper = mapper;
    }

    @GET
    public List<GoTCharacter> list() {
        return characters
                .findAll().stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }

    @POST
    @Consumes("application/json")
    public GoTCharacter add(GoTCharacter character) {
        return mapper.map(characters.save(mapper.map(character, CharacterEntity.class)), GoTCharacter.class);
    }

    @GET
    @Path("/{id}")
    public GoTCharacter get(@PathParam("id") long id) {
        return characters
                .findById(id)
                .map(this::fromEntity)
                .orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") long id, GoTCharacter character) {
        if (!characters.existsById(id)) {
            throw new NotFoundException();
        }
        character.setId(id);
        characters.save(toEntity(character));
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") long id) {
        if (!characters.existsById(id)) {
            throw new NotFoundException();
        }
        characters.deleteById(id);
    }

    private GoTCharacter fromEntity(Object entity) {
        return mapper.map(entity, GoTCharacter.class);
    }

    private CharacterEntity toEntity(Object model) {
        return mapper.map(model, CharacterEntity.class);
    }

}

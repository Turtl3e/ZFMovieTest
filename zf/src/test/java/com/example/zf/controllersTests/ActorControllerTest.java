package com.example.zf.controllersTests;

import com.example.zf.controlles.ActorController;
import com.example.zf.exceptions.ActorNotFoundException;
import com.example.zf.models.Actor;
import com.example.zf.models.Movie;
import com.example.zf.services.ActorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("Actor controller test")
@RunWith(SpringRunner.class)
@WebMvcTest(ActorController.class)
@AutoConfigureMockMvc
class ActorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ActorService service;

    List<Actor> allActors;

    @BeforeEach()
    void setUp() {
        //given
        Actor actor1 = Actor.builder()
                .actorId(1l)
                .firstName("Daniel")
                .secondName("Radcliffe")
                .born(LocalDate.of(2020, 1, 1))
                .placeOfBirth("London")
                .description("Description")
                .posterUrl("http://posterUrl")
                .movies(Arrays.asList(Movie.builder().pieceId(3l).title("Green book").countryOfProduction("USA")
                        .description("Description").director("John").genre("Horror").posterUrl("http://posterUrl")
                        .releaseDate(LocalDate.of(2020, 1, 1)).build()))
                .build();

        Actor actor2 = Actor.builder()
                .actorId(2l)
                .firstName("Emma")
                .secondName("Watson")
                .born(LocalDate.of(2020, 1, 1))
                .placeOfBirth("London")
                .description("Description")
                .posterUrl("http://posterUrl")
                .movies(Arrays.asList(Movie.builder().pieceId(3l).title("Green book").countryOfProduction("USA")
                        .description("Description").director("John").genre("Horror").posterUrl("http://posterUrl")
                        .releaseDate(LocalDate.of(2020, 1, 1)).build()))
                .build();

        Actor actor3 = Actor.builder()
                .actorId(3l)
                .firstName("Rupert")
                .secondName("Grint")
                .born(LocalDate.of(2020, 1, 1))
                .placeOfBirth("Stevenage")
                .description("Description")
                .posterUrl("http://posterUrl")
                .build();
        this.allActors = Arrays.asList(actor1, actor2, actor3);
    }

    @Test
    public void getActorsShouldReturnActorsWithoutMoviesThenInJSON() throws Exception {
        given(service.getActors()).willReturn(allActors);

        mvc.perform(get("/actors")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(allActors.size())))
                .andExpect(jsonPath("$[0].movies").doesNotExist())
                .andExpect(jsonPath("$[0].actorId", is(allActors.get(0).getActorId().intValue())))
                .andExpect(jsonPath("$[0].firstName", is(allActors.get(0).getFirstName())))
                .andExpect(jsonPath("$[0].secondName", is(allActors.get(0).getSecondName())))
                .andExpect(jsonPath("$[0].born", is(allActors.get(0).getBorn().toString())))
                .andExpect(jsonPath("$[0].placeOfBirth", is(allActors.get(0).getPlaceOfBirth())))
                .andExpect(jsonPath("$[0].description", is(allActors.get(0).getDescription())))
                .andExpect(jsonPath("$[0].posterUrl", is(allActors.get(0).getPosterUrl())))
                .andExpect(jsonPath("$[1].movies").doesNotExist())
                .andExpect(jsonPath("$[1].actorId", is(allActors.get(1).getActorId().intValue())))
                .andExpect(jsonPath("$[1].firstName", is(allActors.get(1).getFirstName())))
                .andExpect(jsonPath("$[1].secondName", is(allActors.get(1).getSecondName())))
                .andExpect(jsonPath("$[1].born", is(allActors.get(1).getBorn().toString())))
                .andExpect(jsonPath("$[1].placeOfBirth", is(allActors.get(1).getPlaceOfBirth())))
                .andExpect(jsonPath("$[1].description", is(allActors.get(1).getDescription())))
                .andExpect(jsonPath("$[1].posterUrl", is(allActors.get(1).getPosterUrl())))
                .andExpect(jsonPath("$[2].movies").doesNotExist())
                .andExpect(jsonPath("$[2].actorId", is(allActors.get(2).getActorId().intValue())))
                .andExpect(jsonPath("$[2].firstName", is(allActors.get(2).getFirstName())))
                .andExpect(jsonPath("$[2].secondName", is(allActors.get(2).getSecondName())))
                .andExpect(jsonPath("$[2].born", is(allActors.get(2).getBorn().toString())))
                .andExpect(jsonPath("$[2].placeOfBirth", is(allActors.get(2).getPlaceOfBirth())))
                .andExpect(jsonPath("$[2].description", is(allActors.get(2).getDescription())))
                .andExpect(jsonPath("$[2].posterUrl", is(allActors.get(2).getPosterUrl())));
    }

    @Test
    public void getActorsWithTwoParamsShouldReturnActorsMatchingAtLeastOneParamWithoutMoviesThenInJSON() throws Exception {
       final String firstNameParam="r";
       final String secondNameParam="r";
       List<Actor>foundActors=allActors.stream().filter(actor ->
               actor.getFirstName().toLowerCase().contains(firstNameParam)||
               actor.getSecondName().toLowerCase().contains(secondNameParam)).collect(Collectors.toList());

        given(service.getActorsWithParams(firstNameParam,secondNameParam)).willReturn(foundActors);

        mvc.perform(get("/actors").param("firstName",firstNameParam ).param("secondName",secondNameParam)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(foundActors.size())))
                .andExpect(jsonPath("$[0].movies").doesNotExist())
                .andExpect(jsonPath("$[0].actorId", is(allActors.get(0).getActorId().intValue())))
                .andExpect(jsonPath("$[0].firstName", is(allActors.get(0).getFirstName())))
                .andExpect(jsonPath("$[0].secondName", is(allActors.get(0).getSecondName())))
                .andExpect(jsonPath("$[0].born", is(allActors.get(0).getBorn().toString())))
                .andExpect(jsonPath("$[0].placeOfBirth", is(allActors.get(0).getPlaceOfBirth())))
                .andExpect(jsonPath("$[0].description", is(allActors.get(0).getDescription())))
                .andExpect(jsonPath("$[0].posterUrl", is(allActors.get(0).getPosterUrl())))
                .andExpect(jsonPath("$[1].movies").doesNotExist())
                .andExpect(jsonPath("$[1].actorId", is(allActors.get(2).getActorId().intValue())))
                .andExpect(jsonPath("$[1].firstName", is(allActors.get(2).getFirstName())))
                .andExpect(jsonPath("$[1].secondName", is(allActors.get(2).getSecondName())))
                .andExpect(jsonPath("$[1].born", is(allActors.get(2).getBorn().toString())))
                .andExpect(jsonPath("$[1].placeOfBirth", is(allActors.get(2).getPlaceOfBirth())))
                .andExpect(jsonPath("$[1].description", is(allActors.get(2).getDescription())))
                .andExpect(jsonPath("$[1].posterUrl", is(allActors.get(2).getPosterUrl())));
    }

    @Test
    public void getActorsWithOneParamShouldReturnActorsMatchingParamToFirstOrSecondNameWithoutMoviesThenInJSON() throws Exception {
        final String stringParam="abcd";

        List<Actor>foundActors=allActors.stream().filter(actor ->
                actor.getFirstName().toLowerCase().contains(stringParam)||
                actor.getSecondName().toLowerCase().contains(stringParam)).collect(Collectors.toList());

        given(service.getActorsWithParams(stringParam,stringParam)).willReturn(foundActors);

        mvc.perform(get("/actors").param("stringParam",stringParam)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(foundActors.size())))
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void getActorByIdShouldReturnActorDtoWithMoviesThenInJSON() throws Exception {
        final long actorId = 1;
        given(service.getActor(actorId)).willReturn(allActors.get((int) actorId));

        mvc.perform(get("/actors/{id}", actorId)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.movies").exists())
                .andExpect(jsonPath("$.movies").isArray())
                .andExpect(jsonPath("$.movies", hasSize(allActors.get((int) actorId).movies.size())))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.actorId", is(allActors.get((int) actorId).getActorId().intValue())))
                .andExpect(jsonPath("$.firstName", is(allActors.get((int) actorId).getFirstName())))
                .andExpect(jsonPath("$.secondName", is(allActors.get((int) actorId).getSecondName())))
                .andExpect(jsonPath("$.born", is(allActors.get((int) actorId).getBorn().toString())))
                .andExpect(jsonPath("$.placeOfBirth", is(allActors.get((int) actorId).getPlaceOfBirth())))
                .andExpect(jsonPath("$.description", is(allActors.get((int) actorId).getDescription())))
                .andExpect(jsonPath("$.posterUrl", is(allActors.get((int) actorId).getPosterUrl())));
    }

    //
    @Test
    public void postActorInputShouldCreateNewActorWithId() throws Exception {
        final long actorId = 2;
        final String deliveredBody="{\"actorId\":1,\"firstName\":\"Daniel\",\"secondName\":\"Radcliffe\"," + "\"born\":\"2020-01-01\",\"placeOfBirth\":\"London\",\"description\":\"Description\",\"posterUrl\":\"http://posterUrl\"}";
        Actor actor = allActors.get((int) actorId);
        given(this.service.createActor(any(Actor.class))).willReturn(actor);

        mvc.perform(MockMvcRequestBuilders.post("/actors")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(deliveredBody)
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.actorId").exists())
                .andExpect(jsonPath("$.movies").doesNotExist())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.actorId", is(allActors.get((int) actorId).getActorId().intValue())))
                .andExpect(jsonPath("$.firstName", is(allActors.get((int) actorId).getFirstName())))
                .andExpect(jsonPath("$.secondName", is(allActors.get((int) actorId).getSecondName())))
                .andExpect(jsonPath("$.born", is(allActors.get((int) actorId).getBorn().toString())))
                .andExpect(jsonPath("$.placeOfBirth", is(allActors.get((int) actorId).getPlaceOfBirth())))
                .andExpect(jsonPath("$.description", is(allActors.get((int) actorId).getDescription())))
                .andExpect(jsonPath("$.posterUrl", is(allActors.get((int) actorId).getPosterUrl()))
                );
    }

    @Test
    public void getActorWithNoExistIdShouldReturn404AndMessageFromError() throws Exception {
        final long actorId = 2l;
        when(service.getActor(actorId)).thenThrow(new ActorNotFoundException(2l));

        mvc.perform(get("/actors/{id}", actorId)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$", is("Could not find movie with id:" + actorId)));
    }

    @Test
    public void putActorShouldUpdateActorAndReturnUpdatedActorWithoutMovies() throws Exception{
        long actorId =2l;
        Actor actor=allActors.get((int)actorId);
        Actor newActor=Actor.builder().firstName("New").secondName("Actor").born(LocalDate.of(2020,2,2))
                            .description("NewDescription").placeOfBirth("NewPlace").posterUrl("http://newPoster").build();
        actor.update(newActor);

        final String deliveredBody="{\"firstName\":\"New\",\"secondName\":\"Actor\"," + "\"born\":\"2020-02-02\",\"placeOfBirth\":\"NewPlace\",\"description\"" +
                ":\"NewDescription\",\"posterUrl\":\"http://newPoster\"}";

        given(this.service.updateActor(actorId,newActor)).willReturn(actor);

        mvc.perform(MockMvcRequestBuilders.put("/actors/{id}",actorId)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(deliveredBody)
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.actorId",is(actor.getActorId().intValue())))
                .andExpect(jsonPath("$.movies").doesNotExist())
                .andExpect(jsonPath("$.firstName", is(actor.getFirstName())))
                .andExpect(jsonPath("$.secondName", is(actor.getSecondName())))
                .andExpect(jsonPath("$.born", is(actor.getBorn().toString())))
                .andExpect(jsonPath("$.placeOfBirth", is(actor.getPlaceOfBirth())))
                .andExpect(jsonPath("$.description", is(actor.getDescription())))
                .andExpect(jsonPath("$.posterUrl", is(actor.getPosterUrl()))
                );

    }

    @Test
    public void deleteActorShouldDeleteActorAndReturn204_NO_CONTENT() throws Exception {
        final long actorId = 2l;
        mvc.perform(delete("/actors/{id}", actorId)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
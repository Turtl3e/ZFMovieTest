package com.example.zf.servicesTests;

import com.example.zf.exceptions.ActorAlreadyExistException;
import com.example.zf.exceptions.ActorNotFoundException;
import com.example.zf.models.Actor;
import com.example.zf.repositories.ActorRepository;
import com.example.zf.services.ActorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ActorServiceTests {

    @Mock
    ActorRepository actorRepository;

    @InjectMocks
    ActorService actorService;

    @Test
    public void saveActorShouldReturnActor(){
        final Actor actor=Actor.builder().born(LocalDate.of(2020,1,1)).description("Description")
                .firstName("FirstName").placeOfBirth("Czestochowa").posterUrl("posterUrl").secondName("SecondName").actorId(null).build();

        given(actorRepository.existsByFirstNameIgnoreCaseAndSecondNameIgnoreCase(actor.getFirstName(),actor.getSecondName())).willReturn(false);
        given(actorRepository.save(actor)).willAnswer(invocation->invocation.getArgument(0));

        Actor created=actorService.createActor(actor);
        assertThat(created).isNotNull();
        verify(actorRepository).save(any(Actor.class));
    }

    @Test
    public void saveExistingActorShouldThrowError(){
        final Actor actor=Actor.builder().born(LocalDate.of(2020,1,1)).description("Description")
                .firstName("FirstName").placeOfBirth("Czestochowa").posterUrl("posterUrl").secondName("SecondName").actorId(1l).build();

        given(actorRepository.existsByFirstNameIgnoreCaseAndSecondNameIgnoreCase(actor.getFirstName(),actor.getSecondName())).willReturn(true);
        assertThrows(ActorAlreadyExistException.class,()-> actorService.createActor(actor));
        verify(actorRepository,never()).save(any(Actor.class));
    }

    @Test
    public void getActorsShouldReturnAllActors(){
        final Actor actor1=Actor.builder().born(LocalDate.of(2020,1,1)).description("Description")
                .firstName("FirstName").placeOfBirth("Czestochowa").posterUrl("posterUrl").secondName("SecondName").actorId(1l).build();
        final Actor actor2=Actor.builder().born(LocalDate.of(2020,1,1)).description("Description")
                .firstName("FirstName2").placeOfBirth("Czestochowa").posterUrl("posterUrl").secondName("SecondName2").actorId(1l).build();
        List<Actor> actors= Arrays.asList(actor1,actor2);

        given(actorRepository.findAll()).willReturn(actors);
        List<Actor> expectedActors=actorService.getActors();
        assertEquals(expectedActors,actors);
    }

    @Test
    public void getActorByIdShouldReturnActor(){
        final long actorId=1l;
        final Actor actor1=Actor.builder().born(LocalDate.of(2020,1,1)).description("Description")
                .firstName("FirstName").placeOfBirth("Czestochowa").posterUrl("posterUrl").secondName("SecondName").actorId(actorId).build();

        given(actorRepository.findById(actorId)).willReturn(Optional.of(actor1));

        Actor expectedActor=actorService.getActor(actorId);
        assertThat(expectedActor).isNotNull();
    }
}

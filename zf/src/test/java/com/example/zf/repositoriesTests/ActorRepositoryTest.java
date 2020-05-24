package com.example.zf.repositoriesTests;

import com.example.zf.models.Actor;
import com.example.zf.models.Movie;
import com.example.zf.repositories.ActorRepository;
import org.hibernate.engine.internal.Collections;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@DataJpaTest
public class ActorRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ActorRepository actorRepository;

    @Test
    public void whenFindByFirstNameIgnoreCaseAndSecondNameIgnoreCase_thenReturnActor(){


    }
}

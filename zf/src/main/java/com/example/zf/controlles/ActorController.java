package com.example.zf.controlles;

import com.example.zf.mapers.ActorMapper;
import com.example.zf.models.Actor;
import com.example.zf.models.dto.ActorDto;
import com.example.zf.models.dto.ActorInput;
import com.example.zf.models.dto.ActorWithoutMoviesDto;
import com.example.zf.services.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/actors")
public class ActorController {

    private final ActorService actorService;
    @GetMapping("")
    public List<Actor> getActors() {
        return actorService.getActors();
    }

    @PostMapping()
    public Actor createActor(@RequestBody ActorInput actorToCreate){
        return actorService.createActor(ActorMapper.actorInputToActor(actorToCreate));
    }
//
    @GetMapping("/{id}")
    public ActorDto getActor(@PathVariable long id)  {
        return ActorMapper.actorToActorDto(actorService.getActor(id));
    }
//
    @PutMapping("/{id}")
    public ActorWithoutMoviesDto updateActor(@PathVariable(value = "id") long actorToUpdateId, @RequestBody ActorInput updatedActor){
        return ActorMapper.mapToActorWithoutMoviesDto(actorService.updateActor(actorToUpdateId,ActorMapper.actorInputToActor(updatedActor)));
    }

    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable(value = "id") long actorToDeleteId){
        actorService.deleteActor(actorToDeleteId);
    }
}

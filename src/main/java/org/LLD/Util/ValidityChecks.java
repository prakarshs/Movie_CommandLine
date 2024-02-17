package org.LLD.Util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Entity.Actor;
import org.LLD.Entity.Director;
import org.LLD.Repository.ActorRepository;
import org.LLD.Repository.DirectorRepository;

import java.util.Map;
import java.util.NoSuchElementException;

@Data
@AllArgsConstructor
@Builder
public class ValidityChecks {
    public Director findDirectorByIdValid(Integer directorId, DirectorRepository directorRepository) {

           Director director = directorRepository.getDirectorMap().get(directorId);
           if(director==null){
               System.out.println("THE GIVEN DIRECTOR ID DOESNT EXIST. TRY AGAIN WITH A DIFFERENT ID.");
           }else  System.out.println("Director Id Is Valid !!");
           return director;
    }

    public Actor findActorByIdValid(Integer castInput, ActorRepository actorRepository) {
        Actor actor = actorRepository.getActorMap().get(castInput);
        if (actor==null){
            System.out.println("THE GIVEN ACTOR ID DOESNT EXIST. TRY AGAIN WITH A DIFFERENT ID.");
        }else System.out.println("Actor Id Is Valid !!");
        return actor;
    }
}

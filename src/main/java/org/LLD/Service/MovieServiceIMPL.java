package org.LLD.Service;

import org.LLD.Constants.Enums.Gender;
import org.LLD.Constants.Enums.MovieGenre;
import org.LLD.Entity.Actor;
import org.LLD.Entity.Director;
import org.LLD.Repository.ActorRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieServiceIMPL implements MovieService{

    ActorRepository actorRepository = new ActorRepository();
    Integer actorIndex = 1;
    @Override
    public String createMovie(String movieName, MovieGenre movieGenre, Director movieDirector, Date movieReleaseDate, List<Actor> cast) {
        return null;
    }

    @Override
    public String addDirector(String firstName, String secondName, Gender personGender, Integer numberOfMovies, Integer numberOfAwards, boolean producedMovies, Double highestGrosser, String personIntro) {
        return null;
    }

    @Override
    public String addActor(String firstName, String secondName, Gender personGender, Integer numberOfMovies, Integer numberOfAwards, Integer numberOfLeadRoles, Integer numberOfSupportRoles, String personIntro) {
        Actor actor;
    try {
        actor = Actor.builder()
                .firstName(firstName)
                .secondName(secondName)
                .personGender(personGender)
                .numberOfMovies(numberOfMovies)
                .numberOfAwards(numberOfAwards)
                .numberOfLeadRoles(numberOfLeadRoles)
                .numberOfSupportRoles(numberOfSupportRoles)
                .build();
    }catch (Exception exception){
        throw new IllegalArgumentException("ERROR IN CREATING ACTOR ENTITY INSTANCE. TRY WITH DIFFERENT VALUES");
    }
        Map<Integer, Actor> actorPutter = new HashMap<>();
        actorPutter.put(actorIndex, actor);
        actorRepository.setActorMap(actorPutter);

        String actorCreatedResponse = "CREATED ACTOR WITH ID:" + actorIndex + ": " + actorRepository.getActorMap().get(actorIndex) + " AND HIS NAME IS: " + actorRepository.getActorMap().get(actorIndex).getFirstName() + actorRepository.getActorMap().get(actorIndex).getSecondName();

        actorIndex++;

        return actorCreatedResponse;
    }
}

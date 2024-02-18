package org.LLD.Util;

import org.LLD.Entity.Actor;
import org.LLD.Entity.Movie;
import org.LLD.Repository.ActorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListItems {
    DisplayDetails displayDetails = new DisplayDetails();
    public void actorListDisplay(ActorRepository actorRepository) {
        System.out.println("Here Are All Actors: ");
        for(Map.Entry<Integer, Actor> counter : actorRepository.getActorMap().entrySet()){
            System.out.println("\n" + "Actor Number: "+ counter.getKey());
            displayDetails.displayThisActor(counter.getValue());
        }
    }

    public List<String> listActorsInMovie(Movie movie) {
        List<Actor> cast = movie.getCast();
        List<String> actorsInMovie = new ArrayList<>();
        cast.forEach(actor -> {
            actorsInMovie.add(actor.getFirstName() + " " + actor.getSecondName());
        });
        return actorsInMovie;
    }
}

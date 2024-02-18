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
            System.out.println("\n"+ "Actor Number: "+ counter.getKey());
            displayDetails.displayThisActor(counter.getValue());
        }
        System.out.println("<----- Listed All Actors ----->");
    }

    public List<String> listActorsInMovie(Movie movie) {
        List<Actor> cast = movie.getCast();
        List<String> actorsInMovie = new ArrayList<>();
        cast.forEach(actor -> {
            actorsInMovie.add(actor.getFirstName() + " " + actor.getSecondName());
        });
        return actorsInMovie;
    }

    public void actorAwardTarget(Integer target, Boolean more, ActorRepository actorRepository) {

        if(more){
            System.out.println("Actors Who Have Won Awards More Than " + target + " Are: ");
            for (Map.Entry<Integer,Actor> actorEntry : actorRepository.getActorMap().entrySet()){
                if (actorEntry.getValue().getNumberOfAwards() >= target){

                    System.out.println(actorEntry.getValue().getFirstName() + actorEntry.getValue().getSecondName() +" Has Won " + actorEntry.getValue().getNumberOfAwards());
                }
            }
        }
        else{
            System.out.println("Actors Who Have Won Awards Less Than " + target + " Are: ");
            for (Map.Entry<Integer,Actor> actorEntry : actorRepository.getActorMap().entrySet()){
                if (actorEntry.getValue().getNumberOfAwards() < target){
                    System.out.println(actorEntry.getValue().getFirstName() + actorEntry.getValue().getSecondName() +" Has Won " + actorEntry.getValue().getNumberOfAwards());
                }
            }
        }
        System.out.println("<----- Listed All Actors ----->");
    }

    public void actorMovieTarget(Integer target, Boolean more, ActorRepository actorRepository) {
        if(more){
            System.out.println("Actors Who Have Done Movies More Than " + target + " Are: ");
            for (Map.Entry<Integer,Actor> actorEntry : actorRepository.getActorMap().entrySet()){
                if (actorEntry.getValue().getNumberOfMovies() >= target){

                    System.out.println(actorEntry.getValue().getFirstName() + actorEntry.getValue().getSecondName() +" Has Done " + actorEntry.getValue().getNumberOfMovies());
                }
            }
        }
        else{
            System.out.println("Actors Who Have Done Movies Less Than " + target + " Are: ");
            for (Map.Entry<Integer,Actor> actorEntry : actorRepository.getActorMap().entrySet()){
                if (actorEntry.getValue().getNumberOfMovies() < target){
                    System.out.println(actorEntry.getValue().getFirstName() + actorEntry.getValue().getSecondName() +" Has Done " + actorEntry.getValue().getNumberOfMovies());
                }
            }
        }
        System.out.println("<----- Listed All Actors ----->");
    }
}

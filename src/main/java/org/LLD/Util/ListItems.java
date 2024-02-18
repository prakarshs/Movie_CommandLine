package org.LLD.Util;

import org.LLD.Entity.Actor;
import org.LLD.Entity.Director;
import org.LLD.Entity.Movie;
import org.LLD.Repository.ActorRepository;
import org.LLD.Repository.DirectorRepository;

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

    public void actorLeadTarget(Integer target, Boolean more, ActorRepository actorRepository) {
        if(more){
            System.out.println("Actors Who Have Done Leads More Than " + target + " Are: ");
            for (Map.Entry<Integer,Actor> actorEntry : actorRepository.getActorMap().entrySet()){
                if (actorEntry.getValue().getNumberOfLeadRoles() >= target){

                    System.out.println(actorEntry.getValue().getFirstName() + actorEntry.getValue().getSecondName() +" Has Done " + actorEntry.getValue().getNumberOfLeadRoles());
                }
            }
        }
        else{
            System.out.println("Actors Who Have Done Leads Less Than " + target + " Are: ");
            for (Map.Entry<Integer,Actor> actorEntry : actorRepository.getActorMap().entrySet()){
                if (actorEntry.getValue().getNumberOfLeadRoles() < target){
                    System.out.println(actorEntry.getValue().getFirstName() + actorEntry.getValue().getSecondName() +" Has Done " + actorEntry.getValue().getNumberOfLeadRoles());
                }
            }
        }
        System.out.println("<----- Listed All Actors ----->");
    }

    public void actorSupportTarget(Integer target, Boolean more, ActorRepository actorRepository) {
        if(more){
            System.out.println("Actors Who Have Done Support Roles More Than " + target + " Are: ");
            for (Map.Entry<Integer,Actor> actorEntry : actorRepository.getActorMap().entrySet()){
                if (actorEntry.getValue().getNumberOfSupportRoles() >= target){

                    System.out.println(actorEntry.getValue().getFirstName() + actorEntry.getValue().getSecondName() +" Has Done " + actorEntry.getValue().getNumberOfSupportRoles());
                }
            }
        }
        else{
            System.out.println("Actors Who Have Done Support Roles Less Than " + target + " Are: ");
            for (Map.Entry<Integer,Actor> actorEntry : actorRepository.getActorMap().entrySet()){
                if (actorEntry.getValue().getNumberOfSupportRoles() < target){
                    System.out.println(actorEntry.getValue().getFirstName() + actorEntry.getValue().getSecondName() +" Has Done " + actorEntry.getValue().getNumberOfSupportRoles());
                }
            }
        }
        System.out.println("<----- Listed All Actors ----->");
    }

    public void directorListDisplay(DirectorRepository directorRepository) {
        System.out.println("Here Are All Directors: ");
        for(Map.Entry<Integer, Director> counter : directorRepository.getDirectorMap().entrySet()){
            System.out.println("\n"+ "Director Number: "+ counter.getKey());
            displayDetails.displayThisDirector(counter.getValue());
        }
        System.out.println("<----- Listed All Directors ----->");
    }

    public void directorAwardTarget(Integer target, Boolean more, DirectorRepository directorRepository) {
        if(more){
            System.out.println("Directors Who Have Won Awards More Than " + target + " Are: ");
            for (Map.Entry<Integer,Director> directorEntry : directorRepository.getDirectorMap().entrySet()){
                if (directorEntry.getValue().getNumberOfAwards() >= target){

                    System.out.println(directorEntry.getValue().getFirstName() + directorEntry.getValue().getSecondName() +" Has Won " + directorEntry.getValue().getNumberOfAwards());
                }
            }
        }
        else{
            System.out.println("Actors Who Have Won Awards Less Than " + target + " Are: ");
            for (Map.Entry<Integer,Director> directorEntry : directorRepository.getDirectorMap().entrySet()){
                if (directorEntry.getValue().getNumberOfAwards() < target){
                    System.out.println(directorEntry.getValue().getFirstName() + directorEntry.getValue().getSecondName() +" Has Won " + directorEntry.getValue().getNumberOfAwards());
                }
            }
        }
        System.out.println("<----- Listed All Directors ----->");
    }

    public void directorMovieTarget(Integer target, Boolean more, DirectorRepository directorRepository) {
        if(more){
            System.out.println("Directors Who Have Done Movies More Than " + target + " Are: ");
            for (Map.Entry<Integer,Director> directorEntry : directorRepository.getDirectorMap().entrySet()){
                if (directorEntry.getValue().getNumberOfMovies() >= target){

                    System.out.println(directorEntry.getValue().getFirstName() + directorEntry.getValue().getSecondName() +" Has Done " + directorEntry.getValue().getNumberOfMovies());
                }
            }
        }
        else{
            System.out.println("Directors Who Have Done Movies Less Than " + target + " Are: ");
            for (Map.Entry<Integer,Director> directorEntry : directorRepository.getDirectorMap().entrySet()){
                if (directorEntry.getValue().getNumberOfMovies() < target){
                    System.out.println(directorEntry.getValue().getFirstName() + directorEntry.getValue().getSecondName() +" Has Done " + directorEntry.getValue().getNumberOfMovies());
                }
            }
        }
        System.out.println("<----- Listed All Directors ----->");
    }
}

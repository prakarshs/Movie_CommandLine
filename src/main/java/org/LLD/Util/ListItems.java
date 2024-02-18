package org.LLD.Util;

import org.LLD.Constants.Enums.MovieGenre;
import org.LLD.Entity.Actor;
import org.LLD.Entity.Director;
import org.LLD.Entity.Movie;
import org.LLD.Repository.ActorRepository;
import org.LLD.Repository.DirectorRepository;
import org.LLD.Repository.MovieRepository;

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

    public void directorProducer(Boolean more, DirectorRepository directorRepository) {
        if(more){
            System.out.println("Directors Who Are Also Producers Are: ");
            for(Map.Entry<Integer, Director> directorEntry : directorRepository.getDirectorMap().entrySet()){
                if(directorEntry.getValue().isProducedMovies()){
                    System.out.println(directorEntry.getValue().getFirstName() +" "+ directorEntry.getValue().getSecondName() + " Is A Producer !");
                }
            }
        }
        else{
            System.out.println("Directors Who Are Not Producers Are: ");
            for(Map.Entry<Integer, Director> directorEntry : directorRepository.getDirectorMap().entrySet()){
                if(!directorEntry.getValue().isProducedMovies()){
                    System.out.println(directorEntry.getValue().getFirstName() +" "+ directorEntry.getValue().getSecondName() + " Is Not A Producer !");
                }
            }
        }
        System.out.println("<----- Listed All Directors ----->");
    }

    public void directorGrosserTarget(Integer target, Boolean more, DirectorRepository directorRepository) {
        if(more){
            System.out.println("Directors Who Have Grossed More Than " + target + " Are: ");
            for (Map.Entry<Integer,Director> directorEntry : directorRepository.getDirectorMap().entrySet()){
                if (directorEntry.getValue().getHighestGrosser() >= target){

                    System.out.println(directorEntry.getValue().getFirstName() + directorEntry.getValue().getSecondName() +" Has Grossed " + directorEntry.getValue().getHighestGrosser());
                }
            }
        }
        else{
            System.out.println("Actors Who Have Grossed Less Than " + target + " Are: ");
            for (Map.Entry<Integer,Director> directorEntry : directorRepository.getDirectorMap().entrySet()){
                if (directorEntry.getValue().getHighestGrosser() < target){
                    System.out.println(directorEntry.getValue().getFirstName() + directorEntry.getValue().getSecondName() +" Has Grossed " + directorEntry.getValue().getHighestGrosser());
                }
            }
        }
        System.out.println("<----- Listed All Directors ----->");
    }

    public void movieListDisplay(MovieRepository movieRepository) {
        System.out.println("Here Are All Movies: ");
        for (Map.Entry<Integer, Movie> movieEntry : movieRepository.getMovieMap().entrySet()){
            displayDetails.displayThisMovie(movieEntry.getValue());
        }
    }

    public void movieByActor(Integer actorId, MovieRepository movieRepository, ActorRepository actorRepository) {
        Actor actor = actorRepository.getActorMap().get(actorId);
        System.out.println("Here Are All Movies By Actor: "+ actor.getFirstName() + " With ID: "+ actorId);
        for (Map.Entry<Integer, Movie> movieEntry : movieRepository.getMovieMap().entrySet()){
            List<Actor> cast = movieEntry.getValue().getCast();
            cast.forEach(castItem -> {
                if(actorId==castItem.getPersonId())
                {
                    System.out.println("* " + movieEntry.getValue().getMovieName());
                }
            });
        }
        System.out.println("<----- Listed All Movies By Given Actor ----->");
    }

    public void movieByDirector(Integer directorId, MovieRepository movieRepository, DirectorRepository directorRepository) {
        Director director = directorRepository.getDirectorMap().get(directorId);
        System.out.println("Here Are All Movies By Director: "+ director.getFirstName() + " With ID: "+ director);
        for (Map.Entry<Integer,Movie> movieEntry : movieRepository.getMovieMap().entrySet()){
           Integer keyId = movieEntry.getValue().getMovieDirector().getPersonId();
           if(directorId == keyId){
               System.out.println("* " + movieEntry.getValue().getMovieName());
           }
        }
        System.out.println("<----- Listed All Movies By Given Director ----->");
    }

    public void movieByGenre(MovieGenre genre, MovieRepository movieRepository) {
        System.out.println("Here Are All Movies Of Genre: "+ genre);
        for (Map.Entry<Integer,Movie> movieEntry : movieRepository.getMovieMap().entrySet()){
          MovieGenre keyGenre =  movieEntry.getValue().getMovieGenre();
          if(keyGenre == genre){
              System.out.println("* " + movieEntry.getValue().getMovieName());
          }
        }
        System.out.println("<----- Listed All Movies By Given Director ----->");
    }
}

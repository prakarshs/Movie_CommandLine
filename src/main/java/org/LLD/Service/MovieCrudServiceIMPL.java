package org.LLD.Service;

import org.LLD.Constants.Enums.Gender;
import org.LLD.Constants.Enums.MovieGenre;
import org.LLD.Entity.Actor;
import org.LLD.Entity.Director;
import org.LLD.Entity.Movie;
import org.LLD.Repository.ActorRepository;
import org.LLD.Repository.DirectorRepository;
import org.LLD.Repository.MovieRepository;
import org.LLD.Util.DisplayDetails;
import org.LLD.Util.ListItems;
import org.LLD.Util.ValidityChecks;

import java.util.*;

public class MovieCrudServiceIMPL implements MovieCrudService {

    ActorRepository actorRepository = new ActorRepository();
    DirectorRepository directorRepository = new DirectorRepository();
    MovieRepository movieRepository = new MovieRepository();
    ValidityChecks validityChecks = new ValidityChecks();
    DisplayDetails displayDetails = new DisplayDetails();
    ListItems listItems = new ListItems();
    Integer actorIndex = 1;
    Integer directorIndex = 1;
    Integer movieIndex = 1;

    @Override
    public String createMovie(String movieName, MovieGenre movieGenre, Director movieDirector, String movieReleaseDate, List<Actor> cast) {
        String movieRegCode = movieIndex + "_" + movieGenre + "_" + movieReleaseDate;
        Movie movie;
        try {
            movie = Movie.builder()
                    .movieRegCode(movieRegCode)
                    .movieName(movieName)
                    .movieGenre(movieGenre)
                    .movieDirector(movieDirector)
                    .movieReleaseYear(movieReleaseDate)
                    .cast(cast)
                    .build();
        }catch (Exception exception) {
            throw new IllegalArgumentException("ERROR IN CREATING MOVIE ENTITY INSTANCE. TRY WITH DIFFERENT VALUES");
        }
        movieRepository.getMovieMap().put(movieIndex, movie);

        String movieCreatedResponse = "CREATED MOVIE WITH ID: " + movieRepository.getMovieMap().get(movieIndex).getMovieRegCode() + " AND ITS NAME IS: " + movieRepository.getMovieMap().get(movieIndex).getMovieName()+ " AND IS DIRECTED BY: " + movieRepository.getMovieMap().get(movieIndex).getMovieDirector().getFirstName() + movieRepository.getMovieMap().get(movieIndex).getMovieDirector().getSecondName();

        movieIndex++;

        return movieCreatedResponse;
    }

    @Override
    public String addDirector(String firstName, String secondName, Gender personGender, Integer numberOfMovies, Integer numberOfAwards, boolean producedMovies, Double highestGrosser, String personIntro) {

        Director director;

        try {
            director = Director.builder()
                    .firstName(firstName)
                    .secondName(secondName)
                    .personGender(personGender)
                    .numberOfMovies(numberOfMovies)
                    .numberOfAwards(numberOfAwards)
                    .producedMovies(producedMovies)
                    .highestGrosser(highestGrosser)
                    .personIntro(personIntro)
                    .build();
        } catch (Exception exception) {
            throw new IllegalArgumentException("ERROR IN CREATING DIRECTOR ENTITY INSTANCE. TRY WITH DIFFERENT VALUES");
        }
        directorRepository.getDirectorMap().put(directorIndex,director);

        String directorCreatedResponse = "CREATED DIRECTOR WITH ID:" + directorIndex + ": " + directorRepository.getDirectorMap().get(directorIndex) + " AND HIS NAME IS: " + directorRepository.getDirectorMap().get(directorIndex).getFirstName() + "-" + directorRepository.getDirectorMap().get(directorIndex).getSecondName();

        directorIndex++;

        return directorCreatedResponse;
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
                    .personIntro(personIntro)
                    .build();
        } catch (Exception exception) {
            throw new IllegalArgumentException("ERROR IN CREATING ACTOR ENTITY INSTANCE. TRY WITH DIFFERENT VALUES");
        }
        actorRepository.getActorMap().put(actorIndex,actor);

        String actorCreatedResponse = "CREATED ACTOR WITH ID:" + actorIndex + ": " + actorRepository.getActorMap().get(actorIndex) + " AND HIS NAME IS: " + actorRepository.getActorMap().get(actorIndex).getFirstName() + actorRepository.getActorMap().get(actorIndex).getSecondName();

        actorIndex++;

        return actorCreatedResponse;
    }

    @Override
    public Director findDirectorById(Integer directorId) {
        return validityChecks.findDirectorByIdValid(directorId,directorRepository);
    }

    @Override
    public Actor findActorById(Integer castInput) {
        return validityChecks.findActorByIdValid(castInput ,actorRepository);
    }

    @Override
    public Movie findMovieById(Integer movieId) {
        return validityChecks.findMovieByIdValid(movieId, movieRepository);
    }

    @Override
    public void listAllDirectors() {
        System.out.println("HERE'S ALL YOUR DIRECTORS"+ directorRepository.getDirectorMap().size());
        for (Map.Entry<Integer, Director> entry :directorRepository.getDirectorMap().entrySet()) {
            System.out.println("Director ID: " + entry.getKey() + ", Director: " + entry.getValue());
        }
    }

    @Override
    public void displayActor(Actor actor) {
        displayDetails.displayThisActor(actor);
    }

    @Override
    public void displayDirector(Director director) {
        displayDetails.displayThisDirector(director);
    }

    @Override
    public void displayMovie(Movie movie) {
        displayDetails.displayThisMovie(movie);
    }

    @Override
    public void listAllActors() {
        listItems.actorListDisplay(actorRepository);
    }


}

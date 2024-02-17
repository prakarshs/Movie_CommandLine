package org.LLD.Service;

import org.LLD.Constants.Enums.Gender;
import org.LLD.Constants.Enums.MovieGenre;
import org.LLD.Entity.Actor;
import org.LLD.Entity.Director;

import java.util.Date;
import java.util.List;

public interface MovieCrudService {

    String createMovie(String movieName, MovieGenre movieGenre, Director movieDirector, String movieReleaseDate, List<Actor> cast);

    String addDirector(String firstName, String secondName, Gender personGender, Integer numberOfMovies, Integer numberOfAwards, boolean producedMovies, Double highestGrosser, String personIntro);
    String addActor(String firstName, String secondName, Gender personGender, Integer numberOfMovies, Integer numberOfAwards, Integer numberOfLeadRoles, Integer numberOfSupportRoles, String personIntro);

    Director findDirectorById(Integer directorId);

    Actor findActorById(Integer castInput);

    void listAllDirectors();
}

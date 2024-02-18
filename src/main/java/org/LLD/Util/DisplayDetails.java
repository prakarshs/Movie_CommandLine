package org.LLD.Util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.LLD.Entity.Actor;
import org.LLD.Entity.Director;
import org.LLD.Entity.Movie;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class DisplayDetails {

    public void displayThisActor(Actor actor) {
        System.out.println(
                "Actor First Name: "+ actor.getFirstName() + "\n"
        + "Actor Second Name: "+ actor.getSecondName() + "\n"
        + "Actor Gender: "+ actor.getPersonGender() + "\n"
        + "Actor Number Of Movies: "+ actor.getNumberOfMovies() + "\n"
        + "Actor Number Of Awards: "+ actor.getNumberOfAwards()+ "\n"
        + "Actor Lead Roles: "+ actor.getNumberOfLeadRoles()+ "\n"
        + "Actor Support Roles: "+ actor.getNumberOfSupportRoles()+ "\n"
        + "Actor Intro: "+ actor.getPersonIntro()
        );
    }
    public void displayThisDirector(Director director) {
        System.out.println(
                "Director First Name: "+ director.getFirstName() + "\n"
        + "Director Second Name: "+ director.getSecondName() + "\n"
        + "Director Gender: "+ director.getPersonGender() + "\n"
        + "Director Number Of Movies: "+ director.getNumberOfMovies() + "\n"
        + "Director Number Of Awards: "+ director.getNumberOfAwards()+ "\n"
        + "Director Produces Movies: "+ director.isProducedMovies()+ "\n"
        + "Director Highest Grosser: "+ director.getHighestGrosser()+ "\n"
        + "Director Intro: "+ director.getPersonIntro()
        );
    }

    public void displayThisMovie(Movie movie) {
        ListItems listItems = new ListItems();
        List<String> actors = listItems.listActorsInMovie(movie);

        System.out.println("Movie Reg Code: " + movie.getMovieRegCode() + "\n"
                + "Movie Name: " + movie.getMovieName() + "\n"
                + "Movie Genre: "+ movie.getMovieGenre() + "\n"
                + "Movie Director: "+ movie.getMovieDirector().getFirstName() + "\n"
                + "Movie Cast: "+ actors + "\n"
                + "Movie Release Date: "+ movie.getMovieReleaseYear()
                );
    }
}

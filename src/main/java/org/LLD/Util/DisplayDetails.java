package org.LLD.Util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.LLD.Entity.Actor;
import org.LLD.Entity.Director;

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
        + "Actor Intro: "+ actor.getPersonIntro()+ "\n"
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
        + "Director Intro: "+ director.getPersonIntro()+ "\n"
        );
    }

}

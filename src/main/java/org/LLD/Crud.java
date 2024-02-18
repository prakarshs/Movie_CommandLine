package org.LLD;

import org.LLD.Constants.Commands;
import org.LLD.Constants.Enums.CreateType;
import org.LLD.Constants.Enums.Filters.LessThan.ActorFilterLessThan;
import org.LLD.Constants.Enums.Filters.MoreThan.ActorFilterMoreThan;
import org.LLD.Constants.Enums.Gender;
import org.LLD.Constants.Enums.MovieGenre;
import org.LLD.Constants.Enums.Filters.ShowFilterType;
import org.LLD.Entity.Actor;
import org.LLD.Entity.Director;
import org.LLD.Entity.Movie;
import org.LLD.Service.MovieCrudService;
import org.LLD.Service.MovieCrudServiceIMPL;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crud {
    public static void main(String[] args) {
        MovieCrudService movieCrudService = new MovieCrudServiceIMPL();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String[] input = scanner.nextLine().trim().split(" ");

            switch (input[0]) {

                case Commands.CREATE: {
                    if (input[1].equals(CreateType.actor.toString())) {
                        //create actor

                        System.out.println(movieCrudService.addActor(input[2], input[3], Gender.valueOf(input[4]), Integer.valueOf(input[5]), Integer.valueOf(input[6]), Integer.valueOf(input[7]), Integer.valueOf(input[8]), input[9]));

                    }
                    else if (input[1].equals(CreateType.director.toString())) {
                        //create director

                        System.out.println(movieCrudService.addDirector(input[2], input[3], Gender.valueOf(input[4]), Integer.valueOf(input[5]), Integer.valueOf(input[6]), Boolean.parseBoolean(input[7]), Double.valueOf(input[8]), input[9]));

                    }
                    else if (input[1].equals(CreateType.movie.toString())) {
                        //create movie
                        System.out.println("Enter Your Movie Director Id ");
                        Integer directorId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("||----- Checking For Director Id Validity -----||");
                        Director director = movieCrudService.findDirectorById(directorId);
                        if(director==null){
                            break;
                        }

                        System.out.println("Enter Your Cast Ids ");
                        String[] castInput = scanner.nextLine().trim().split(" ");
                        System.out.println("||----- Checking For Cast Ids Validity -----||");
                        boolean isAnyCastInvalid = Arrays.stream(castInput).anyMatch(actor -> movieCrudService.findActorById(Integer.parseInt(actor))==null);
                        if(isAnyCastInvalid){
                            System.out.println("Unfortunately Some Of Actor(s) invalid.");
                            break;
                        }
                        List<Actor> cast = Arrays.stream(castInput).map(actorInput -> movieCrudService.findActorById(Integer.parseInt(actorInput))).toList();

                        System.out.println("All Cast Is Valid !");
                        System.out.println("Now Your Movie Will Be Added !");

                        System.out.println(movieCrudService.createMovie(input[2], MovieGenre.valueOf(input[3]), director, input[4], cast));

                    }
                    else {
                        System.out.println("INVALID CREATE COMMAND. CHOOSE EITHER ACTOR/DIRECTOR/MOVIE.");
                    }
                }
                break;

                case Commands.SHOW: {
                    if(input[1].equals(String.valueOf(ShowFilterType.actor))){
                        System.out.println("||----- Checking For Actor Ids Validity -----||");
                        Actor actor = movieCrudService.findActorById(Integer.parseInt(input[2]));
                         if(actor==null){
                           System.out.println("Actor Doesnt Exist. Retry.");
                           break;
                       }
                       System.out.println("Here's Your Required Actor Details: ");
                       movieCrudService.displayActor(actor);

                    }
                    else if (input[1].equals(String.valueOf(ShowFilterType.director))) {
                        System.out.println("||----- Checking For Director Ids Validity -----||");
                        Director director = movieCrudService.findDirectorById(Integer.parseInt(input[2]));
                        if(director==null){
                            System.out.println("Director Doesnt Exist. Retry.");
                            break;
                        }
                        System.out.println("Here's Your Required Director Details: ");
                        movieCrudService.displayDirector(director);

                    }
                    else if (input[1].equals(String.valueOf(ShowFilterType.movie))) {
                        System.out.println("||----- Checking For Movie Ids Validity -----||");
                        Movie movie = movieCrudService.findMovieById(Integer.parseInt(input[2]));
                        if(movie==null){
                            System.out.println("Movie Doesnt Exist. Retry.");
                            break;
                        }
                        System.out.println("Here's Your Required Director Details: ");
                        movieCrudService.displayMovie(movie);

                    }
                }
                break;
                case Commands.SHOW_ALL: {
                    if(input[1].equals(String.valueOf(ShowFilterType.actor))){
                        if(input[2].equals(String.valueOf(ActorFilterMoreThan.none))){
                            movieCrudService.listAllActors();
                        }
                        Integer target =Integer.parseInt(input[3]);
                        Boolean more = true;
                        if (input[2].equals(String.valueOf(ActorFilterMoreThan.award_more_than))) {
                            movieCrudService.listAllActorAward(target,more);
                        }
                        else if (input[2].equals(String.valueOf(ActorFilterLessThan.award_less_than))) {
                            more = false;
                            movieCrudService.listAllActorAward(target,more);
                        }
                        else if (input[2].equals(String.valueOf(ActorFilterMoreThan.movie_more_than))) {
                            movieCrudService.listAllActorMovie(target,more);
                        }
                        else if (input[2].equals(String.valueOf(ActorFilterLessThan.movie_less_than))) {
                            more = false;
                            movieCrudService.listAllActorMovie(target,more);
                        }
                        else if (input[2].equals(String.valueOf(ActorFilterMoreThan.lead_more_than))) {
                            movieCrudService.listAllActorLead(target,more);
                        }
                        else if (input[2].equals(String.valueOf(ActorFilterLessThan.lead_less_than))) {
                            more = false;
                            movieCrudService.listAllActorLead(target,more);
                        }
                        else if (input[2].equals(String.valueOf(ActorFilterMoreThan.support_more_than))) {
                            movieCrudService.listAllActorSupport(target,more);
                        }
                        else if (input[2].equals(String.valueOf(ActorFilterLessThan.support_less_than))) {
                            more = false;
                            movieCrudService.listAllActorSupport(target,more);
                        }

                    }
                }
                break;
                default: {
                    System.out.println("THERE HAS BEEN AN ERROR");
                }
            }
        }
    }
}
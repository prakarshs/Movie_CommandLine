package org.LLD;

import org.LLD.Constants.Commands;
import org.LLD.Constants.Enums.CreateType;
import org.LLD.Constants.Enums.Gender;
import org.LLD.Entity.Actor;
import org.LLD.Entity.Director;
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
                        System.out.println(castInput[0] + "," + castInput[1] + "," + castInput[2]);
                        List<Actor> cast = Arrays.stream(castInput).map(actorInput -> movieCrudService.findActorById(Integer.parseInt(actorInput))).toList();

                        System.out.println("All Cast Is Valid!");


                    }
                    else {
                        System.out.println("INVALID CREATE COMMAND. CHOOSE EITHER ACTOR/DIRECTOR/MOVIE.");
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
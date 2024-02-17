package org.LLD;

import org.LLD.Constants.Enums.CreateType;
import org.LLD.Constants.Enums.Gender;
import org.LLD.Service.MovieService;
import org.LLD.Service.MovieServiceIMPL;
import org.LLD.Constants.Commands;

import java.util.Scanner;

public class Crud {
    public static void main(String[] args) {
        MovieService movieService = new MovieServiceIMPL();
        Scanner scanner = new Scanner(System.in);
        while (true){
            String[] input = scanner.nextLine().trim().split(" ");

            switch (input[0]){

                case Commands.CREATE :{
                    if(input[1].equals(CreateType.actor.toString())){
                        //create actor

                        System.out.println(movieService.addActor(input[2],input[3], Gender.valueOf(input[4]),Integer.valueOf( input[5]),Integer.valueOf(input[6]),Integer.valueOf(input[7]),Integer.valueOf(input[8]),input[9]));

                    } else if (input[1].equals(CreateType.director.toString())) {
                        //create director

                        System.out.println(movieService.addDirector(input[2],input[3], Gender.valueOf(input[4]),Integer.valueOf( input[5]),Integer.valueOf(input[6]),Boolean.parseBoolean(input[7]),Double.valueOf(input[8]),input[9]));

                    } else if (input[1].equals(CreateType.movie.toString())) {
                        //create movie
                        System.out.println("movie banega idhar");
                    }
                    else System.out.println("INVALID CREATE COMMAND. CHOOSE EITHER ACTOR/DIRECTOR/MOVIE.");
                    break;
                }
                default:{
                    System.out.println("THERE HAS BEEN AN ERROR");
                }
            }
        }
    }
}
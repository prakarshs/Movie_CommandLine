package org.LLD.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Constants.Enums.MovieGenre;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    private String movieId;
    private String movieName;
    private MovieGenre movieGenre;
    private Director movieDirector;
    private String movieReleaseYear;
    private List<Actor> cast;

}

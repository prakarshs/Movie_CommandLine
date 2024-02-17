package org.LLD.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.LLD.Constants.Enums.Gender;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class MoviePerson {
    private String firstName;
    private String secondName;
    private Gender personGender;
    private Integer numberOfMovies;
    private Integer numberOfAwards;
    private String personIntro;
}

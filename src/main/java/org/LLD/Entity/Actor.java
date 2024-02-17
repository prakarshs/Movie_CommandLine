package org.LLD.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Actor extends MoviePerson{
    private Integer numberOfLeadRoles;
    private Integer numberOfSupportRoles;
}

package org.LLD.Repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Entity.Actor;
import org.LLD.Entity.Director;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DirectorRepository {
    private Map<Integer, Director> directorMap;
}

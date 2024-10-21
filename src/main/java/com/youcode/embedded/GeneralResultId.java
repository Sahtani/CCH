package com.youcode.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GeneralResultId implements Serializable {

    private Long competitionId;

    private Long cyclistId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralResultId that = (GeneralResultId) o;
        return Objects.equals(competitionId, that.competitionId) &&
                Objects.equals(cyclistId, that.cyclistId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(competitionId, cyclistId);
    }
}

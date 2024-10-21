package com.youcode.embedded;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Data
@Setter
@Getter
@Embeddable

public class GeneralResultId implements Serializable {
    private Long competitionId;
    private Long cyclistId;
}

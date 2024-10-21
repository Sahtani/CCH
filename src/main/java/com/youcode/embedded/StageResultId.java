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
public class StageResultId implements Serializable {

    private Long stageId;
    private Long cyclistId;

}

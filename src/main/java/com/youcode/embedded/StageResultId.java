package com.youcode.embedded;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
@Data
@Setter
@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class StageResultId implements Serializable {

    private Long stageId;
    private Long cyclistId;

}

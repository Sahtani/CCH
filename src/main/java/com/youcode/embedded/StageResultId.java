package com.youcode.embedded;

import lombok.Data;

import java.io.Serializable;
@Data
public class StageResultId implements Serializable {

    private Long stageId;
    private Long cyclistId;

}

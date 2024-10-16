package com.youcode.embedded;

import lombok.Data;

import java.io.Serializable;
@Data
public class GeneralResultId implements Serializable {
    private Long competitionId;
    private Long cyclistId;
}

package com.project.openfeign.openfeign.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Location {
    private String type;
    private Coordinate coordinates;
}

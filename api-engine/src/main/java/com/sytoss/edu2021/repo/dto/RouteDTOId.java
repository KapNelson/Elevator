package com.sytoss.edu2021.repo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class RouteDTOId implements Serializable {

    private int floorNumber;
    private int idEngine;

    public RouteDTOId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteDTOId that = (RouteDTOId) o;
        return floorNumber == that.floorNumber && idEngine == that.idEngine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(floorNumber, idEngine);
    }
}

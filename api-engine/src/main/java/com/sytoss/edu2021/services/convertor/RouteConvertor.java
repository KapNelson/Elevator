package com.sytoss.edu2021.services.convertor;

import com.sytoss.edu2021.common.RouteBOM;
import com.sytoss.edu2021.repo.dto.RouteDTO;

import java.util.Set;
import java.util.TreeSet;

public class RouteConvertor {

    public void toDTO(RouteBOM source, RouteDTO destination) {
    }

    public void fromDTO(RouteDTO[] source, RouteBOM destination) {
        Set<Integer> points = new TreeSet<>();
        for (RouteDTO point : source) {
            points.add(point.getRouteDTOId().getFloorNumber());
        }
        destination.setQueueOfFloors(points);
    }

}
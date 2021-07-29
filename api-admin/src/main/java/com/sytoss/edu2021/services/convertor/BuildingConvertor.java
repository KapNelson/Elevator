package com.sytoss.edu2021.services.convertor;

import com.sytoss.edu2021.bom.BuildingBOM;
import com.sytoss.edu2021.repo.dto.BuildingDTO;

public class BuildingConvertor {

    public void toDTO(BuildingBOM source, BuildingDTO destination) {
        if (source.getId() != null) {
            destination.setId(source.getId());
        }
        destination.setAddress(source.getAddress());
        destination.setFloorsAmount(source.getFloorsAmount());
    }

    public void fromDTO(BuildingDTO source, BuildingBOM destination) {
        destination.setId(source.getId());
        destination.setAddress(source.getAddress());
        destination.setFloorsAmount(source.getFloorsAmount());
    }

}
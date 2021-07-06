package com.sytoss.edu2021.services.convertor;

import com.sytoss.edu2021.repo.dto.BuildingBOM;
import com.sytoss.edu2021.repo.dto.BuildingDTO;

public class BuildingConvertor {

    public void toDTO(BuildingBOM source, BuildingDTO destination){

        destination.setAddress(source.getAddress());
        destination.setFloorsAmount(source.getFloorsAmount());
        if (source.getCabins() != null && source.getCabins().size() > 0){
            // TODO: yevgenyv: implements me
        }
    }
    public void fromDTO(BuildingDTO source, BuildingBOM destination){

        destination.setId(source.getId());
        destination.setAddress(source.getAddress());
        destination.setFloorsAmount(source.getFloorsAmount());
    }

}
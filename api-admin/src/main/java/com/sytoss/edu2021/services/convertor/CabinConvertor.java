package com.sytoss.edu2021.services.convertor;

import com.sytoss.edu2021.bom.BuildingBOM;
import com.sytoss.edu2021.bom.CabinBOM;

public class CabinConvertor {
    public void toDTO(CabinBOM source, CabinDTO destination){
        destination.setNumber(source.getNumber());
    }

    public void toDTO(BuildingBOM source, CabinDTO destination){
        BuildingDTO buildingDTO = new BuildingDTO();
        new BuildingConvertor().toDTO(source, buildingDTO);
        destination.setBuilding(buildingDTO);
    }

    public void fromDTO(CabinDTO source, CabinBOM destination){
        destination.setId(source.getId());
        destination.setNumber(source.getNumber());

    }
}

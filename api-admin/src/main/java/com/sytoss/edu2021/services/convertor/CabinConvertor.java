package com.sytoss.edu2021.services.convertor;


import com.sytoss.edu2021.repo.dto.BuildingDTO;
import com.sytoss.edu2021.repo.dto.CabinBOM;
import com.sytoss.edu2021.repo.dto.CabinDTO;

public class CabinConvertor {
    public void toDTO(CabinBOM source, CabinDTO destination){
        destination.setNumber(source.getNumber());
       /* BuildingDTO buildingDTO = new BuildingDTO();
        new BuildingConvertor().toDTO(source.getBuilding(), buildingDTO);
        destination.setBuilding(buildingDTO);*/
    }
    public void fromDTO(CabinDTO source, CabinBOM destination){
        destination.setId(source.getId());
        destination.setNumber(source.getNumber());
       /* new BuildingConvertor().fromDTO(source.getBuilding(), destination.getBuilding());*/
    }
}

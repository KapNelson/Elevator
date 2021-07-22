package com.sytoss.edu2021.services.convertor;

import com.sytoss.edu2021.bom.BuildingBOM;
import com.sytoss.edu2021.bom.CabinBOM;
import com.sytoss.edu2021.bom.EngineBOM;
import com.sytoss.edu2021.repo.dto.BuildingDTO;
import com.sytoss.edu2021.repo.dto.CabinDTO;
import com.sytoss.edu2021.repo.dto.EngineDTO;

public class EngineConvertor {
    public void toDTO(EngineBOM source, EngineDTO destination){
        destination.setId(source.getId());
        destination.setCurrentFloor(source.getCurrentFloor());
        destination.setEngineStatus(source.getStatus());
    }
    public void toDTO(EngineBOM source, BuildingDTO destination){
        BuildingBOM buildingBOM = new BuildingBOM();
        new BuildingConvertor().fromDTO(destination,buildingBOM);

    }

    public void toDTO(BuildingBOM source, EngineDTO destination){
        BuildingDTO buildingDTO = new BuildingDTO();
        new BuildingConvertor().toDTO(source, buildingDTO);
        destination.setBuilding(buildingDTO);
    }

    public void toDTO(CabinBOM source, EngineDTO destination){
        CabinDTO cabinDTO = new CabinDTO();
        new CabinConvertor().toDTO(source, cabinDTO);
        destination.setCabin(cabinDTO);
    }

    public void fromDTO(EngineDTO source, EngineBOM destination){
        destination.setId(source.getId());
        destination.setCurrentFloor(source.getCurrentFloor());
        destination.setStatus(source.getEngineStatus());
    }
}

package com.sytoss.edu2021.services.convertor;


import com.sytoss.edu2021.bom.EngineBOM;
import com.sytoss.edu2021.repo.dto.EngineDTO;

public class EngineConvertor {
    public void toDTO(EngineBOM source, EngineDTO destination) {
        destination.setId(source.getId());
        destination.setCurrentFloor(source.getCurrentFloor());
        destination.setEngineStatus(source.getStatus());
        destination.setBuildingId(source.getBuildingId());
        destination.setCabinId(source.getCabinId());
    }

    public void fromDTO(EngineDTO source, EngineBOM destination) {
        destination.setId(source.getId());
        destination.setCurrentFloor(source.getCurrentFloor());
        destination.setStatus(source.getEngineStatus());
        destination.setBuildingId(source.getBuildingId());
        destination.setCabinId(source.getCabinId());
    }
}

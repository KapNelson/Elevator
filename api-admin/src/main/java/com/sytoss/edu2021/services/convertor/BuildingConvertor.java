package com.sytoss.edu2021.services.convertor;

import com.sytoss.edu2021.bom.BuildingBOM;
import com.sytoss.edu2021.bom.CabinBOM;
import com.sytoss.edu2021.bom.EngineBOM;
import com.sytoss.edu2021.repo.dto.BuildingDTO;
import com.sytoss.edu2021.repo.dto.EngineDTO;

public class BuildingConvertor {

    public void toDTO(BuildingBOM source, BuildingDTO destination) {
        if (source.getId() != null) {
            destination.setId(source.getId());
        }
        destination.setAddress(source.getAddress());
        destination.setFloorsAmount(source.getFloorsAmount());
        if (source.getEngines() != null && source.getEngines().size() > 0) {
            for (EngineBOM engineBOM : source.getEngines()) {
                 EngineDTO engineDTO = new EngineDTO();
                new EngineConvertor().toDTO(engineBOM, engineDTO);
                destination.addEngine(engineDTO);
            }
        }
    }

    public void fromDTO(BuildingDTO source, BuildingBOM destination) {
        destination.setId(source.getId());
        destination.setAddress(source.getAddress());
       destination.setFloorsAmount(source.getFloorsAmount());
        if (source.getEngines() != null && source.getEngines().size() > 0) {
            for (EngineDTO engineDTO : source.getEngines()) {
                EngineBOM engineBOM = new EngineBOM();
                new EngineConvertor().fromDTO(engineDTO, engineBOM);
                destination.addEngine(engineBOM);
            }
        }
    }

}
package com.sytoss.edu2021.services.convertor;

import com.sytoss.edu2021.bom.BuildingBOM;
import com.sytoss.edu2021.bom.CabinBOM;

public class BuildingConvertor {

    public void toDTO(BuildingBOM source, BuildingDTO destination) {
        if (source.getId() != null) {
            destination.setId(source.getId());
        }
        destination.setAddress(source.getAddress());
        destination.setFloorsAmount(source.getFloorsAmount());
        if (source.getCabins() != null && source.getCabins().size() > 0) {
            for (CabinBOM cabinBOM : source.getCabins()) {
                CabinDTO cabinDTO = new CabinDTO();
                new CabinConvertor().toDTO(cabinBOM, cabinDTO);
                destination.addCabin(cabinDTO);
            }
        }
    }

    public void fromDTO(BuildingDTO source, BuildingBOM destination) {
        destination.setId(source.getId());
        destination.setAddress(source.getAddress());
       destination.setFloorsAmount(source.getFloorsAmount());
        if (source.getCabins() != null && source.getCabins().size() > 0) {
            for (CabinDTO cabinDTO : source.getCabins()) {
                CabinBOM cabinBOM = new CabinBOM();
                new CabinConvertor().fromDTO(cabinDTO, cabinBOM);
                destination.addCabin(cabinBOM);
            }
        }
    }

}
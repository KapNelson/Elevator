package com.sytoss.edu2021.services.convertor;

import com.sytoss.edu2021.bom.BuildingBOM;
import com.sytoss.edu2021.bom.CabinBOM;
import com.sytoss.edu2021.repo.dto.BuildingDTO;
import com.sytoss.edu2021.repo.dto.CabinDTO;

public class CabinConvertor {
    public void toDTO(CabinBOM source, CabinDTO destination){
        if(source.getId() != 0)
        {
            destination.setId(source.getId());
        }
        destination.setNumber(source.getNumber());
        destination.setId(source.getId());
    }

    public void fromDTO(CabinDTO source, CabinBOM destination){
        destination.setId(source.getId());
        destination.setNumber(source.getNumber());
    }
}

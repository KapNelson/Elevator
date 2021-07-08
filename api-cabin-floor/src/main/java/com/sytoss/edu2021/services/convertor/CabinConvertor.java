package com.sytoss.edu2021.services.convertor;


import com.sytoss.edu2021.repo.dto.CabinBOM;
import com.sytoss.edu2021.repo.dto.CabinDTO;

public class CabinConvertor {
    public void toDTO(CabinBOM source, CabinDTO destination){
        destination.setNumber(source.getNumber());
    }
    public void fromDTO(CabinDTO source, CabinBOM destination){
        destination.setId(source.getId());
        destination.setNumber(source.getNumber());
    }
}

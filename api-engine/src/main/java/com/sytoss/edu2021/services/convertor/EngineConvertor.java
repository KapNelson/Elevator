package com.sytoss.edu2021.services.convertor;

import com.sytoss.edu2021.repo.dto.EngineBOM;
import com.sytoss.edu2021.repo.dto.EngineDTO;

public class EngineConvertor {
    public void fromDTO(EngineDTO source, EngineBOM destination)
    {
        destination.setId(source.getId());
    }

    public void toDTO(EngineBOM source, EngineDTO destination)
    {
        if(source.getId() != null)
        {
            destination.setId(source.getId());
        }
    }
}

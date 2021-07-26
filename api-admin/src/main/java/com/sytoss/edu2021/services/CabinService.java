package com.sytoss.edu2021.services;

import com.sytoss.edu2021.bom.BuildingBOM;
import com.sytoss.edu2021.bom.CabinBOM;
import com.sytoss.edu2021.bom.EngineBOM;
import com.sytoss.edu2021.repo.BuildingRepository;
import com.sytoss.edu2021.repo.CabinRepository;
import com.sytoss.edu2021.repo.LogRepository;
import com.sytoss.edu2021.repo.dto.BuildingDTO;
import com.sytoss.edu2021.repo.dto.CabinDTO;
import com.sytoss.edu2021.repo.dto.LogDTO;
import com.sytoss.edu2021.services.convertor.BuildingConvertor;
import com.sytoss.edu2021.services.convertor.CabinConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class CabinService {

    @Autowired
    private CabinRepository cabinRepository;

    public CabinBOM addCabin(CabinBOM cabin) {
        CabinDTO cabinDTO = new CabinDTO();
        new CabinConvertor().toDTO(cabin,cabinDTO);
        cabinDTO = cabinRepository.save(cabinDTO);
        new CabinConvertor().fromDTO(cabinDTO,cabin);
        return cabin;
    }
}
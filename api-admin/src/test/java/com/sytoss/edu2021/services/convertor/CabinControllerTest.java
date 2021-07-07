package com.sytoss.edu2021.services.convertor;

import com.sytoss.edu2021.repo.dto.BuildingBOM;
import com.sytoss.edu2021.repo.dto.BuildingDTO;
import com.sytoss.edu2021.repo.dto.CabinBOM;
import com.sytoss.edu2021.repo.dto.CabinDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

public class CabinControllerTest {



    @Test
    public void toDTOCompareTest(){
        BuildingBOM buildingBOM = new BuildingBOM();
        buildingBOM.setId(25);
        buildingBOM.setAddress("Address");
        buildingBOM.setFloorsAmount(20);

        BuildingDTO buildingDTO = new BuildingDTO();
        new BuildingConvertor().toDTO(buildingBOM, buildingDTO);

        CabinBOM cabinBOM = new CabinBOM();
        cabinBOM.setNumber(25);
        cabinBOM.setBuilding(buildingBOM);

        CabinDTO cabinDTO = new CabinDTO();

        new CabinConvertor().toDTO(cabinBOM, cabinDTO);
        cabinDTO.setBuilding(buildingDTO);

        Assertions.assertEquals(cabinBOM.getNumber(), cabinDTO.getNumber());
        Assertions.assertEquals(cabinBOM.getBuilding().getId(), cabinDTO.getBuilding().getId());
        Assertions.assertEquals(cabinBOM.getBuilding().getAddress(), cabinDTO.getBuilding().getAddress());
        Assertions.assertEquals(cabinBOM.getBuilding().getFloorsAmount(), cabinDTO.getBuilding().getFloorsAmount());

    }

    @Test
    public void fromDTOCompareTest(){
        BuildingDTO buildingDTO = new BuildingDTO();
        buildingDTO.setId(2);
        buildingDTO.setAddress("Address");
        buildingDTO.setFloorsAmount(20);

        BuildingBOM buildingBOM = new BuildingBOM();
        new BuildingConvertor().fromDTO(buildingDTO, buildingBOM);

        CabinDTO cabinDTO = new CabinDTO();
        cabinDTO.setNumber(25);
        cabinDTO.setBuilding(buildingDTO);


        CabinBOM cabinBOM = new CabinBOM();
        new CabinConvertor().fromDTO(cabinDTO, cabinBOM);
        cabinBOM.setBuilding(buildingBOM);

        Assertions.assertEquals(cabinBOM.getNumber(), cabinDTO.getNumber());
        Assertions.assertEquals(cabinBOM.getBuilding().getId(), cabinDTO.getBuilding().getId());
        Assertions.assertEquals(cabinBOM.getBuilding().getAddress(), cabinDTO.getBuilding().getAddress());
        Assertions.assertEquals(cabinBOM.getBuilding().getFloorsAmount(), cabinDTO.getBuilding().getFloorsAmount());
    }
}

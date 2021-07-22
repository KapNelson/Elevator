package com.sytoss.edu2021.services.convertor;


import com.sytoss.edu2021.bom.BuildingBOM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BuildingConvertorTest {
    @Test
    public void toDTOCompareTest()
    {
        BuildingBOM buildBOM = new BuildingBOM();
        buildBOM.setId(1);
        buildBOM.setAddress("Address");
        buildBOM.setFloorsAmount(19);
        BuildingDTO buildDTO = new BuildingDTO();
        new BuildingConvertor().toDTO(buildBOM, buildDTO);

        Assertions.assertEquals(buildBOM.getId(), buildDTO.getId());
        Assertions.assertEquals(buildBOM.getAddress(), buildDTO.getAddress());
        Assertions.assertEquals(buildBOM.getFloorsAmount(), buildDTO.getFloorsAmount());
    }
    @Test
    public void fromDTOInstanceOfTest() {
        BuildingDTO buildDTO = new BuildingDTO();
        buildDTO.setId(2);
        buildDTO.setAddress("Address");
        buildDTO.setFloorsAmount(20);
        BuildingBOM buildBOM = new BuildingBOM();
        new BuildingConvertor().fromDTO(buildDTO, buildBOM);

        Assertions.assertEquals(buildBOM.getId(), buildDTO.getId());
        Assertions.assertEquals(buildBOM.getAddress(), buildDTO.getAddress());
        Assertions.assertEquals(buildBOM.getFloorsAmount(), buildDTO.getFloorsAmount());
    }
}
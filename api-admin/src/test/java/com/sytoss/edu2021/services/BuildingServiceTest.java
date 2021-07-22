package com.sytoss.edu2021.services;

import com.sytoss.edu2021.repo.BuildingRepository;
import com.sytoss.edu2021.repo.CabinRepository;
import com.sytoss.edu2021.bom.BuildingBOM;
import com.sytoss.edu2021.bom.CabinBOM;
import com.sytoss.edu2021.services.convertor.BuildingConvertor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BuildingServiceTest {
/*
    @Mock
    private BuildingRepository buildingRepository;

    @Mock
    private CabinRepository cabinRepository;

    @InjectMocks
    private BuildingService service;

    @Test
    public void shouldReturnBuildingById(){

        when(buildingRepository.findBuildingById(1)).thenReturn(getDefaultBuildingDTO());

        BuildingBOM building = service.getBuildingById(1);
        assertEquals(1, (int)building.getId());
        assertEquals(0, building.getCabins().size());
        assertEquals(9, building.getFloorsAmount());
        assertEquals("USSR, Leningrad", building.getAddress());
    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldRaiseExceptionByNotExistsId(){
        BuildingBOM building = service.getBuildingById(1);
    }

    @Test
    public void shouldRaiseExceptionWithCorrectMessageByNotExistsId(){
        try {
            BuildingBOM building = service.getBuildingById(1);
        }catch(EntityNotFoundException e){
            assertEquals(1, e.getId());
            assertEquals("There is no such building 1", e.getMessage());
        }
    }

    @Test
    public void shouldRegisterBuilding(){
        BuildingDTO dto = getDefaultBuildingDTO();
        when(buildingRepository.save(any(BuildingDTO.class))).thenReturn(dto);

        BuildingBOM request = new BuildingBOM();
        request.setFloorsAmount(9);
        request.setAddress("USSR, Leningrad");

        BuildingBOM response = service.register(request);
        assertEquals(1, (int)response.getId());
    }

    @Test(expected = AlreadyExistsException.class)
    public void shouldRaiseExceptionByAlreadyExists(){
        BuildingDTO dto = getDefaultBuildingDTO();
        when(buildingRepository.findBuildingByAddress("USSR, Leningrad")).thenReturn(dto);
        when(buildingRepository.save(any(BuildingDTO.class))).thenReturn(dto);

        BuildingBOM request = new BuildingBOM();
        request.setFloorsAmount(9);
        request.setAddress("USSR, Leningrad");

        BuildingBOM response = service.register(request);

    }

    @Test(expected = ValidationException.class)
    public void shouldRaiseExceptionByValidation(){
        BuildingDTO dto = getNotValidBuildingDTO();
        BuildingBOM bom = new BuildingBOM();
        new BuildingConvertor().fromDTO(dto,bom);
        service.register(bom);
    }

    @Test
    public void shouldRaiseExceptionWithCorrectMessageByValidationException(){
        try {
            BuildingDTO dto = getNotValidBuildingDTO();
            BuildingBOM bom = new BuildingBOM();
            new BuildingConvertor().fromDTO(dto,bom);
            service.register(bom);
        }catch(ValidationException e){
            assertEquals("Data is not valid", e.getMessage());
        }
    }

    @Test
    public void shouldFindBuildingByAddress(){
        BuildingDTO dto = getDefaultBuildingDTO();
        when(buildingRepository.findBuildingByAddress("USSR, Leningrad")).thenReturn(dto);

        BuildingBOM response = service.searchByAddress("USSR, Leningrad");
        assertEquals(1, (int)response.getId());
    }

    @Test
    public void shouldAddCabin()
    {
        BuildingDTO buildingDTO = getDefaultBuildingDTO();
        CabinDTO cabinDTO = getDefaultCabinDTO();
        when(buildingRepository.findBuildingById(1)).thenReturn(buildingDTO);
        when(cabinRepository.save(any(CabinDTO.class))).thenReturn(cabinDTO);
        CabinBOM cabinBOM = new CabinBOM();
        cabinBOM.setNumber(1);
        BuildingBOM buildingBOM = new BuildingBOM();
        buildingBOM.setId(1);
        buildingBOM.setAddress("USSR, Leningrad");
        buildingBOM.setFloorsAmount(9);
//        cabinBOM.setBuilding(buildingBOM);
//        service.addCabin(cabinBOM.getBuilding().getId(),cabinBOM);

        assertEquals(1,cabinDTO.getId());
        assertEquals(1,cabinDTO.getBuilding().getId());
    }

    private CabinDTO getDefaultCabinDTO(){
        CabinDTO dto = new CabinDTO();
        dto.setId(1);
        dto.setNumber(1);
        dto.setBuilding(getDefaultBuildingDTO());
        return dto;
    }

    private BuildingDTO getDefaultBuildingDTO(){
        BuildingDTO dto = new BuildingDTO();
        dto.setId(1);
        dto.setFloorsAmount(9);
        dto.setAddress("USSR, Leningrad");
        return  dto;
    }

    private BuildingDTO getNotValidBuildingDTO(){
        BuildingDTO dto = new BuildingDTO();
        dto.setId(1);
        dto.setFloorsAmount(0);
        dto.setAddress("USSR, Leningrad");
        return  dto;
    }*/

}

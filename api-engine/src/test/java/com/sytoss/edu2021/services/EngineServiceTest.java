package com.sytoss.edu2021.services;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EngineServiceTest {
/*

    @Mock
    private EngineRepository engineRepository;

    @InjectMocks
    private EngineService engineService;

    @Test
    public void creationTest() {
        EngineDTO engineDTO = getDefaultEngineDTO();
        when(engineRepository.save(any(EngineDTO.class))).thenReturn(engineDTO);
        EngineBOM response = engineService.create(1);
        assertEquals(1, (int)response.getId());
    }

    @Test
    public void getEngineTest() {
        EngineDTO engineDTO = getDefaultEngineDTO();
        when(engineRepository.findEngineDTById(1)).thenReturn(engineDTO);
        EngineBOM response = engineService.getEngine(1);
        assertEquals(1, (int)response.getId());

    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldRaiseExceptionByNotFound() {
        EngineBOM engineBOM = engineService.getEngine(1);
    }

    public EngineDTO getDefaultEngineDTO() {
        EngineDTO dto = new EngineDTO();
        dto.setId(1);
        return dto;
    }
*/

}

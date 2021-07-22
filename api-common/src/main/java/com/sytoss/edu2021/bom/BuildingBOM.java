package com.sytoss.edu2021.bom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class BuildingBOM {

    private Integer id;
    private String address;
    private int floorsAmount;

    private List<EngineBOM> engines;

    public BuildingBOM() {
    }

    public BuildingBOM(String address, int floorsAmount){
        this.address =address;
        this.floorsAmount = floorsAmount;
    }

    @JsonIgnore
    public List<EngineBOM> getEngines() {
        return Collections.unmodifiableList(engines);
    }


    public void addEngine(EngineBOM engine) {
        engines.add(engine);
    }

    public boolean isValid() {
        return !ObjectUtils.isEmpty(address) && floorsAmount > 1;
    }

    public EngineBOM findEngineById(int idEngine) {
        for(EngineBOM engine : engines){
            if (engine.getId() == idEngine)
                return engine;
        }
        return null;
    }

    @JsonIgnore
    public Integer[] getEngineIdList(){
        Integer[] engineId = new Integer[engines.size()];
        for (int i = 0; i < engines.size(); i++) {
            engineId[i]=engines.get(i).getId();
        }
        return engineId;
    }
}
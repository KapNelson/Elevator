package com.sytoss.edu2021.services;

import com.sytoss.edu2021.common.Direction;
import com.sytoss.edu2021.controllers.FeignProxyAdmin;
import com.sytoss.edu2021.repo.EngineRepository;
import com.sytoss.edu2021.bom.EngineBOM;
import com.sytoss.edu2021.services.convertor.EngineConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EngineService {

    @Autowired
    private FeignProxyAdmin proxyAdmin;

    public EngineBOM getEngineByIdBuildingAndNumber(Integer buildingId, Integer number) {
        return proxyAdmin.getEngineByIdBuildingAndNumber(buildingId, number);
    }
}

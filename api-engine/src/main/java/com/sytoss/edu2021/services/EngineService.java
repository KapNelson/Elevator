package com.sytoss.edu2021.services;

import com.sytoss.edu2021.repo.dto.EngineBOM;
import org.springframework.stereotype.Service;

@Service
public class EngineService {
    public EngineBOM create() {
        return new EngineBOM();
    }
}

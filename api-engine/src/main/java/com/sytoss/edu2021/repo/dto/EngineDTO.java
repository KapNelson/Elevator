package com.sytoss.edu2021.repo.dto;

import com.sytoss.edu2021.repo.EngineRepository;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "app_engine")
public class EngineDTO {

    @Getter
    @Setter
    @Id
    @Column(name = "id_engine")
    Integer id;

}

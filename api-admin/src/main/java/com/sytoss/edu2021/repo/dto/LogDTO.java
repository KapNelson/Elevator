package com.sytoss.edu2021.repo.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "app_log")
public class LogDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log")
    private Integer id;

    @Column(name = "body_log")
    private String bodyLog;

    @Column(name = "date_log")
    private LocalDateTime dateLog;

    public LogDTO() {
    }
}

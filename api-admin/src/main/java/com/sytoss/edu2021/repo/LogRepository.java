package com.sytoss.edu2021.repo;

import com.sytoss.edu2021.repo.dto.LogDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface LogRepository extends JpaRepository<LogDTO, Integer> {
}

package com.bs.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bs.domain.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{

}

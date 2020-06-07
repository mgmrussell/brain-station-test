package com.bs.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bs.domain.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

}

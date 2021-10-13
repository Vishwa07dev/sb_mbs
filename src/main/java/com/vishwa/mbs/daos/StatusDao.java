package com.vishwa.mbs.daos;

import com.vishwa.mbs.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusDao extends JpaRepository<Status, Integer> {
    public Status findByStatusName(String statusName);
}
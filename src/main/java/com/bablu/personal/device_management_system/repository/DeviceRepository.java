package com.bablu.personal.device_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bablu.personal.device_management_system.entity.Device;


@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
}

package com.bablu.personal.device_management_system.service;

import java.util.List;

import com.bablu.personal.device_management_system.entity.Device;

public interface DeviceService {

	public List<Device> getAllDevices();

	public Device getDeviceById(Long id);

	public Device addDevice(Device device);

	public Device updateDevice(Long id, Device deviceDetails);

	public void deleteDevice(Long id);
}

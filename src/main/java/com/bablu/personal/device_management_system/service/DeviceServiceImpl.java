package com.bablu.personal.device_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bablu.personal.device_management_system.entity.Device;
import com.bablu.personal.device_management_system.exception.DeviceNotFoundException;
import com.bablu.personal.device_management_system.repository.DeviceRepository;

@Service
public class DeviceServiceImpl implements DeviceService {
	@Autowired
	private DeviceRepository deviceRepository;

	@Override
	public List<Device> getAllDevices() {
		List<Device> deviceList = deviceRepository.findAll();
		return deviceList;
	}

	@Override
	public Device getDeviceById(Long id) {
		return deviceRepository.findById(id)
				.orElseThrow(() -> new DeviceNotFoundException("Device with ID " + id + " not found"));

	}

	@Override
	public Device addDevice(Device device) {
		return deviceRepository.save(device);

	}

	@Override
	public Device updateDevice(Long id, Device deviceDetails) {
		Device device = deviceRepository.findById(id).orElse(null);
		if (device != null) {
			device.setName(deviceDetails.getName());
			device.setStatus(deviceDetails.getStatus());
			device.setType(deviceDetails.getType());
			return deviceRepository.save(device);
		}
		return null;
	}

	@Override
	public void deleteDevice(Long id) {
		if (!deviceRepository.existsById(id)) {
            throw new DeviceNotFoundException("Device with ID " + id + " not found");
        }
	}

}

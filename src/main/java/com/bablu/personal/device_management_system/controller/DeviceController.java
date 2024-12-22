package com.bablu.personal.device_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bablu.personal.device_management_system.entity.Device;
import com.bablu.personal.device_management_system.service.DeviceService;


@RestController
@RequestMapping("/devices")
public class DeviceController {
	
	@Autowired
	private  DeviceService deviceService;
	
	@GetMapping
	public List<Device> getAllDevice() {
		return deviceService.getAllDevices();
	}
	
	@GetMapping("/{id}")
	public  Device getDeviceById(@PathVariable Long id ) {
		return deviceService.getDeviceById(id);
	
	}
	@PostMapping("/adddevice")
	public Device addDevice(@RequestBody Device device) {
		
		return deviceService.addDevice(device);
	}

    @PutMapping("/{id}")
    public Device updateDevice(@PathVariable Long id, @RequestBody Device device) {
        return deviceService.updateDevice(id, device);
    }

    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
    }	

}

package it.epicode.progettoS6L5.controllers;

import it.epicode.progettoS6L5.company.Device;
import it.epicode.progettoS6L5.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public List<Device> getAllDevices() {
        return deviceService.getdevices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        return ResponseEntity.ok(deviceService.getDevice(id)
                .orElseThrow(() -> new RuntimeException("Device not found")));
    }

    @PostMapping
    public ResponseEntity<Device> createDevice(@RequestBody Device device) {
        Device createdDevice = deviceService.save(device);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDevice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody Device deviceDetails) {
        Device updatedDevice = deviceService.update(id, deviceDetails)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        return ResponseEntity.ok(updatedDevice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        deviceService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{deviceId}/assign")
    public ResponseEntity<Device> assignDevice(@PathVariable Long deviceId, @RequestParam Long employeeId) {
        Device assignedDevice = deviceService.assignDevice(deviceId, employeeId);
        return ResponseEntity.ok(assignedDevice);
    }

    @PostMapping("/{deviceId}/unassign")
    public ResponseEntity<Device> unassignDevice(@PathVariable Long deviceId, @RequestParam Long employeeId) {
        Device unassignedDevice = deviceService.unassignDevice(deviceId, employeeId);
        return ResponseEntity.ok(unassignedDevice);
    }
}

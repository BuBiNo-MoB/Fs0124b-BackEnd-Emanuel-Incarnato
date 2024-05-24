package it.epicode.progettoS6L5.services;

import it.epicode.progettoS6L5.company.Device;

import java.util.List;
import java.util.Optional;

public interface DeviceService {
    List<Device> getdevices();
    Optional<Device> getDevice(Long id);
    Device save(Device device);
    Optional <Device> update(Long deviceId, Device device);
    Optional <Device> delete(Long deviceId);
    Device assignDevice(Long deviceId, Long employeeId);
    Device unassignDevice(Long deviceId, Long employeeId);
}
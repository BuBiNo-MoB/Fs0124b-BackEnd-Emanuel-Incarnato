package it.epicode.progettoS6L5.services;

import it.epicode.progettoS6L5.company.Device;
import it.epicode.progettoS6L5.company.DeviceStatus;
import it.epicode.progettoS6L5.repositories.DeviceRepository;
import it.epicode.progettoS6L5.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class DeviceServiceImpl  implements DeviceService{

    @Autowired
    DeviceRepository devices;

    @Autowired
    EmployeeRepository employee;

    @Override
    public List<Device> getdevices() {
        return devices.findAll();
    }

    @Override
    public Optional<Device> getDevice(Long id) {
        try{
            return devices.findById(id);
        }catch (Exception ex){
            log.error(String.format("device id = not found", id), ex);
            return  Optional.empty();
        }
    }

    @Override
    public Device save(Device device) {
        try{
            return devices.save(device);
        }catch (Exception ex){
            log.error(String.format("impossible to save the",device),ex);
            return null;
        }
    }

    @Override
    public Optional<Device> update(Long deviceId, Device device) {
        try{
            var dev = devices.findById(deviceId).orElseThrow();
            dev.builder()
                    .withEmployee(dev.getEmployee())
                    .withDeviceType(dev.getDeviceType())
                    .withDeviceStatus(dev.getDeviceStatus())
                    .build();
            return Optional.of(devices.save(dev));
        }
        catch (NoSuchElementException ex){
            log.error(String.format("devices with id = %s not found", deviceId), ex);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Device> delete(Long deviceId) {
        try{
            var dev = devices.findById(deviceId).orElseThrow();
            devices.delete(dev);
            return Optional.of(dev);
        }catch (NoSuchElementException ex){
            log.error(String.format("not found with id = %s",deviceId),ex);
            throw new RuntimeException("device not found");
        }catch(Exception ex){
            log.error(String.format("\n" +
                    "error in deleting the device with id = %s", deviceId),ex);
            throw new RuntimeException();
        }
    }


    @Override
    public Device assignDevice(Long deviceId, Long employeeId) {
        var dev = devices.findById(deviceId)
                .orElseThrow(()-> new RuntimeException("device not found"));
        if (dev.getDeviceStatus() != DeviceStatus.AVAILABLE){
            throw new RuntimeException("the device is not available for assignment");
        }
        var emp = employee.findById(employeeId)
                .orElseThrow(()-> new RuntimeException("employee not found"));
        dev.setEmployee(emp);
        dev.setDeviceStatus(DeviceStatus.ASSIGNED);
        return devices.save(dev);
    }

    @Override
    public Device unassignDevice(Long deviceId, Long employeeId) {
        var dev = devices.findById(deviceId)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        if (dev.getEmployee() == null || !dev.getEmployee().getId().equals(employeeId)) {
            throw new RuntimeException("The device is not assigned to the specified employee");
        }
        dev.setEmployee(null);
        dev.setDeviceStatus(DeviceStatus.AVAILABLE);
        return devices.save(dev);
    }
}

package it.epicode.progettoS6L5.services;

import it.epicode.progettoS6L5.company.Employee;
import it.epicode.progettoS6L5.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl  implements EmployeeService{

    @Autowired
    EmployeeRepository employees;

    @Override
    public List<Employee> getEmployees() {
        return employees.findAll();
    }

    @Override
    public Optional<Employee> getEmployee(Long id) {
        try{
            return employees.findById(id);
        }catch (Exception ex){
            log.error(String.format("employee id = not found", id), ex);
            return  Optional.empty();
        }
    }

    @Override
    public Employee save(Employee employee) {
        try{
            return employees.save(employee);
        }catch (Exception ex){
            log.error(String.format("impossible to save the",employee),ex);
            return null;
        }
    }

    @Override
    public Optional <Employee> update(Long employeeId, Employee employee) {
        try{
            var emp = employees.findById(employeeId).orElseThrow();
            emp.builder()
                    .withFirstName(emp.getFirstName())
                    .withLastName(emp.getLastName())
                    .withNickName(emp.getNickName())
                    .withEmail(emp.getEmail())
                    .withDevices(emp.getDevices())
                    .build();
            return Optional.of(employees.save(emp));
        }
        catch (NoSuchElementException ex){
            log.error(String.format("employees with id = %s not found", employeeId), ex);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Employee> delete(Long employeeId) {
        try{
            var emp = employees.findById(employeeId).orElseThrow();
            employees.delete(emp);
            return Optional.of(emp);
        }catch (NoSuchElementException ex){
            log.error(String.format("not found with id = %s",employeeId),ex);
            throw new RuntimeException("employee not found");
        }catch(Exception ex){
            log.error(String.format("\n" +
                    "error in deleting the employee with id = %s", employeeId),ex);
            throw new RuntimeException();
        }
    }
}
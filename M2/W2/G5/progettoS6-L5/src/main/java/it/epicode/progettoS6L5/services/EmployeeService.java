package it.epicode.progettoS6L5.services;

import it.epicode.progettoS6L5.company.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getEmployees();
    Optional <Employee> getEmployee(Long id);
    Employee save(Employee employee);
    Optional <Employee> update(Long employeeId, Employee employee);
    Optional <Employee> delete(Long employeeId);
}

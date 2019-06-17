package momenton.codechallenge.service;


import momenton.codechallenge.model.Employee;
import momenton.codechallenge.model.EmployeeDTO;
import momenton.codechallenge.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepo;

	public EmployeeService(EmployeeRepository employeeRepo){
		this.employeeRepo = employeeRepo;
	}

	public List<EmployeeDTO> getHierarchy() {
		List<Employee> employees = employeeRepo.findAll();
		List<EmployeeDTO> employeeDTOS = new ArrayList();
		Map<Integer, EmployeeDTO> employeeDTOMap = new HashMap();

		for (Employee employee : employees) {
			Integer employeeId = employee.getId();
			Integer managerId = employee.getManagerId();
			if(managerId == null)
				managerId = 0;
			String employeeName = employee.getEmployeeName();

			//Employee
			if (!employeeDTOMap.containsKey(employeeId)) {
				EmployeeDTO employeeDTO = new EmployeeDTO();
				employeeDTOMap.put(employeeId, employeeDTO);
			}
			EmployeeDTO employeeDTO = employeeDTOMap.get(employeeId);
			employeeDTO.setEmployeeId(employeeId);
			employeeDTO.setEmployeeName(employeeName);
			employeeDTO.setManagerId(managerId);

			//Manager
			if (!employeeDTOMap.containsKey(managerId)) {
				EmployeeDTO managerDTO = new EmployeeDTO();
				employeeDTOMap.put(managerId, managerDTO);
			}
			EmployeeDTO managerDTO = employeeDTOMap.get(managerId);
			managerDTO.setEmployeeId(managerId);
			managerDTO.addSubordinate(employeeDTO);

		}


		for (EmployeeDTO employeeDTO : employeeDTOMap.values()) {
			if (employeeDTO.getManagerId() == null)
				employeeDTOS.add(employeeDTO);
		}

		return employeeDTOS;
	}

}

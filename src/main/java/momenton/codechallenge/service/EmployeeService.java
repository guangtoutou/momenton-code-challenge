package momenton.codechallenge.service;


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
		List<EmployeeDTO> employeeDTOS = new ArrayList();

		return employeeDTOS;
	}

}

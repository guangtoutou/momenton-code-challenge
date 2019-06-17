package momenton.codechallenge.service;


import momenton.codechallenge.model.Employee;
import momenton.codechallenge.model.EmployeeDTO;
import momenton.codechallenge.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {

	@MockBean
	private EmployeeRepository employeeRepo;

	private EmployeeService employeeService;

	@Before
	public void init() {
		employeeService = new EmployeeService(employeeRepo);
	}

	//Normal
	@Test
	public void testGetHierarchy() {
		List<Employee> employees = Arrays.asList(new Employee("Alan", 100, 150),
				new Employee("Martin", 220, 100),
				new Employee("Jamie", 150, null),
				new Employee("Alex", 275, 100),
				new Employee("Steve", 400, 150),
				new Employee("David", 190, 400)
		);
		given(this.employeeRepo.findAll()).willReturn(employees);
		List<EmployeeDTO> employeeDTOS = employeeService.getHierarchy();

		assertEquals(1, employeeDTOS.size());
		assertEquals("Jamie", employeeDTOS.get(0).getSubordinates().get(0).getEmployeeName());
	}

	//Employee without manager
	@Test
	public void testGetHierarchyNoManager() {
		given(this.employeeRepo.findAll()).willReturn(Arrays.asList(new Employee("Alan", 100, 150),
				new Employee("Martin", 220, 100),
				new Employee("Jamie", 150, null), //no manager
				new Employee("Alex", 275, 100),
				new Employee("Steve", 400, null), //no manager
				new Employee("David", 190, 400)
		));
		List<EmployeeDTO> employeeDTOS = employeeService.getHierarchy();

		assertEquals(1, employeeDTOS.size());
		assertEquals("Steve", employeeDTOS.get(0).getSubordinates().get(1).getEmployeeName());
	}

	//Employee with invalid manager id
	@Test
	public void testGetHierarchyInvalidManagerId() {
		given(this.employeeRepo.findAll()).willReturn(Arrays.asList(new Employee("Alan", 100, 150),
				new Employee("Martin", 220, 100),
				new Employee("Jamie", 150, null),
				new Employee("Alex", 275, 100),
				new Employee("Steve", 400, 150),
				new Employee("David", 190, 120) // manager id invalid
		));

		List<EmployeeDTO> employeeDTOS = employeeService.getHierarchy();

		assertEquals(2, employeeDTOS.size());
		assertEquals("David", employeeDTOS.get(1).getSubordinates().get(0).getEmployeeName());
	}
}
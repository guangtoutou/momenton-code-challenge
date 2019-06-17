package momenton.codechallenge.repository;

import momenton.codechallenge.model.Employee;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends Repository<Employee, Integer> {

	@Transactional(readOnly = true)
	List<Employee> findAll();
}

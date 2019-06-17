package momenton.codechallenge;

import momenton.codechallenge.model.EmployeeDTO;
import momenton.codechallenge.service.EmployeeService;
import momenton.codechallenge.util.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CodechallengeApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(CodechallengeApplication.class, args);
	}

	@Override
	public void run(String... args) {
		List<EmployeeDTO> employeeDTOs = employeeService.getHierarchy();
		employeeDTOs.forEach(SystemUtil::print);
	}
}

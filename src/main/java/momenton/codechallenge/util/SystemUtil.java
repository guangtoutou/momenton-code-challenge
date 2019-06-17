package momenton.codechallenge.util;

import momenton.codechallenge.model.EmployeeDTO;

public class SystemUtil {

	public static void print(EmployeeDTO employeeDTO) {
		print(employeeDTO, "");
	}

	private static void print(EmployeeDTO employeeDTO, String indentation) {
		employeeDTO.getSubordinates().stream().forEach((subordinate) -> {
			System.out.println(indentation + subordinate.getEmployeeName());
			print(subordinate, indentation + "          ");
		});
	}
}

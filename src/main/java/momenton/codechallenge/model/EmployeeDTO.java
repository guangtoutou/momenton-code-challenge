package momenton.codechallenge.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDTO {
	private Integer employeeId;
	private String employeeName;
	private Integer managerId;
	private List<EmployeeDTO> subordinates;

	public EmployeeDTO() {
		this.subordinates = new ArrayList<EmployeeDTO>();
	}


	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public List<EmployeeDTO> getSubordinates() {
		return subordinates;
	}

	public void addSubordinate(EmployeeDTO employeeDTO) {
		this.subordinates.add(employeeDTO);
	}

}

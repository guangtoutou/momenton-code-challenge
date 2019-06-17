package momenton.codechallenge.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "employee_name")
	private String employeeName;

	@Column(name = "manager_id")
	private Integer managerId;

	public Employee(){

	}

	public Employee (String employeeName, Integer id, Integer managerId) {
		this.id = id;
		this.employeeName = employeeName;
		this.managerId = managerId;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public Integer getId() {
		return this.id;
	}

	public Integer getManagerId() {
		return this.managerId;
	}

}

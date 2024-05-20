package entity;

public class Employee {
    private int employee_id;
    private String first_name;
    private String last_name;
    private String date_of_birth;
    private String hire_date;
    private int department_id;
    private int position_id;
    private String department_name;
    private String position_name;
    private Double salary_amount;
    
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employee_id, String first_name, String last_name, String date_of_birth, String hire_date,
			int department_id, int position_id, String department_name, String position_name, Double salary_amount) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.date_of_birth = date_of_birth;
		this.hire_date = hire_date;
		this.department_id = department_id;
		this.position_id = position_id;
		this.department_name = department_name;
		this.position_name = position_name;
		this.salary_amount = salary_amount;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public int getPosition_id() {
		return position_id;
	}

	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

	public Double getSalary_amount() {
		return salary_amount;
	}

	public void setSalary_amount(Double salary_amount) {
		this.salary_amount = salary_amount;
	}
	
}

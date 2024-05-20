package entity;

public class Salary {
	private int salary_id;
    private int employee_id;
    private Double salary_amount;
    private String start_date;
	public Salary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Salary(int salary_id, int employee_id, Double salary_amount, String start_date) {
		super();
		this.salary_id = salary_id;
		this.employee_id = employee_id;
		this.salary_amount = salary_amount;
		this.start_date = start_date;
	}
	public int getSalary_id() {
		return salary_id;
	}
	public void setSalary_id(int salary_id) {
		this.salary_id = salary_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public Double getSalary_amount() {
		return salary_amount;
	}
	public void setSalary_amount(Double salary_amount) {
		this.salary_amount = salary_amount;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
    
    
    
}

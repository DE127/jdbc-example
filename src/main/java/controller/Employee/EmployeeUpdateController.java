package controller.Employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IEmployeeDAO;
import dao.ImplEmployeeDAO;
import entity.Employee;

/**
 * Servlet implementation class EmployeeUpdateController
 */
@WebServlet("/EmployeeUpdateController")
public class EmployeeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get employee id from request
		String employeeId = request.getParameter("id-update");
		int id = Integer.parseInt(employeeId);

		// Get employee from the database
		IEmployeeDAO empDAO = new ImplEmployeeDAO();

		// Check if the employee exists
		if (empDAO.getEmployeeById(id) != null && employeeId != null && !employeeId.isEmpty()) {
			Employee emp = empDAO.getEmployeeById(id);
			request.setAttribute("emp", emp);
			request.getRequestDispatcher("employee-update.jsp").forward(request, response);
		} else {
			response.sendRedirect("employee-list");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// Get data from request
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
	    String date_of_birth = request.getParameter("date_of_birth");
	    String hire_date = request.getParameter("hire_date");
	    int department_id = Integer.parseInt(request.getParameter("department_id"));
	    int position_id = Integer.parseInt(request.getParameter("position_id"));
	    Double salary_amount = Double.parseDouble(request.getParameter("salary_amount"));
	    
	    Employee emp = new Employee(employee_id, first_name, last_name, date_of_birth, hire_date, department_id, position_id, salary_amount);
	    
	    IEmployeeDAO empDAO = new ImplEmployeeDAO();
	    boolean result = empDAO.updateEmployee(emp);
	    
	    request.setAttribute("status", result);
	    request.getRequestDispatcher("employee-list.jsp").forward(request, response);
	}

}

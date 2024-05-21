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
 * Servlet implementation class EmployeeDetailController
 */
@WebServlet("/EmployeeDetailController")
public class EmployeeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get employee id from request
		String employeeId = request.getParameter("id-detail");
		int id = Integer.parseInt(employeeId);
		
		// Get employee from the database
		IEmployeeDAO empDAO = new ImplEmployeeDAO();
		
		// Check if the employee exists
		if (empDAO.getEmployeeById(id) != null && employeeId != null && !employeeId.isEmpty()) {
			Employee emp = empDAO.getEmployeeById(id);
			request.setAttribute("emp", emp);
			request.getRequestDispatcher("employee-detail.jsp").forward(request, response);
		} else {
			response.sendRedirect("employee-list");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

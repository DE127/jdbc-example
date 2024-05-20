package controller.Employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IEmployeeDAO;
import dao.ImplEmployeeDAO;

/**
 * Servlet implementation class EmployeeDeleteController
 */
@WebServlet("/EmployeeDeleteController")
public class EmployeeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeId = request.getParameter("id-delete");
		int id = Integer.parseInt(employeeId);
		
		// Delete employee from the database
		IEmployeeDAO empDAO = new ImplEmployeeDAO();
		boolean result = empDAO.deleteEmployee(id);
		
		if (result) {
			response.sendRedirect("employee-list.jsp");
		} else {
			response.getWriter().append("Error: Cannot delete employee with id = " + id);
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

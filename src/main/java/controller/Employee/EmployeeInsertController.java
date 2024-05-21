package controller.Employee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IDepartmentDAO;
import dao.IEmployeeDAO;
import dao.IPositionDAO;
import dao.ImplDepartmentDAO;
import dao.ImplEmployeeDAO;
import dao.ImplPositionDAO;
import entity.Department;
import entity.Employee;
import entity.Position;
import java.util.List;
/**
 * Servlet implementation class EmployeeInsertController
 */
@WebServlet("/employee-add")
public class EmployeeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		request.setAttribute("title", "Add Employee");

		// Mở kết nối tới csdl >>> load data
		IPositionDAO pDAO = new ImplPositionDAO();
		List<Position> lstP = pDAO.select();
		request.setAttribute("lstP", lstP);
		
		
		 IDepartmentDAO dDAO = new ImplDepartmentDAO(); 
		 List<Department> lstD = dDAO.select();
		 request.setAttribute("lstD", lstD);
		 

		request.getRequestDispatcher("employee-add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// TODO Auto-generated method stub
		
		// Get data from form
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
	    String date_of_birth = request.getParameter("date_of_birth");
	    String hire_date = request.getParameter("hire_date");
	    int department_id = Integer.parseInt(request.getParameter("department_id"));
	    int position_id = Integer.parseInt(request.getParameter("position_id"));
	    Double salary_amount = Double.parseDouble(request.getParameter("salary_amount"));
		
	    Employee emp = new Employee(first_name, last_name, date_of_birth, hire_date, department_id, position_id, salary_amount);
	    
	    IEmployeeDAO empDAO = new ImplEmployeeDAO();
	    boolean result = empDAO.addEmployee(emp);
	    
	    request.setAttribute("status", result);
	    request.getRequestDispatcher("employee-list.jsp").forward(request, response);
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

}

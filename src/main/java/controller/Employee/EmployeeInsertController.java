package controller.Employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IDepartmentDAO;
import dao.IPositionDAO;
import dao.ImplDepartmentDAO;
import dao.ImplPositionDAO;
import entity.Department;
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller.Product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IProductDAO;
import dao.ImplProductDAO;
import entity.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/product-list")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletResponse response;
	private ServletResponse request;
	
	@Override
	public void init() throws ServletException {
		response = null;
		response.setContentType("text/html;charset=UTF-8");
		request = null;
		request.setCharacterEncoding("UTF-8");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Hien thi danh sach san pham
		response.getWriter().append("Product list page");
		
		IProductDAO prdDAO = (IProductDAO) new ImplProductDAO();
		List<Product> products = prdDAO.getAllProducts();
		
		// Luu danh sach san pham vao request
		request.setAttribute("products", products);
		
		// Goi den trang danh sach san pham
		request.getRequestDispatcher("product-list.jsp").forward(request, response);
	}
	
	


}

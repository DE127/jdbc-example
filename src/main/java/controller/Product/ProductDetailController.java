package controller.Product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IProductDAO;
import dao.ImplProductDAO;
import entity.Product;

/**
 * Servlet implementation class ProductDetailController
 */
@WebServlet("/ProductDetailController")
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String StrID = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// product detail
		StrID = request.getParameter("id");
		
		// check if id is not null
		if (StrID != null && !StrID.isEmpty()) {
			// convert id to integer
			int id = Integer.parseInt(StrID);

			// get product by id
			IProductDAO productDAO = (IProductDAO) new ImplProductDAO();
			Product product = productDAO.getProductById(id);

			// set product to request
			request.setAttribute("product", product);

			// forward to product detail page
			request.getRequestDispatcher("product-detail.jsp").forward(request, response);
		} else {
			// redirect to product list page
			response.sendRedirect("product-list");
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

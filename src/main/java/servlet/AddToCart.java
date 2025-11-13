package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.ProductDAO;
import model.Cart;
import model.Product;

@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		商品IDと数量を受け取る
	    int productId = Integer.parseInt(request.getParameter("productId"));
	    int quantity = Integer.parseInt(request.getParameter("quantity"));

//	    セッションからカートを取得（なければ新規作成）
	    HttpSession session = request.getSession();
	    Cart cart = (Cart) session.getAttribute("cart");
	    if (cart == null) {
	      cart = new Cart();
	    }

//	    商品情報を取得してカートに追加
	    ProductDAO dao = new ProductDAO();
	    Product product = dao.findById(productId);
	    cart.addItem(product, quantity);

//	    セッションに保存してカート画面へリダイレクト
	    session.setAttribute("cart", cart);
	    response.sendRedirect(request.getContextPath() + "/CartView");

	}

}

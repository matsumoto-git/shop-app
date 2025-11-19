package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp");
		 dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User(0, name, email, password, false);
		UserDAO dao = new UserDAO();
		
//		登録前に重複がないかチェック
		if (dao.existsByEmail(email)) {
			request.setAttribute("error", "このメールアドレスは既に登録されています");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		boolean success = dao.insert(user);	
		
//		登録すると登録完了画面へ
		if (success) {
			request.setAttribute("userName", name);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerComplete.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/userRegister.jsp?error=1");
		}
//		登録するとメイン画面へ
////		if (success) {
//////			セッションにログインユーザーとして保存
////			HttpSession session = request.getSession();
////			session.setAttribute("loginUser", user);
////			
//////			メイン画面にリダイレクト
////			response.sendRedirect(request.getContextPath() + "/main");
//		}
	}

}

package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   request.setCharacterEncoding("UTF-8");
	       
		   String numberStr=request.getParameter("number");
		   int number=Integer.parseInt(numberStr);
	       String user= request.getParameter("use");
	       
	       String use=user.equals("0") ? "使用可":"使用不可";
	      
//	    		Dto InsKey = new Dto(number,use);
//	    		
//	    		int result = Dao.register(Inskey);
	    		
	    		
//	    		if(result == 1) {
//	    			String view = "WEB-INF/view/Isuccess.jsp";
//	    			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
//	    			dispatcher.forward(request, response);
//	    		} else {
//	    			String view = "WEB-INF/view/Ifail.jsp";
//	    			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
//	    			dispatcher.forward(request, response);
//	    		}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

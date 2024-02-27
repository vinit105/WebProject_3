

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class MainSerlvet
 */
public class MainSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String operation = request.getParameter("operation");
		 PrintWriter out = response.getWriter();
		 if(operation.equals("enterData")) {
			 
			RequestDispatcher rd = request.getRequestDispatcher("insert.html");
        	rd.forward(request, response);
			 
			 //response.sendRedirect("insert.html");
			
		 }
		 else if(operation.equals("deleteData")){
			 RequestDispatcher rd2 = request.getRequestDispatcher("delete.html");
			 rd2.forward(request, response);
			 
		 }
		 else if(operation.equals("listData")) {
			 RequestDispatcher rd3 = request.getRequestDispatcher("ListServlet");
			 rd3.forward(request, response);
			 
		 }
		 else { //Select data
			 RequestDispatcher rd4 = request.getRequestDispatcher("select.html");
			 rd4.forward(request, response);
		 }
		
	}

}

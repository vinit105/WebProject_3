

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int result =0;
		String StringdeleteId= request.getParameter("deleteId");
		int deleteId = Integer.parseInt(StringdeleteId);
		
		try {
			result = DBHandler.deleteQuery(deleteId);
		} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		    if(result ==1)
	        {

	    	    out.println("Data Deleted Successfully");	
	        }
	        else {
	        	out.println("Data Not Deleted");
	        }
	}

}

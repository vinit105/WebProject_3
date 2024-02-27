

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class InsertSerlvet
 */
public class InsertSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int result=0;
		PrintWriter  out = response.getWriter();
		String StringidStudent = request.getParameter("idStudent");
		int idStudent = Integer.parseInt(StringidStudent);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String dateOfBirth = request.getParameter("dateOfBirth");
		
		String branch = request.getParameter("branch");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String StringadmissionYear = request.getParameter("admissionYear");
		int admissionYear = Integer.parseInt(StringadmissionYear);
		
		String StringmobileNumber = request.getParameter("mobileNumber");
		long  mobileNumber = Long.parseLong(StringmobileNumber);
		
		try {
		 result = DBHandler.insertQuery(idStudent, firstName, lastName, dateOfBirth, branch, admissionYear, mobileNumber, email, city);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	    if(result ==1)
        {

    	   response.sendRedirect("ListServlet");	
        }
        else {
        	out.println("Data Not Inserted");
        }
	
	}

}

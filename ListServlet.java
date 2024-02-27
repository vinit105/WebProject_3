

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ResultSet rs = DBHandler.listTableQuery();
			PrintWriter out = response.getWriter();
			while (rs.next()) {
				 out.print(rs.getInt(1)+"\t"+ rs.getString(2)+"\t"+ rs.getString(3)+"\t"+ rs.getString(4)+"\t"+ rs.getString(5)+"\t"+  rs.getString(6)+"\t"+ rs.getString(7)+"\t"+ rs.getString(8)+"\t"+ rs.getString(9));
				out.print("\n");
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

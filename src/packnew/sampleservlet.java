package packnew;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sampleservlet
 */
@WebServlet("/sampleservlet")
public class sampleservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sampleservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f1=request.getParameter("eid");
		String f2=request.getParameter("dept");
		String f3=request.getParameter("epf");
		String f4=request.getParameter("name");
		String f5=request.getParameter("father");
		String f6=request.getParameter("pan");
		String f7=request.getParameter("bank_acc");
		String f8=request.getParameter("dept_id");
		String f9=request.getParameter("dob");
		String f10=request.getParameter("doj");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement pstmt=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1,f1);
			pstmt.setString(2,f2);
			pstmt.setString(3,f3);
			pstmt.setString(4,f4);
			pstmt.setString(5,f5);
			pstmt.setString(6,f6);
			pstmt.setString(7,f7);
			pstmt.setString(8,f8);
			pstmt.setString(9,f9);
			pstmt.setString(10,f10);
			int i=pstmt.executeUpdate();
			if(i==1)
			{
				System.out.println("row inserted successfully");
			}
			else
			{
				System.out.println("row not inserted");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

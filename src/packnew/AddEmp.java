package packnew;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmp extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,NumberFormatException
	{
		 ///response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	//	SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		
		
		String f1=request.getParameter("f1");
		String f2=request.getParameter("f2");
		String f3=request.getParameter("f3");
		String f4=request.getParameter("f4");
		String f5=request.getParameter("f5");
		String f6=request.getParameter("f6");
		String f7=request.getParameter("f7");
		String f8=request.getParameter("f8");
		String f9=request.getParameter("f9");
		String f10=request.getParameter("f10");
		
		PreparedStatement ps=null;
		ServletConfig config=getServletConfig();
		 response.setContentType("text/jsp");
	//	String drv=config.getInitParameter("driver");
		String url=config.getInitParameter("url");
	//	String ins=application.getInitParameter("insert");
				try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
						//	ps=con.prepareStatement();						
							ps=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?,?)");
							//ps=con.prepareStatement("select *from employee where eid=101");
							ps.setString(1,f1);
							ps.setString(2,f2);
							ps.setString(3,f3);	
							ps.setString(4,f4);
							ps.setString(5,f5);
							ps.setString(6,f6);
							ps.setString(7,f7);
							ps.setString(8,f8);
							ps.setString(9,f9);
							ps.setString(10,f10);
							
							
							
							
							int i=ps.executeUpdate();
							if(i!=0)
							{
								pw.println("Table updated");
							//	response.sendRedirect("ins.jsp");
							}
							else
							{
								pw.println("INVALID USERNAME OR PASSWORD");
							}
							con.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		
	}

}



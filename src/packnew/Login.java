package packnew;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter pw=response.getWriter();
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		PreparedStatement ps;
		ServletConfig config=getServletConfig();
	//	ServletContext application=config.getServletContext();
	
		String drv=config.getInitParameter("driver");
		String url=config.getInitParameter("url");
		try {
						Class.forName(drv);
							Connection con=DriverManager.getConnection(url,"system","system");
						//	ps=con.prepareStatement(ins);						
							ps=con.prepareStatement("select *from admin where username=? and password=?");
							
							ps.setString(1,uname);
							ps.setString(2,pwd);
							ResultSet rs=ps.executeQuery();
							if(rs.next())
							{
								//pw.println("valid");
								response.sendRedirect("ins.jsp");
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


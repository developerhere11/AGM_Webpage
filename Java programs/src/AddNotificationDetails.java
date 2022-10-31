import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddNotificationDetails extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
        
		ServletContext sc=getServletContext();
		String driver=sc.getInitParameter("driver");
		String url=sc.getInitParameter("url");
		String uname=sc.getInitParameter("user");
		String pwd=sc.getInitParameter("dbpassword");
		
		System.out.println(".......10........");
				try
				{
			Class.forName(driver);
			Connection  con=DriverManager.getConnection(url,uname,pwd);
			System.out.println(".......11........");
			PreparedStatement pstmt=con.prepareStatement("insert into notification_details(n_name,n_date)values(?,?)");
			pstmt.setString(1,request.getParameter("notification"));
			pstmt.setString(2,request.getParameter("ndate"));
			int n=pstmt.executeUpdate();
			System.out.println(".......13........");
			if(n==1)
			{
				response.sendRedirect("./AddNotificationDetails.jsp?msg=Successfully Added");
				}
				
			System.out.println(".......18........");
			}catch(Exception e)
			{
				e.printStackTrace();
		}
			
			 
	}
}
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddTimeTable extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
        
		ServletContext sc=getServletContext();
		String driver=sc.getInitParameter("driver");
		String url=sc.getInitParameter("url");
		String uname=sc.getInitParameter("user");
		String pwd=sc.getInitParameter("dbpassword");
		String deptname=request.getParameter("dname");
        String loc=request.getParameter("location");
		System.out.println(".......10........");
				try
				{
			Class.forName(driver);
			Connection  con=DriverManager.getConnection(url,uname,pwd);
			System.out.println(".......11........");
			PreparedStatement pstmt=con.prepareStatement("insert into examination_details values(?,?)");
			pstmt.setString(1,request.getParameter("examid"));
			pstmt.setString(2,request.getParameter("time"));
			int n=pstmt.executeUpdate();
			pstmt.setString(1,request.getParameter("examid"));
			for(int i=1;i<=6;i++)
			{	
			  pstmt=con.prepareStatement("insert into time_details values(?,?,?,?)");
			  pstmt.setString(1,request.getParameter("examid"));
			  pstmt.setString(2,request.getParameter("s"+i));
			  pstmt.setString(3,request.getParameter("d"+i));
			  pstmt.setInt(4,i);
			  n=pstmt.executeUpdate();
			}  
			System.out.println(".......13........");
			if(n==1)
			{
				response.sendRedirect("./AddTimeTable.jsp?msg=Successfully Added");
				}
				
			System.out.println(".......18........");
			}catch(Exception e)
			{
				e.printStackTrace();
		}
			
			 
	}
}
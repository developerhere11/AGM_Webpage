import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateStudentRemarks extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
    	String deptname=request.getParameter("deptname");
    	
    	String loc=request.getParameter("location");
        String deptno=request.getParameter("deptno");
    	Connection con;
    	PreparedStatement pstmt;
    	ServletContext sc=getServletContext();
		String driver=sc.getInitParameter("driver");
    	String url=sc.getInitParameter("url");
    	String dbpassword=sc.getInitParameter("dbpassword");
    	String user=sc.getInitParameter("user");
	    response.setContentType("text/html");
		
		try
		{
			System.out.println(".......1........");
    	  Class.forName(driver);
    	  
    	  con=DriverManager.getConnection(url,user,dbpassword);
    	  System.out.println(".......2........");
    	  System.out.println(deptno);
    	  pstmt=con.prepareStatement("update student_remarks set remarks=?,date=? where remark_id=?");
    	  System.out.println(".......3........");
    	  
    	  
    	  
    	  pstmt.setString(1,request.getParameter("remark"));
    	  pstmt.setString(2,request.getParameter("date"));
    	  pstmt.setString(3,request.getParameter("rid"));
    	  
    	  
    	  
    	 
   	  	  pstmt.execute();
   	  	System.out.println(".......4........");
    	  response.sendRedirect("UpdateStudentRemarks.jsp");
    	  System.out.println(".......5........");
		}
		catch(Exception e)
		{System.out.println(".......6........");
			e.printStackTrace();
		}
		
    }
}
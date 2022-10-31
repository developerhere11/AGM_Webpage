import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EditTimeTable extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
    	String deptname=request.getParameter("deptname");
    	
    	String loc=request.getParameter("location");
        String deptno=request.getParameter("deptno");
    	Connection con;
    	PreparedStatement pstmt,pstmt1;
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
    	  pstmt=con.prepareStatement("update examination_details set time=? where examid=?");
    	 
    	  
    	  
    	  
    	  pstmt.setString(1,request.getParameter("time"));
    	  pstmt.setString(2,request.getParameter("search"));
    	  pstmt.executeUpdate();
    	  System.out.println(".......3........");
    	  for(int i=1;i<=6;i++)
    	  {  
    	    pstmt1=con.prepareStatement("update time_details set subject=?,date=? where examid=? and incr=?");
    	    pstmt1.setString(1,request.getParameter("s"+i));
    	    pstmt1.setString(2,request.getParameter("d"+i));
    	    pstmt1.setString(3,request.getParameter("search"));
    	    pstmt1.setInt(4,i);
    	    pstmt1.executeUpdate();
    	  }  
    	  
    	  
    	  
    	 
   	  	  
   	  	System.out.println(".......4........");
    	  response.sendRedirect("EditTimeTable.jsp");
    	  System.out.println(".......5........");
		}
		catch(Exception e)
		{System.out.println(".......6........");
			e.printStackTrace();
		}
		
    }
}
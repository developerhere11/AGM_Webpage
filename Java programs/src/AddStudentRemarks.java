import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddStudentRemarks extends HttpServlet
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
        HttpSession hs=request.getSession();
		System.out.println(".......10........");
				try
				{
			Class.forName(driver);
			Connection  con=DriverManager.getConnection(url,uname,pwd);
			System.out.println(".......11........");
			PreparedStatement pstmt=con.prepareStatement("insert into student_remarks(student_id,remarks,date,teacher_id) values(?,?,?,?)");
			pstmt.setString(1,request.getParameter("sid"));
			pstmt.setString(2,request.getParameter("remarks"));
			pstmt.setString(3,request.getParameter("date"));
			pstmt.setString(4,(String)hs.getAttribute("userid"));
			
			int n=pstmt.executeUpdate();
			
			System.out.println(".......13........");
			if(n>0)
			{
				response.sendRedirect("./AddStudentRemarks.jsp?msg=Successfully Added");
				}
				
			System.out.println(".......18........");
			}catch(Exception e)
			{
				e.printStackTrace();
		    }
			
			 
	}
}
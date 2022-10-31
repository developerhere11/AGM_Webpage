import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddFacultyDetails extends HttpServlet
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
			PreparedStatement pstmt=con.prepareStatement("insert into faculty_details(faculty_id,faculty_name,subject_dealing,joining_date,mailid)values(?,?,?,?,?)");
			pstmt.setString(1,request.getParameter("tid"));
			pstmt.setString(2,request.getParameter("tname"));
			pstmt.setString(3,request.getParameter("subjectdealing"));
			pstmt.setString(4,request.getParameter("joiningdate"));
			pstmt.setString(5,request.getParameter("mailid"));
			int n=pstmt.executeUpdate();
			pstmt=con.prepareStatement("insert into login_table values(?,?,?)");
			pstmt.setString(1,request.getParameter("tid"));
			pstmt.setString(2,"teacher");
			pstmt.setString(3,"teacher");
			n=pstmt.executeUpdate();
			System.out.println(".......13........");
			if(n>0)
			{
				response.sendRedirect("./AddFacaultytDetails.jsp?msg=Successfully Added");
				}
				
			System.out.println(".......18........");
			}catch(Exception e)
			{
				e.printStackTrace();
		}
			
			 
	}
}
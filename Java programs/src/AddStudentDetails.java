import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddStudentDetails extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
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
			PreparedStatement pstmt=con.prepareStatement("insert into student_details(Student_id,student_name,currentstandard,currentdivision,parentemailid,joiningdate,reportcardno)values(?,?,?,?,?,?,?)");
			pstmt.setString(1,request.getParameter("sid"));
			pstmt.setString(2,request.getParameter("sname"));
			pstmt.setString(3,request.getParameter("currentstandard"));
			pstmt.setString(4,request.getParameter("currentdivision"));
			pstmt.setString(5,request.getParameter("mailid"));
			pstmt.setString(6,request.getParameter("joiningdate"));
			pstmt.setString(7,request.getParameter("cardno"));
		
		
			int n=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("insert into login_table values(?,?,?)");
			pstmt.setString(1,request.getParameter("sid"));
			pstmt.setString(2,"student");
			pstmt.setString(3,"student");
			n=pstmt.executeUpdate();
			System.out.println(".......13........");
			if(n>0)
			{
				response.sendRedirect("./AddStudentDetails.jsp?msg=Successfully Added");
				}
				
			System.out.println(".......18........");
			}catch(Exception e)
			{
				e.printStackTrace();
		}
			
			 
	}
}
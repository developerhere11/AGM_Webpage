import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddReportCardDetails extends HttpServlet
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
		System.out.println(".......99 hai........");
				try
				{
			Class.forName(driver);
			Connection  con=DriverManager.getConnection(url,uname,pwd);
			System.out.println(".......11........"+request.getParameter("sid"));
			System.out.println(".......12........"+request.getParameter("ename"));
			int count=0;
			PreparedStatement pstmt=con.prepareStatement("select count(*) from studentreport1 where student_id=? and test_id=?");
			pstmt.setString(1,request.getParameter("sid"));
			pstmt.setString(2,request.getParameter("ename"));
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				count=rs.getInt(1);
			}
			System.out.println("--count--"+count);
			String subname=request.getParameter("subjectname");
			int n=0;
			if(count==0)
			{	
				System.out.println("--executed1--");
				pstmt=con.prepareStatement("insert into studentreport1(student_id,test_id,"+subname+",actualmarks)values(?,?,?,?)");
				pstmt.setString(1,request.getParameter("sid"));
				pstmt.setString(2,request.getParameter("ename"));
			//pstmt.setString(3,request.getParameter("subjectname"));
				pstmt.setString(3,request.getParameter("totalmarks"));
				pstmt.setString(4,request.getParameter("amarks"));
				n=pstmt.executeUpdate();
			}
			else
			{
				System.out.println("--executed2--");
				pstmt=con.prepareStatement("update studentreport1 set "+subname+"=? where student_id=? and test_id=?");
				pstmt.setString(1,request.getParameter("totalmarks"));
				pstmt.setString(2,request.getParameter("sid"));
				pstmt.setString(3,request.getParameter("ename"));
			//pstmt.setString(3,request.getParameter("subjectname"));
				
				
				n=pstmt.executeUpdate();
				
			}
			
			if(n>0)
			{
				response.sendRedirect("./AddReportCardDetails.jsp?msg=Successfully Added");
				}
				
			System.out.println(".......18........");
			}catch(Exception e)
			{
				e.printStackTrace();
		}
			
			 
	}
}
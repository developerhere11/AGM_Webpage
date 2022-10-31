import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Login extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
        
		ServletContext sc=getServletContext();
		String driver=sc.getInitParameter("driver");
		String url=sc.getInitParameter("url");
		String uname=sc.getInitParameter("user");
		String pwd=sc.getInitParameter("dbpassword");
		String userid=request.getParameter("userid");
		
		String password=request.getParameter("password");
		System.out.println(".......10........");
			try
			{
			Class.forName(driver);
			 Connection  con=DriverManager.getConnection(url,uname,pwd);
			  System.out.println(".......11........");
			  PreparedStatement pstmt,pstmt1;
				 pstmt=con.prepareStatement("select password,role from login_table where login_id=? ");
			  pstmt.setString(1,userid);
		
		ResultSet rs,rs1;
		rs=pstmt.executeQuery();
			System.out.println(".......13........");
			HttpSession hs=request.getSession();
			//int i=0;
			if(userid.equals("admin") && password.equals("12345"))
			{
				System.out.println(".......14a........");
				hs.setAttribute("userid","admin");
				hs.setAttribute("role","admin");
				response.sendRedirect("AdminHome.jsp");
				
			}
			
			
		int i=0;
		  while(rs.next())
			{
				i++;
				System.out.println(".......password........"+rs.getString("password"));
				
				if(rs.getString("password").equals(password))
					{
					 if(rs.getString(2).equals("teacher"))
					 {
				     	System.out.println("--executed--");
					    hs.setAttribute("userid",userid);
					    hs.setAttribute("role", "teacher");
					    pstmt1=con.prepareStatement("select faculty_name from faculty_details where faculty_id=?");
					  
					    pstmt1.setString(1, userid);
					  rs1=pstmt1.executeQuery();
					  while(rs1.next())
					  {
						  hs.setAttribute("uname", rs1.getString(1));
					  }
					    System.out.println("--executed1--");
						response.sendRedirect("TeacherHome.jsp");
						System.out.println("--executed2--");
					 }	
					 
					 else 
						 if(rs.getString(2).equals("student"))
						 {
					     	System.out.println("--executed--");
						    hs.setAttribute("userid",userid);
						    hs.setAttribute("role", "student");
						    pstmt1=con.prepareStatement("select student_name from student_details where student_id=?");
						  
						    pstmt1.setString(1,userid);
							 rs1=pstmt1.executeQuery();
							  while(rs1.next())
							  {
								  System.out.println("uname"+rs1.getString(1));
								  hs.setAttribute("uname", rs1.getString(1));
							  }
						    System.out.println("--executed1--");
							response.sendRedirect("StudentHome.jsp");
							System.out.println("--executed2--");
						 }	
					
			    }
				else
				{
					response.sendRedirect("./Home.jsp?msg=Check your password.");	
				}
				
			
				
						
				}
					
				
			
			//while
		
		
			
			/*if(i==0)
			{
				System.out.println(".......17........");
				response.sendRedirect("./Home.jsp?msg=Userid does not exist");
			}
			*/
			
			}catch(Exception e)
			{
				e.printStackTrace();
				}
			
		
	}
}
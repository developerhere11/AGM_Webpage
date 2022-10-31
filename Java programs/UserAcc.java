import java.util.*;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
public class UserAcc{
	Scanner s = new Scanner(System.in);
	String filename = "D:\\account.txt";
	public UserAcc(){
		try{
			System.out.println("\nM A I N M E N U\n ");
			System.out.println("1. Create user Account");
			System.out.println("2. Login user Account");
			System.out.println("Enter Choice: ");
			String choice = s.nextLine();
			if(choice.equals("1")){
				createacc();
			}else if(choice.equals("2")){
				login();
				
			}else{
			System.out.println("Invalid Choice");
			new UserAcc();
			}
		}catch(Exception ex){
			System.out.print(ex.getMessage());
		}
	} 

	void login(){
	    try{
        	Path path = Paths.get(filename.toString());
        	InputStream input = Files.newInputStream(path);
        	BufferedReader reader = new BufferedReader (new InputStreamReader(input));
        	System.out.println("\nL O G I N \n ");
        	System.out.println("Enter username : ");
        	String username = s.nextLine();
        	System.out.println("Enter password : ");
        	String password = s.nextLine();
        	String _temp = null;
        	String _user;
        	String _pass;
        	boolean found = false;
        	while((_temp=reader.readLine()) != null) {
            		String[] account = _temp.split(",");
            		_user = account[0];
            		_pass = account[1];
            		if(_user.equals(username) && _pass.equals(password)){
                	found = true;
            	}
        	}
        	if (found==true){
            		System.out.println("Access granted!");
        	}
		else{
            		System.out.println("Access denied! Invalid username or password!");
        	}
        	System.out.println("Press any key to continue....");
        	String proc = s.nextLine();
        	new UserAcc();
    	}
	catch(Exception ex){
        	System.out.println(ex.getMessage());
    	}
}
	void createacc(){
		try{
		Path path = Paths.get(filename.toString());
		OutputStream output = new BufferedOutputStream(Files.newOutputStream(path, APPEND));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
		System.out.println("\n C R E A T E  A C C O U N T\n");
		System.out.print("Enter username: ");
		String username = s.nextLine();
		System.out.print("Enter password: ");
		String password = s.nextLine();

		writer.write(username + "," + password);
		writer.newLine();
		System.out.println("Account has been successfully saved!!");
		writer.close();
		output.close();
		new UserAcc();
		}catch (Exception ex){
			System.out.print(ex.getMessage());
		}
	}

	public static void main(String args[]){
		new UserAcc();
	}
}

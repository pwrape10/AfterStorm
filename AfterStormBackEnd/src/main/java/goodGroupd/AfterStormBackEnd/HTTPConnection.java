package goodGroupd.AfterStormBackEnd;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HTTPConnection extends HttpServlet{

	EntryInformation entry = new EntryInformation();
	
protected void doGet( HttpServletRequest request,HttpServletResponse response) 
		throws ServletException, IOException {

	String Phone =request.getParameter("phone");
	
	//findMethod(Phone);
}

protected void doPost( HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException {

	PrintWriter writer = response.getWriter();

	writer.write("<html><body>GET/POST response</body></html>");
	/*
 	String primaryName = request.getParameter("name");	
	String address = request.getParameter("address");	
	String city = request.getParameter("city");	
	String zipCode = request.getParameter("zip");	
	String phoneNumber = request.getParameter("number");	
	String email = request.getParameter("email");	
	String groupSize = request.getParameter("group");	
	boolean critical;	
	String comments = request.getParameter("comments");
	*/
	
	//entry.setPrimaryName(primaryName);
	
	}

public void test(){
	
	}
}

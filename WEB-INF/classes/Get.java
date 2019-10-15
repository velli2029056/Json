import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.regex.*;
public class Get extends HttpServlet {
 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
	  String urlregex="^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$";
	  Pattern urlpattern=Pattern.compile(urlregex);
	  String emailregex="^[A-Za-z0-9+_.-]+@(.+)$";
	  Pattern emailpattern=Pattern.compile(emailregex);
	  String dobregex="^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
	  Pattern dobpattern=Pattern.compile(dobregex);
	  String colorregx="#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
	  Pattern colorpattern=Pattern.compile(colorregx);
	  BufferedReader fw=new BufferedReader(new FileReader("C:\\Tomcat 9.0\\webapps\\Json\\WEB-INF\\classes\\tem.txt")); 
	  String st;
	  int i=0;
	  out.println("<html><head>");
	  out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>");
	  out.println("<script src='https://code.jquery.com/jquery-3.3.1.slim.min.js' integrity='sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo' crossorigin='anonymous'></script>");
	  out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js' integrity='sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1' crossorigin='anonymous'></script>");
	  out.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js' integrity='sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM' crossorigin='anonymous'></script>");
	  out.println("<style>");
	  out.println("body{padding:10%;width:70%;}");
	  out.println("label{color:blue;font-family:Cursive;}");
	  out.println("input[type='text']{font-family:cursive;color:blue;}");
	  out.println("input[type='dob']{font-family:cursive;color:blue;}");
	  out.println("input[type='date']{font-family:cursive;color:blue;}");
	  out.println("input[type='url']{font-family:cursive;color:blue;}");
	  out.println("input[type='number']{font-family:cursive;color:blue;}");
	  out.println("input[type='email']{font-family:cursive;color:blue;}");
	  out.println("input[type='time']{font-family:cursive;color:blue;}");
	  out.println("input[type='list']{font-family:cursive;color:blue;}");
	  out.println("h5{font-family:Bookman-old;color:Red;}");
	  out.println("button{font-family:cursive;}");
	  out.println("</style>");
	  out.println("</head><body><h5>!.....Grootan Technologies.....!</h5>");
	  out.println("<form method='POST'>");
	  Matcher matcheremail,matcherdob,matcherurl,matchercolor;
	  while((st=fw.readLine())!=null)   
	  {		  
	  st=st.replaceAll("\"|,$","");
	  if(i!=0 && st.equalsIgnoreCase("}")!=true)
		{
		    String sp[]=st.split(":");
		    int j=0;
			String kk;
			  for(String s:sp)
			  {
				  if(j==0)
				  {
					  out.println("<div class='form-group row'>");
					  out.println("<label class='col-sm-2 col-form-label'>"+s+"</label>");j++;
					  kk=s;
				  }
				  else
				  {	
						matcheremail=emailpattern.matcher(s);
						matcherdob=dobpattern.matcher(s);
						matcherurl=urlpattern.matcher(s);
						matchercolor=colorpattern.matcher(s);
						if(Pattern.matches("[a-zA-Z]{6,}",s)==true)
						{
						out.println("<div class='col-sm-10'>");
						out.println("<input type='text' class='form-control' placeholder='Enter your name'>");
						out.println("</div>");
						}
						else if(Pattern.matches("[0-9]{2,}",s)==true)
						{
						out.println("<div class='col-sm-10'>");
						out.println("<input type='number' class='form-control' placeholder='Enter your Age'>");
						out.println("</div>");
						}
						else if(Pattern.matches("[789]{1}[0-9]{9}",s)==true)
						{
						out.println("<div class='col-sm-10'>");
						out.println("<input type='tel' class='form-control' placeholder='Enter mobile no'>");	
						out.println("</div>");
						}
						else if(matcheremail.matches())
						{
						out.println("<div class='col-sm-10'>");
						out.println("<input type='email' class='form-control' placeholder='Enter your email'>");	
						out.println("</div>");
						}
						else if(matcherdob.matches())
						{
						out.println("<div class='col-sm-10'>");
						out.println("<input type='date' class='form-control' placeholder='Enter your dob'>");	
						out.println("</div>");
						}
						else if(matchercolor.matches())
						{
							out.println("<div class='col-sm-10'>");
							out.println("<input type='color'  value='#ff0000'>");	
							out.println("</div>");
						}
						else if(matcherurl.matches())
						{
						out.println("<div class='col-sm-10'>");
						out.println("<input type='url' class='form-control' placeholder='Enter website url'>");
						out.println("</div>");
						}
						else if(s.equals("male/female")==true | s.equals("male") | s.equals("female"))
						{
						out.println("<div class='col-sm-10'>");
						out.println("<input type='radio' name='gender'  value='male' checked><label>Male</label>");
						out.println("<input type='radio' name='gender' value='female' ><label>Female</label>");
						out.println("</div>");
						}
						else if(s.equals("upload"))
						{
						out.println("<div class='col-sm-10'>");
						out.println("<input type='file'>");
						out.println("</div>");	
						}
						else if(s.equals("1-10"))
						{
						out.println("<div class='col-sm-10'>");
						out.println("<input type='range' name='points' class='form-control' min='0' max='10'>");
						out.println("</div>");	
						}
						else if(s.equals("10;30PM"))
						{
						out.println("<div class='col-sm-10'>");
						out.println("<input type='time'  class='form-control'>");
						out.println("</div>");		
						}
						else
						{
						out.println("<div class='col-sm-10'>");
						out.println("<select class='form-control'>");
						s=s.replaceAll("\\[|\\]","");
						String data[]=s.split(",");
							for(String value:data)
							{
								out.println("<option>"+value.replaceAll("\"","")+"</option>");
							}
						out.println("</select>");
						out.println("</div>");
						}
					out.println("</div>");
				  }
			  }
			  out.println("</br>");
		  }	
		  else
		  {
			  i++;
		  }
	  }
	  out.println("<button type='button' class='btn btn-primary'>Submit</button>");
	  out.println("</form></body></html");
   }
}
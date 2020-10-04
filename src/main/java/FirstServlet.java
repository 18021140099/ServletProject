import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "FirstServlet")
public class FirstServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String iid=request.getParameter("itemid");
        String iname=request.getParameter("itemname");
        String uname=request.getParameter("username");
        String umail=request.getParameter("usermail");
        String ubid=request.getParameter("userbid");
        String ucheck = "false";
        if(request.getParameter("usercheck")!=null)
            ucheck="true";
        else
            ucheck="false";

        if(LoginDao.sendDetails(iid,iname,uname,umail,ubid,ucheck)){
            RequestDispatcher rd=request.getRequestDispatcher("servlet2");
            rd.forward(request,response);
        }
        else{
            out.print("Error");
            RequestDispatcher rd=request.getRequestDispatcher("index.html");
            rd.include(request,response);
        }
        out.close();
    }
}
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "AuctionServlet")
public class AuctionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String iid=request.getParameter("itemid");
        String iname=request.getParameter("itemname");
        String uname=request.getParameter("username");
        String umail=request.getParameter("usermail");
        String ubid=request.getParameter("userbid");
        String ucheck;
        if(request.getParameter("usercheck")!=null)
            ucheck="true";
        else
            ucheck="false";

        out.println("<html><head><title>Auctions</title></head><body style=\"background-color:#dee87e;\">");
        out.println("<div align=\"center\">");
        out.println("<h1>Bid Submitted</h1><br>");
        out.println("<h3>Your Bid is active now.If your bid is successful,you will be notified within 24 hours of the close of bidding</h3><br>");
        out.println("<table border=1 width=30% height=50%>");
        out.println("<tr><td align=\"center\">"+iname+"</td></tr><tr><td align=\"center\">Item ID: "
                +iid+"</td></tr><tr><td align=\"center\">User Name: "+uname+"</td></tr><tr><td align=\"center\">User Mail: "
                +umail+"</td></tr><tr><td align=\"center\">Bid: "+ubid+"</td></tr><tr><td align=\"center\">Auto Increment: "+ucheck);
        out.println("</table>");
        out.println("</div>");
        out.println("</body></html>");
    }
}
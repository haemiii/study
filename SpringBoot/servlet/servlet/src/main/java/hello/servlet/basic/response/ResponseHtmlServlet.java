package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHtmlServlet", urlPatterns = "/response-html")
public class ResponseHtmlServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Content-Type : text/html;charset=utf-8
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter write = resp.getWriter();
        write.println("<html>");
        write.println("<body>");
        write.println(" <div>안녕?</div>");
        write.println("</body>");
        write.println("</html>");
    }
}

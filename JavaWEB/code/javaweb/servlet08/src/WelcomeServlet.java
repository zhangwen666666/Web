import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "welcomeServlet", urlPatterns = {"/welcome", "/welcome01"},
        initParams = {@WebInitParam(name = "user", value = "root"), @WebInitParam(name = "password", value = "1234")})
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;UTF-8");
        PrintWriter out = response.getWriter();
        String servletName = this.getServletName();
        out.print(servletName + "<br>");
        Enumeration<String> initParameterNames = this.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String parameterName = initParameterNames.nextElement();
            String parameterValue = this.getInitParameter(parameterName);
            out.print(parameterName + "=" + parameterValue + "<br>");
        }
    }
}

import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/bugs")
public class BugsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Bug bug1 = new Bug("001", "222行出现空指针异常", false);
        Bug bug2 = new Bug("002", "333行出现类型转换异常", false);
        Bug bug3 = new Bug("003", "888行出现算数异常", false);
        List<Bug> list = new ArrayList<>();
        list.add(bug1);
        list.add(bug2);
        list.add(bug3);
        response.setContentType("text/html;charset=UTF-8");
        String jsonString = JSON.toJSONString(list);
        response.getWriter().print(jsonString);
    }
}

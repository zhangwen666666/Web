import jakarta.servlet.annotation.WebServlet;

public class ReflectAnnotation {
    public static void main(String[] args) throws Exception{
        Class<?> welcomeServletClass = Class.forName("WelcomeServlet");
        if (welcomeServletClass.isAnnotationPresent(WebServlet.class)){
            WebServlet webServletAnnotation = welcomeServletClass.getAnnotation(WebServlet.class);
            String[] values = webServletAnnotation.value();
            for (String value : values) {
                System.out.println(value);
            }
            String[] urlPatterns = webServletAnnotation.urlPatterns();
            for (String urlPattern : urlPatterns) {
                System.out.println(urlPattern);
            }
            System.out.println("**********************************************");
        }
    }
}

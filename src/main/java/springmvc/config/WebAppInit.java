package springmvc.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class WebAppInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext();
        container.register(Appconfig.class);

        DispatcherServlet servlet = new DispatcherServlet();
        ServletRegistration.Dynamic registration = servletContext.addServlet("spring", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");

    }

}

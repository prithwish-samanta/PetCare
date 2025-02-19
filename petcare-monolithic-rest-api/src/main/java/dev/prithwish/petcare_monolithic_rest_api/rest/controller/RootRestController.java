package dev.prithwish.petcare_monolithic_rest_api.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Hidden
public class RootRestController {
    @Value("#{servletContext.contextPath}")
    private String servletContextPath;

    @GetMapping("/")
    public void redirectToSwagger(HttpServletResponse response) throws IOException {
        response.sendRedirect(this.servletContextPath + "/swagger-ui/index.html");
    }
}

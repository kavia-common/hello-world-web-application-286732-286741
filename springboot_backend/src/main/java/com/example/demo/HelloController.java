package com.example.springbootbackend;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * PUBLIC_INTERFACE
 * HelloController
 *
 * Provides basic endpoints and Thymeleaf-backed views.
 * Routes:
 * - "/" -> index view
 * - "/hello" -> hello view
 * - "/docs" -> redirect to /swagger-ui.html (absolute URL preserved)
 * - "/health" -> plain OK for health checks
 * - "/api/info" -> plain string app info
 */
@Controller
@Tag(name = "Hello Controller", description = "Basic endpoints for springbootbackend")
public class HelloController {

    // PUBLIC_INTERFACE
    @GetMapping("/")
    @Operation(summary = "Home page", description = "Renders the index.html Thymeleaf template")
    public String index(Model model) {
        model.addAttribute("title", "Spring Boot + Thymeleaf");
        model.addAttribute("message", "Hello, Spring Boot! Welcome to springbootbackend");
        model.addAttribute("cta", "Explore the Hello page");
        return "index"; // resolves to src/main/resources/templates/index.html
    }

    // PUBLIC_INTERFACE
    @GetMapping("/hello")
    @Operation(summary = "Hello page", description = "Renders the hello.html Thymeleaf template with a dynamic greeting")
    public String hello(Model model) {
        model.addAttribute("greeting", "Hello from Thymeleaf!");
        model.addAttribute("info", "This page is rendered server-side using the Ocean Professional theme.");
        model.addAttribute("timestamp", java.time.ZonedDateTime.now().toString());
        return "hello"; // resolves to src/main/resources/templates/hello.html
    }

    // PUBLIC_INTERFACE
    @GetMapping("/docs")
    @Operation(summary = "API Documentation", description = "Redirects to Swagger UI preserving original scheme/host/port")
    public RedirectView docs(HttpServletRequest request) {
        String target = UriComponentsBuilder
                .fromHttpRequest(new ServletServerHttpRequest(request))
                .replacePath("/swagger-ui.html")
                .replaceQuery(null)
                .build()
                .toUriString();

        RedirectView rv = new RedirectView(target);
        rv.setHttp10Compatible(false);
        return rv;
    }

    // PUBLIC_INTERFACE
    @GetMapping("/health")
    @ResponseBody
    @Operation(summary = "Health check", description = "Returns application health status")
    public String health() {
        return "OK";
    }

    // PUBLIC_INTERFACE
    @GetMapping("/api/info")
    @ResponseBody
    @Operation(summary = "Application info", description = "Returns application information")
    public String info() {
        return "Spring Boot Application: springbootbackend";
    }
}

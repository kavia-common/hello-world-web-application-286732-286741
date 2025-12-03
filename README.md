# hello-world-web-application-286732-286741

Spring Boot backend that renders Thymeleaf views using the "Ocean Professional" theme.

- Port: 3001
- Pages:
  - `/` Home (Thymeleaf) with hero section
  - `/hello` Hello (Thymeleaf) with dynamic greeting
  - `/docs` Redirects to `/swagger-ui.html`
  - `/swagger-ui.html` Swagger UI
- Dev settings: `spring.thymeleaf.cache=false` for hot-reload of templates.

Run:
- ./gradlew bootRun
- Open http://localhost:3001/
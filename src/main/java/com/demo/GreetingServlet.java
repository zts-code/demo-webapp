package main.java.com.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/api/greeting")
public class GreetingServlet extends HttpServlet {

    private static final String[] GREETINGS = {
        "You look absolutely wonderful today!",
        "The world is a better place with you in it!",
        "Your smile could light up a whole city!",
        "You're doing an amazing job — never forget that!",
        "Every day with you is a gift!",
        "You make everything around you more beautiful!",
        "The stars have nothing on your sparkle!",
        "You are loved more than you will ever know!"
    };

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        if (name == null || name.isBlank()) {
            name = "Beautiful";
        }

        LocalDateTime now = LocalDateTime.now();
        String timeOfDay;
        int hour = now.getHour();
        if (hour < 12) timeOfDay = "morning";
        else if (hour < 17) timeOfDay = "afternoon";
        else timeOfDay = "evening";

        String greeting = GREETINGS[(int) (Math.random() * GREETINGS.length)];
        String time = now.format(DateTimeFormatter.ofPattern("h:mm a"));

        PrintWriter out = resp.getWriter();
        out.printf("""
            {
              "name": "%s",
              "timeOfDay": "%s",
              "currentTime": "%s",
              "compliment": "%s"
            }
            """,
            escapeJson(name), timeOfDay, time, escapeJson(greeting));
    }

    private String escapeJson(String s) {
        return s.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n");
    }
}

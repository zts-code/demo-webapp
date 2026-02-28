package com.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        if (name == null || name.isBlank()) {
            name = "World";
        }

        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'><head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Hello, " + escapeHtml(name) + "!</title>");
        out.println("<style>");
        out.println("* { margin: 0; padding: 0; box-sizing: border-box; }");
        out.println("body { font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif; background: #0a0a1a; display: flex; justify-content: center; align-items: center; min-height: 100vh; overflow: hidden; }");
        out.println(".bg { position: fixed; inset: 0; background: linear-gradient(135deg, #0a0a1a, #1a1040, #0d2137, #0a0a1a); background-size: 400% 400%; animation: gradientShift 12s ease infinite; z-index: 0; }");
        out.println("@keyframes gradientShift { 0% { background-position: 0% 50%; } 50% { background-position: 100% 50%; } 100% { background-position: 0% 50%; } }");
        out.println(".orb { position: fixed; border-radius: 50%; filter: blur(80px); opacity: 0.4; z-index: 1; }");
        out.println(".orb-1 { width: 350px; height: 350px; background: #7b2ff7; top: -80px; left: -60px; animation: float1 8s ease-in-out infinite; }");
        out.println(".orb-2 { width: 300px; height: 300px; background: #00d2ff; bottom: -60px; right: -40px; animation: float2 10s ease-in-out infinite; }");
        out.println(".orb-3 { width: 250px; height: 250px; background: #ff6b9d; top: 50%; left: 60%; animation: float3 9s ease-in-out infinite; }");
        out.println("@keyframes float1 { 0%, 100% { transform: translate(0, 0); } 50% { transform: translate(60px, 40px); } }");
        out.println("@keyframes float2 { 0%, 100% { transform: translate(0, 0); } 50% { transform: translate(-50px, -30px); } }");
        out.println("@keyframes float3 { 0%, 100% { transform: translate(0, 0); } 33% { transform: translate(-40px, 30px); } 66% { transform: translate(30px, -20px); } }");
        out.println(".card { position: relative; z-index: 2; background: rgba(255,255,255,0.05); backdrop-filter: blur(20px); -webkit-backdrop-filter: blur(20px); border: 1px solid rgba(255,255,255,0.1); border-radius: 20px; padding: 50px 44px; text-align: center; max-width: 480px; width: 90%; box-shadow: 0 8px 32px rgba(0,0,0,0.3); animation: cardEnter 0.8s cubic-bezier(0.16,1,0.3,1) forwards; opacity: 0; }");
        out.println("@keyframes cardEnter { from { opacity: 0; transform: translateY(30px) scale(0.96); } to { opacity: 1; transform: translateY(0) scale(1); } }");
        out.println("h1 { font-size: 2rem; font-weight: 700; background: linear-gradient(135deg, #ffffff, #a78bfa); -webkit-background-clip: text; -webkit-text-fill-color: transparent; background-clip: text; margin-bottom: 8px; }");
        out.println("p { color: rgba(255,255,255,0.5); font-size: 0.95rem; margin: 10px 0; }");
        out.println("form { margin-top: 24px; display: flex; gap: 10px; justify-content: center; }");
        out.println("input[type=text] { padding: 12px 16px; background: rgba(255,255,255,0.07); border: 1px solid rgba(255,255,255,0.15); border-radius: 10px; font-size: 0.95rem; color: #fff; outline: none; transition: border-color 0.25s, box-shadow 0.25s; }");
        out.println("input[type=text]::placeholder { color: rgba(255,255,255,0.3); }");
        out.println("input[type=text]:focus { border-color: #7b2ff7; box-shadow: 0 0 16px rgba(123,47,247,0.3); }");
        out.println("button { padding: 12px 24px; background: linear-gradient(135deg, #7b2ff7, #00d2ff); color: white; border: none; border-radius: 10px; font-size: 0.95rem; font-weight: 600; cursor: pointer; transition: transform 0.25s, box-shadow 0.25s; box-shadow: 0 4px 20px rgba(123,47,247,0.3); }");
        out.println("button:hover { transform: translateY(-2px) scale(1.03); box-shadow: 0 6px 30px rgba(123,47,247,0.5); }");
        out.println("button:active { transform: translateY(0) scale(0.98); }");
        out.println("a { color: rgba(255,255,255,0.45); text-decoration: none; font-size: 0.9rem; transition: color 0.2s; }");
        out.println("a:hover { color: #a78bfa; }");
        out.println(".back { margin-top: 28px; }");
        out.println("</style>");
        out.println("</head><body>");
        out.println("<div class='bg'></div>");
        out.println("<div class='orb orb-1'></div>");
        out.println("<div class='orb orb-2'></div>");
        out.println("<div class='orb orb-3'></div>");
        out.println("<div class='card'>");
        out.println("  <h1>Hello, " + escapeHtml(name) + "!</h1>");
        out.println("  <p>Server time: " + now + "</p>");
        out.println("  <form method='get' action='hello'>");
        out.println("    <input type='text' name='name' placeholder='Enter your name'>");
        out.println("    <button type='submit'>Greet</button>");
        out.println("  </form>");
        out.println("  <div class='back'><a href='index.html'>&larr; Back to Home</a></div>");
        out.println("</div>");
        out.println("</body></html>");
    }

    private String escapeHtml(String input) {
        return input.replace("&", "&amp;")
                     .replace("<", "&lt;")
                     .replace(">", "&gt;")
                     .replace("\"", "&quot;");
    }
}

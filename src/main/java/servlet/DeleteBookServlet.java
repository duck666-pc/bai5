package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.BookRepository;

import java.io.IOException;

@WebServlet(value = "/book/delete") // Đổi URL để tránh xung đột
public class DeleteBookServlet extends HttpServlet {
    private final BookRepository repository = new BookRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr != null) {
            Integer id = Integer.valueOf(idStr);
            repository.deleteById(id);
        }
        resp.sendRedirect(req.getContextPath() + "/book");
    }
}

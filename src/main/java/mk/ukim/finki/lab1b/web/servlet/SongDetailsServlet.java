package mk.ukim.finki.lab1b.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.lab1b.model.Song;
import mk.ukim.finki.lab1b.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "details", urlPatterns = "/details")
public class SongDetailsServlet extends HttpServlet {
    private final SpringTemplateEngine templateEngine;
    private final SongService songService;

    public SongDetailsServlet(SpringTemplateEngine templateEngine, SongService songService) {
        this.templateEngine = templateEngine;
        this.songService = songService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext webContext = new WebContext(webExchange);

        String songId = req.getSession().getAttribute("selectedSongID").toString();
        req.getSession().removeAttribute("selectedSongID");

        Song selectedSong = songService.findByTrackId(songId);
        webContext.setVariable("selectedSong", selectedSong);
        templateEngine.process("songDetails.html", webContext, resp.getWriter());
    }
}

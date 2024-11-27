package mk.ukim.finki.lab1b.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.lab1b.model.Song;
import mk.ukim.finki.lab1b.service.SongService;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "listSongs", urlPatterns = "/listSongs")
public class SongListServlet extends HttpServlet {

    //pravime da zavisi od SongService + dodavame SpringTemplateEngine
    private final SpringTemplateEngine templateEngine;
    private final SongService songService;

    public SongListServlet(SpringTemplateEngine templateEngine, SongService songService) {
        this.templateEngine = templateEngine;
        this.songService = songService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext webContext = new WebContext(webExchange);

        //ja zema listOfSongs i zema song od request atributot
        webContext.setVariable("songs", songService.listSongs());


        //search input
        String search = req.getParameter("searchInput");
        if(search == null || search.isEmpty()) {
            webContext.setVariable("songs", songService.listSongs());
        }else {
            webContext.setVariable("songs", songService.searchByName(search));
        }


        templateEngine.process("listSongs.html", webContext, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trackId = req.getParameter("trackId");
        req.getSession().setAttribute("selectedSongID", trackId);
        resp.sendRedirect(req.getContextPath() + "/artist");
    }
}

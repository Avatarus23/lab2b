package mk.ukim.finki.lab1b.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.lab1b.model.Artists;
import mk.ukim.finki.lab1b.model.Song;
import mk.ukim.finki.lab1b.service.ArtistService;
import mk.ukim.finki.lab1b.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "artist", urlPatterns = "/artist")
public class АrtistServlet extends HttpServlet {

    //implementacija na potrebnite klasi
    private final SpringTemplateEngine templateEngine;
    private final ArtistService artistService;
    private final SongService songService;

    public АrtistServlet(SpringTemplateEngine templateEngine, ArtistService artistService, SongService songService) {
        this.templateEngine = templateEngine;
        this.artistService = artistService;
        this.songService = songService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext webContext = new WebContext(webExchange);

        webContext.setVariable("artists", artistService.listArtists());

        String songId = req.getSession().getAttribute("selectedSongID").toString();
        webContext.setVariable("selectedSongID", songId);

        templateEngine.process("artistsList", webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //for single artist
        /*String artistId = req.getParameter("artistId");
        Artists selectedArtist = artistService.findById(Long.parseLong(artistId));

        String songID = req.getSession().getAttribute("selectedSongID").toString();

        Song selectedSong = songService.findByTrackId(songID);
        songService.addArtistToSong(selectedArtist, selectedSong);
        resp.sendRedirect(req.getContextPath() + "/details");*/


        //ne raboti za povekje artisti da prikaze
        //PRORABOTIIIIIIIIII
        String[] artistIds = req.getParameterValues("artistId"); //for multiple artists
        String songID = req.getSession().getAttribute("selectedSongID").toString();

        Song selectedSong = songService.findByTrackId(songID);

        for (String artistId : artistIds) {
            Artists selectedArtist = artistService.findById(Long.parseLong(artistId));
            songService.addArtistToSong(selectedArtist, selectedSong);
            if(artistId == null) {
                break;
            }
        }

        resp.sendRedirect(req.getContextPath() + "/details");
    }
}

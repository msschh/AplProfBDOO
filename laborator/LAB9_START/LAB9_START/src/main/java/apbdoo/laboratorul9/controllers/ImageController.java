package apbdoo.laboratorul9.controllers;

import apbdoo.laboratorul9.domain.Film;
import apbdoo.laboratorul9.services.FilmService;
import apbdoo.laboratorul9.services.ImageService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ImageController {
    private final ImageService imageService;
    private final FilmService filmService;
    public ImageController(ImageService imageService, FilmService filmService) {
        this.imageService = imageService;
        this.filmService = filmService; }

        @GetMapping("film/{id}/image")
        public String showUploadForm(@PathVariable String id, Model model){
        model.addAttribute("film", filmService.findById(Long.valueOf(id)));
        return "imageform"; }

        @PostMapping("film/{id}/image")
        public String handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file){
        imageService.saveImageFile(Long.valueOf(id), file);
        return "redirect:/film/info/" + id; }

    @GetMapping("film/{id}/filmimage")
    public void downloadImage(@PathVariable String id, HttpServletResponse response) throws IOException {
        Film film = filmService.findById(Long.valueOf(id));
        if (film.getImagine() != null) {
            byte[] byteArray = new byte[film.getImagine().length]; int i = 0; for (Byte wrappedByte : film.getImagine()){ byteArray[i++] = wrappedByte; } response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray); try {
                IOUtils.copy(is, response.getOutputStream()); } catch (IOException e) { e.printStackTrace(); } } }

}
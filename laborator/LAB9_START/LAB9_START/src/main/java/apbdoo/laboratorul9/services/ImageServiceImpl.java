package apbdoo.laboratorul9.services;
import apbdoo.laboratorul9.domain.Film;
import apbdoo.laboratorul9.repositories.FilmRepository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.IOException;


@Service public class ImageServiceImpl implements ImageService{
    FilmRepository filmRepository;

    public ImageServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override @Transactional public void saveImageFile(Long filmId, MultipartFile file) {
        try { Film film = filmRepository.findById(filmId).get();
            Byte[] byteObjects = new Byte[file.getBytes().length];
            int i = 0; for (byte b : file.getBytes()){
                byteObjects[i++] = b; }
                film.setImagine(byteObjects);
            filmRepository.save(film); }
        catch (IOException e) {
        }
    }
}

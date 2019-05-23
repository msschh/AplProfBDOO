package apbdoo.laboratorul9.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    void saveImageFile(Long filmId, MultipartFile file);
}
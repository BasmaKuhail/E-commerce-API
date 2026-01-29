package e_commerce.api.e_commerce.service;

import e_commerce.api.e_commerce.model.Image;
import e_commerce.api.e_commerce.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository;

    public Image getImage(Long iId){
        return imageRepository.getReferenceById(iId);
    }
    public Image addImage(Image image){
        return imageRepository.save(image);
    }
//    public Image getImageByImageURL(String iURL){
//        return imageRepository.findImageByImageURL(iURL);
//    }
}

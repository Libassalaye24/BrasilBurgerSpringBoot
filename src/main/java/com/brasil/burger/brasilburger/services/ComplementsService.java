package com.brasil.burger.brasilburger.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.brasil.burger.brasilburger.models.Boisson;
import com.brasil.burger.brasilburger.models.Frite;
import com.brasil.burger.brasilburger.models.Marque;
import com.brasil.burger.brasilburger.models.Taille;
import com.brasil.burger.brasilburger.repositories.BoissonRepository;
import com.brasil.burger.brasilburger.repositories.FriteRepository;
import com.brasil.burger.brasilburger.repositories.MarqueRepository;
import com.brasil.burger.brasilburger.repositories.TailleRepository;

import lombok.extern.java.Log;

@Service
@Log
public class ComplementsService {

    private FriteRepository friteRepository;
    private TailleRepository tailleRepository;
    private BoissonRepository boissonRepository;
    private MarqueRepository marqueRepository;

    @Autowired
    public ComplementsService(FriteRepository friteRepository, TailleRepository tailleRepository,
            BoissonRepository boissonRepository, MarqueRepository marqueRepository) {
        this.tailleRepository = tailleRepository;
        this.friteRepository = friteRepository;
        this.boissonRepository = boissonRepository;
        this.marqueRepository = marqueRepository;
    }

    public Frite addFrite(Frite frite) {
        try {
            friteRepository.save(frite);
            return frite;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;

        }
    }
  
    public List<Frite> findAllFrites(){
        return friteRepository.findAll();
    }
    public Frite findFriteById(Long id){
        return friteRepository.findById(id).orElse(null);
    }
    public Taille addTaille(Taille taille) {
        try {
            tailleRepository.save(taille);
            return taille;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;

        }
    }
    public List<Taille> findAllTailles(){
        return tailleRepository.findAll();
    }
    public Taille findTailleById(Long id){
        return tailleRepository.findById(id).orElse(null);
    }

    public Boisson addBoisson(Boisson b) {
        try {
            boissonRepository.save(b);
            return b;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;

        }
    }

    public List<Boisson> findAllBoissons(){
        return boissonRepository.findAll();
    }
    public Boisson findBoissonById(Long id){
        return boissonRepository.findById(id).orElse(null);
    }

    public Marque addMarque(Marque marque) {
        try {
            marqueRepository.save(marque);
            return marque;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;

        }
    }
    public List<Marque> findAllMarques(){
        return marqueRepository.findAll();
    }
    public Marque findMarqueById(Long id){
        return marqueRepository.findById(id).orElse(null);
    }

    public static void saveFile(String uploadDir, String fileName,
                                MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }

}

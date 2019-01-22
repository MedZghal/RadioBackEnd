package com.example.radiosfax.Metier;

import com.example.radiosfax.dao.DBFileUploadRepository;
import com.example.radiosfax.dao.InterventionRepository;
import com.example.radiosfax.entities.Filesupload;
import com.example.radiosfax.entities.Intervention;
import com.perfectsolution.Clinique.Exception.FileStorageException;
import com.perfectsolution.Clinique.Exception.MyFileNotFoundException;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.util.*;
import java.io.*;
import java.util.*;

@Service
public class DBFileUploadMetierImpl implements DBFileUploadMetier
{
    @Autowired
    private DBFileUploadRepository bFileUploadRepository;
    
     @Autowired
    private InterventionRepository interventionRepository;
    
    public Filesupload storeFile(final MultipartFile file , int num_intervention) {
        final String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            Intervention inv = interventionRepository.getOne(num_intervention);
            final Filesupload dbFile = new Filesupload(fileName, file.getContentType(), file.getBytes(),inv);
            return (Filesupload)this.bFileUploadRepository.save((Filesupload)dbFile);
        }
        catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", (Throwable)ex);
        }
    }
    
    
    
    public List<Filesupload> getAllFile() {
        return (List<Filesupload>)this.bFileUploadRepository.findAll();
    }
    
 

    @Override
    public Filesupload getFile(String fileId) {
        return this.bFileUploadRepository.findById(fileId).orElseThrow(() -> {
             return (new MyFileNotFoundException("File not found with id " + fileId));
        });
    }

    @Override
    public void DeleteFile(String fileId) {
        this.bFileUploadRepository.deleteById(fileId);
    }

    @Override
    public List<Filesupload> GetFilesUploadByINtrv(int numIntervention) {
        return bFileUploadRepository.GetFilesUploadByINtrv(numIntervention);
    }

}

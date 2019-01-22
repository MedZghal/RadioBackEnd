package com.example.radiosfax.Metier;



import com.example.radiosfax.entities.Filesupload;
import org.springframework.web.multipart.*;
import java.util.*;

public interface DBFileUploadMetier
{
    Filesupload storeFile(final MultipartFile file , int num_intervention);
    
    Filesupload getFile(final String fileId);
    
    void DeleteFile(final String fileId);
    
    List<Filesupload> getAllFile();
    
    List<Filesupload> GetFilesUploadByINtrv(int numIntervention);
}

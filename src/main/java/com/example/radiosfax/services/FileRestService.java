package com.example.radiosfax.services;


import com.example.radiosfax.Metier.DBFileUploadMetierImpl;
import com.example.radiosfax.entities.Filesupload;
import com.example.radiosfax.entities.UploadFileResponse;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.servlet.support.*;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.slf4j.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
public class FileRestService
{
    private static final Logger logger;
    @Autowired
    private DBFileUploadMetierImpl DBFileStorageService;
    
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") final MultipartFile file, @RequestParam("num_intervention")  int num_intervention) {
        final Filesupload dbFile = this.DBFileStorageService.storeFile(file,num_intervention);
        final String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(dbFile.getId()).toUriString();
        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
    }
    
     @GetMapping({ "/downloadFile/{fileId}" })
    public ResponseEntity<byte[]> downloadFile(@PathVariable final String fileId) {
        Filesupload dbFile = this.DBFileStorageService.getFile(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(dbFile.getData());
    }
    
        @GetMapping({ "/ViewFile/{fileId}" })
    public ResponseEntity<byte[]> ViewFile(@PathVariable final String fileId) {
        final Filesupload dbFile = this.DBFileStorageService.getFile(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"inline; filename=\"" + dbFile.getFileName() + "\"")
                .body(dbFile.getData());
    }
    
    @GetMapping({ "/ViewAllFile" })
    public List<Filesupload> getAllFile() {
        return this.DBFileStorageService.getAllFile();
    }
    
  
    
    @PostMapping({ "/DeleteFile" })
    public String DeleteFile(@RequestParam("fileId") String fileId) {
        this.DBFileStorageService.DeleteFile(fileId);
        return "true";
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)FileRestService.class);
    }
    
    @GetMapping("/GetFilesUploadByINtrv")
    public List<Filesupload> GetFilesUploadByINtrv(@RequestParam("numIntervention")int numIntervention) {
        return DBFileStorageService.GetFilesUploadByINtrv(numIntervention);
    }
}

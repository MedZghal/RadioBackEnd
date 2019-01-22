package com.example.radiosfax.dao;




import com.example.radiosfax.entities.Filesupload;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface DBFileUploadRepository extends JpaRepository<Filesupload, String>
{
    
    @Query("SELECT f.id AS id,f.fileName AS fileName,f.fileType AS fileType FROM Filesupload f WHERE f.numIntervention.numIntervention = :numIntervention")
    public List<Filesupload> GetFilesUploadByINtrv(@Param("numIntervention") int numIntervention);

}

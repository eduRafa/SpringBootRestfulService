package com.springbootrestfulservice.repositories;

import com.springbootrestfulservice.model.Video;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    @Query(
    value="SELECT * FROM video AS v WHERE v.visualizaciones > ? ORDER BY v.visualizaciones DESC",
            nativeQuery=true)
    public List<Video> findByVisualizaciones(int visualizaciones);

}


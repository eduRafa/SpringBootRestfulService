package com.springbootrestfulservice.repositories;

import com.springbootrestfulservice.model.Youtuber;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rafae
 */
@Repository
public interface YoutuberRepository extends JpaRepository<Youtuber, Long> {

    @Query(
            value = "SELECT * FROM youtuber y WHERE y.nombre LIKE %?1%",
            nativeQuery = true
    )
    public List<Youtuber> getByTitle(String name);

}

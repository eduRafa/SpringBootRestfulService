package com.springbootrestfulservice.repositories;

import com.springbootrestfulservice.model.Youtuber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rafae
 */
@Repository
public interface YoutuberRepository extends JpaRepository<Youtuber, Long>{
    
}


package com.springbootrestfulservice.repositories;

import com.springbootrestfulservice.model.Categoria;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Juan Antonio
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
        @Query(
    value="SELECT * FROM categoria AS c WHERE c.nombre LIKE %?1%",
            nativeQuery=true)
    public List<Categoria> getByName(String title);
 

}

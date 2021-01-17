package galerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import galerie.entity.Exposition;
import org.springframework.data.jpa.repository.Query;

// This will be AUTO IMPLEMENTED by Spring 

public interface ExpositionRepository extends JpaRepository<Exposition, Integer> {    
    
    
    // Les test ne fonctionnent plus lorsque j'ajoute la @Query 
   @Query("SELECT SUM(PRIX_VENTE)FROM EXPOSITION "
            + "INNER JOIN TRANSACTION "
            + "WHERE EXPOSITION.ID = TRANSACTION.ACCROCHAGE_ID "
            + "AND EXPOSITION.ID = ?1")
    public float chiffreAffairePour(Integer id);
 
}

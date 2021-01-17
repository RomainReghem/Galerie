package galerie.dao;

import galerie.entity.Galerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import galerie.dao.GalerieRepository;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class ExpositionRepositoryTest {

    @Autowired
    private ExpositionRepository expoDAO;

    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Exposition'");
        int combienDansLeJeuDeTest = 2; 
        long nombre = expoDAO.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 2 expos" );
    }
    
   /* @Test
    @Sql("test-data.sql")
    public void testChiffreAffairePour(){
        // La somme devrait être de 180 000 (120k + 10k + 50k)
        assertEquals (180000, expoDAO.chiffreAffairePour(1));
        
    }*/

}

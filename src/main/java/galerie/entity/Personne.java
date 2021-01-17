package galerie.entity;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    @OneToMany(mappedBy="personne")
    List<Transaction> transactions = new LinkedList<>();
    
    public float budgetArt(int annee){
        float bArt = 0;
        for (Transaction t : transactions){
            if (t.getVenduLe().getYear() == annee){
                bArt += t.getPrixVente();
            }
        }
        return bArt;
    }
}   
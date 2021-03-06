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
public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    // TODO : Mettre en oeuvre la relation oneToMany vers Exposition
    @OneToMany(mappedBy = "galerie")
    List<Exposition> accrochages = new LinkedList<>();
   
    public float CAAnnuel (int annee){
        float cAnnuel = 0;
        for (Exposition e : accrochages){
            if (e.getDebut().getYear() == annee){
                cAnnuel += e.chifreAffaire();
            }
        }
        return cAnnuel;
    }
    
    
}

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
public class Tableau {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column
    @NonNull
    private String titre;
    
    @Column
    @NonNull
    private String support;
    
    @Column
    @NonNull
    private int largeur;
    
    @Column
    @NonNull
    private int hauteur;
    
    @ManyToMany(mappedBy="tableaux")
    List<Exposition> accrochages = new LinkedList<>();
    
    @ManyToOne
    private Artiste artiste;
    
    @OneToOne(mappedBy="tableau")
    private Transaction transaction;
}

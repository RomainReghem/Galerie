package galerie.entity;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Transaction {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column
    @NonNull
    private LocalDate venduLe;
    @Column
    @NonNull
    private float prixVente;
    
    @OneToOne
    private Tableau tableau;
    
    @ManyToOne
    private Personne personne;
    
    @ManyToOne
    private Exposition accrochage;
}
    
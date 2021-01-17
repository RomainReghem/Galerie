package galerie.entity;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Exposition {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column
    @NonNull
    private LocalDate debut;
    
    @Column
    @NonNull
    private String intitule;
    
    @Column
    @NonNull
    private int duree;
    
    @ManyToOne
    private Galerie galerie;
    
    @OneToMany(mappedBy="accrochage")
    List<Transaction> transactions = new LinkedList<>();
    
    @ManyToMany
    List<Tableau> tableaux = new LinkedList<>();
    
    
   public float chifreAffaire(){
       float cAffaire = 0;
       for (Transaction t : transactions ){
           cAffaire += t.getPrixVente();
       }
       return cAffaire;
   }

    
}
package soft_afric.clim.shop.clim_shop.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import soft_afric.clim.shop.clim_shop.data.enums.EtatCommande;
import soft_afric.clim.shop.clim_shop.data.enums.ModePaiement;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="commande")
public class Commande extends AbstractEntity{
    private Date date;
    private ModePaiement modePaiement;
    private EtatCommande etatCommande;
    @OneToMany(mappedBy = "commande")
    List<LigneCommande> lignes;
}

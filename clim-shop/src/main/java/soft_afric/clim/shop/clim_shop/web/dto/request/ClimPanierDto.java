package soft_afric.clim.shop.clim_shop.web.dto.request;

import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ClimPanierDto {
    private Long id;
    private  String libelle;
    private  int montant = 0;
    private  int quantite = 0;
    private  int prix;

    public  int calcQuantite(int qte){
        quantite+=qte;
        return  quantite;
    }
    public  int calcMontant(int mt){
        montant+=mt;
        return  montant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClimPanierDto that = (ClimPanierDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

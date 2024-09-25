package soft_afric.clim.shop.clim_shop.web.dto;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import soft_afric.clim.shop.clim_shop.data.entities.Categorie;
import soft_afric.clim.shop.clim_shop.data.entities.Clim;
import soft_afric.clim.shop.clim_shop.data.entities.Marque;
import soft_afric.clim.shop.clim_shop.data.enums.EtatClim;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClimDto {
    private Long id;
    private String libelle;
    private String marque;
    private int prix;
    private String image;
    private String etat;
    private int surface;
    private int capacite;

    public static ClimDto toCardDto(Clim clim){
        return ClimDto.builder()
                    .id(clim.getId())
                    .libelle(clim.getLibelle())
                    .marque(clim.getMarque().getLibelle())
                    .prix(clim.getPrix())
                    .image(clim.getImage()).build();
    }

    public static ClimDto toDetailsDto(Clim clim){
        return ClimDto.builder()
                    .id(clim.getId())
                    .libelle(clim.getLibelle())
                    .marque(clim.getMarque().getLibelle())
                    .prix(clim.getPrix())
                    .image(clim.getImage())
                    .etat(clim.getEtat().toString())
                    .surface(clim.getCapacite())
                    .capacite(clim.getCapacite()).build();
    }
}

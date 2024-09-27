package soft_afric.clim.shop.clim_shop.web.dto.request;

import lombok.*;
import soft_afric.clim.shop.clim_shop.web.dto.response.ClientResponseDto;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PanierRequestDto {
    private List<ClimPanierDto> articles;
    private Double total = 0.0;
    private ClientResponseDto client;
    public void addClimToPanier(ClimPanierDto article){
        int pos = articles.indexOf(article);
        if(pos != -1){
            System.out.println("Article déjà pris");
            ClimPanierDto articleGetOfPanier =  articles.get(pos);
            articleGetOfPanier.calcQuantite(article.getQuantite());
            articleGetOfPanier.calcMontant(article.getQuantite()*articleGetOfPanier.getPrix());
            total+=article.getQuantite()*articleGetOfPanier.getPrix();
        }
        else{
            article.setMontant(article.getQuantite()*article.getPrix());
            articles.add(article);
            total+= article.getMontant();
        }
    }
}

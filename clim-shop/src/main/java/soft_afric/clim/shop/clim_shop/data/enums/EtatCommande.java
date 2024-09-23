package soft_afric.clim.shop.clim_shop.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EtatCommande {
    EnCours(0),
    Valide(1),
    Invalide(2),
    Livree(3);
    private final Integer index;
}

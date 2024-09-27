package soft_afric.clim.shop.clim_shop.web.controllers.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import soft_afric.clim.shop.clim_shop.data.entities.Clim;
import soft_afric.clim.shop.clim_shop.services.ClimService;
import soft_afric.clim.shop.clim_shop.web.controllers.PanierController;
import soft_afric.clim.shop.clim_shop.web.dto.request.ClimPanierDto;
import soft_afric.clim.shop.clim_shop.web.dto.request.PanierRequestDto;

@SessionAttributes({"panier"})
@Controller
@RequiredArgsConstructor
@RequestMapping("/client")
public class PanierControllerImpl implements PanierController {
    private final ClimService climService;
    @Override
    public String addClimToPanier(Model model, ClimPanierDto article, PanierRequestDto panier) {
        Clim article1 = climService.show(article.getId()).orElse(null);
        if(article1 != null){
            if(article.getQuantite()<article1.getQteStock()){

            }
        }
        return "redirect:/panier";
    }

    @Override
    public String panier(Model model,
                         @ModelAttribute("panier") PanierRequestDto panier) {
        return "client/shopping-cart";
    }
}

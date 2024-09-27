package soft_afric.clim.shop.clim_shop.web.controllers;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import soft_afric.clim.shop.clim_shop.web.dto.request.ClimPanierDto;
import soft_afric.clim.shop.clim_shop.web.dto.request.PanierRequestDto;

public interface PanierController {
    @PostMapping("/add-panier")
    String addClimToPanier(Model model,
                            @Valid ClimPanierDto article,
                            @ModelAttribute("panier") PanierRequestDto panier);

    @GetMapping("/panier")
    String panier(Model model,
                  @ModelAttribute("panier") PanierRequestDto panier
                  );
}

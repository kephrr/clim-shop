package soft_afric.clim.shop.clim_shop.web.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import soft_afric.clim.shop.clim_shop.web.dto.request.ClientRequestDto;

public interface AdminController {
    // Voir toutes les clims
    @GetMapping("/clims")
    String allClims();

    // Voir une clim et la modifier
    @GetMapping("/clims/{id}")
    String showClim();

    // Enregistrer / Modifier une clim
    @PostMapping("/clims")
    String saveClim();

    //

    // Voir tous les clients
    @GetMapping("/clients")
    String allClients();

    // Modifier un client
    @PostMapping("/clients")
    String saveClient();
}

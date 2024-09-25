package soft_afric.clim.shop.clim_shop.web.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ClimController {
    @GetMapping("/home")
    String homePage(Model model);

    @GetMapping("/details/{id}")
    String homePage(Model model,
                    @PathVariable Long id);
}

package soft_afric.clim.shop.clim_shop.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

public interface ClientController {
    @GetMapping("/account")
    String account();

    @PutMapping ("/account")
    String modifyAccount();
}

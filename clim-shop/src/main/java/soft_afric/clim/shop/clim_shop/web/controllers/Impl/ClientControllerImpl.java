package soft_afric.clim.shop.clim_shop.web.controllers.Impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import soft_afric.clim.shop.clim_shop.web.controllers.ClientController;

@Controller
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientControllerImpl implements ClientController {
    @Override
    public String account() {
        return "client/account";
    }

    @Override
    public String modifyAccount() {
        return "";
    }
}

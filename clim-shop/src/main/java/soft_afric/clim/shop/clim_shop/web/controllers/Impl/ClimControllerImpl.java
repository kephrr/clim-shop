package soft_afric.clim.shop.clim_shop.web.controllers.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import soft_afric.clim.shop.clim_shop.data.entities.Clim;
import soft_afric.clim.shop.clim_shop.services.ClimService;
import soft_afric.clim.shop.clim_shop.web.controllers.ClimController;
import soft_afric.clim.shop.clim_shop.web.dto.ClimDto;

@Controller
@RequiredArgsConstructor
public class ClimControllerImpl implements ClimController {
    private final ClimService climService;
    @Override
    public String homePage(Model model) {
        model.addAttribute("clims", climService.findAll().stream().map(ClimDto::toCardDto));
        return "home";
    }

    @Override
    public String homePage(Model model, Long id) {
        Clim clim = climService.show(id).orElse(null);
        if(clim==null){
            return "redirect:home";
        }
        ClimDto climDetails = ClimDto.toDetailsDto(clim);
        model.addAttribute("climDetails", climDetails);
        return "public/clim-details";
    }
}

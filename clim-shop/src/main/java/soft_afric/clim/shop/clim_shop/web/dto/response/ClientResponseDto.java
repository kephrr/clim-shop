package soft_afric.clim.shop.clim_shop.web.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import soft_afric.clim.shop.clim_shop.data.entities.Adresse;
import soft_afric.clim.shop.clim_shop.data.entities.Client;
import soft_afric.clim.shop.clim_shop.security.data.entities.AppUser;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientResponseDto {
    private  Long id;
    private String nomComplet;
    private  String tel;
    private  String adresse;
    private  String quartier;
    private  String ville;
    private  String numVilla;


    public  static ClientResponseDto toDto(Client client){
          return  ClientResponseDto.builder()
                  .id(client.getId())
                  .nomComplet(client.getNomComplet())
                  .tel(client.getTel())
                  .adresse(client.getAdresse().toString())
                  .build();
    }
    public   Client toEntity(){
         Client cl=  Client.builder()
                  .nomComplet(this.getNomComplet())
                  .adresse(new Adresse(this.quartier,this.ville,this.numVilla))
                  .tel(this.tel)
                  .commandes(null)
                  .build();
         cl.setId(this.id);
         return  cl;
    }
}

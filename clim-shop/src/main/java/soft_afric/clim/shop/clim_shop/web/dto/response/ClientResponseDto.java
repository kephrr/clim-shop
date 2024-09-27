package soft_afric.clim.shop.clim_shop.web.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import soft_afric.clim.shop.clim_shop.data.entities.Adresse;
import soft_afric.clim.shop.clim_shop.data.entities.Client;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {

    private  Long id;

    private String nomComplet;

    private  String tel;

   private  String quartier;

  private  String numVilla;
  private  String ville;

  public  static ClientResponseDto toDto(Client client){
      return  new ClientResponseDto(client.getId(),client.getNomComplet(),client.getTel(),client.getAdresse().getQuartier(),client.getAdresse().getNumVilla(),client.getAdresse().getVille());
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

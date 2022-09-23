package uja.controlador.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import uja.entidades.Administrador;
import uja.entidades.Cliente;

@Data
@NoArgsConstructor
public class AdministradorDTO {
    private String username;
    private String password;

    public Administrador administradorDTOtoAdministrador() {
        Administrador administrador = new Administrador();
        BeanUtils.copyProperties(this, administrador);
        return administrador;
    }
}

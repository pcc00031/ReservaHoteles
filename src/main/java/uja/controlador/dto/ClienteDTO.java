package uja.controlador.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import uja.entidades.Cliente;

@Data
@NoArgsConstructor
public class ClienteDTO {
    private String nombre;
    private String username;
    private String password;
    private String dirección;
    private String tlf;
    private String email;

    public Cliente clienteDTOtoCliente() {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(this, cliente);
        return cliente;
    }
}

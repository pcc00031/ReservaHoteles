package uja.controlador.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Login {
    private String mensaje;
    private String usuario;
    private String rol;
}

package uja.entidades;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cliente { //fixme validar entidades @NotNull etc (en DTO tb)
    private int id;
    private String nombre;
    private String username;
    private String password;
    private String direccion;
    private String tlf;
    private String email;
}

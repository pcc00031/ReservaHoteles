package uja.entidades;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Administrador {
    private int id;
    private String username;
    private String password;
}

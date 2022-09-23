package uja.entidades;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Hotel {
    private int id;
    private String nombre;
    private String direccion;
    private List<Habitacion> habitaciones;
}

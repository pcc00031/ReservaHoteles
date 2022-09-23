package uja.entidades;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Habitacion {
    private int id;
    private String tipo;
    private float precio;
    private boolean disponible;
}

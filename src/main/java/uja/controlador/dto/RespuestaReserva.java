package uja.controlador.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import uja.entidades.Hotel;

import java.util.List;

@Data
@AllArgsConstructor
public class RespuestaReserva {
    private String mensaje;
    private List<Hotel> hoteles;
}

package uja.controlador.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ReservaDTO {
    private String destino;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private int numHambitaciones; // TODO Valorar si son habs dobles o basicas
}

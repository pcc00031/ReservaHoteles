package uja.controlador.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import uja.entidades.Hotel;
import uja.entidades.Habitacion;

import java.util.List;

@Data
@NoArgsConstructor
public class HotelDTO {
    private String nombre;
    private String direccion;
    private List<Habitacion> habitaciones;

    public Hotel hotelDTOtoHotel() {
        Hotel hotel = new Hotel();
        BeanUtils.copyProperties(this, hotel);
        return hotel;
    }
}

package uja.servicio;

import uja.controlador.dto.ReservaDTO;
import uja.entidades.Administrador;
import uja.entidades.Cliente;
import uja.entidades.Hotel;

import java.util.List;

public interface IServicioMangue {

    Cliente registroCliente(Cliente cliente);

    Administrador registroAdministrador(Administrador administrador);

    Hotel agregarHotel(Hotel hotel);

    boolean loginAdministrador(String username, String password);

    boolean loginCliente(String username, String password);

    List<Hotel> hacerReserva(ReservaDTO reservaDTO);
}

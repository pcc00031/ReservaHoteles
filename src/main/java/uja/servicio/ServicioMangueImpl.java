package uja.servicio;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uja.controlador.dto.ReservaDTO;
import uja.entidades.Administrador;
import uja.entidades.Cliente;
import uja.entidades.Habitacion;
import uja.entidades.Hotel;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ServicioMangueImpl implements IServicioMangue {

    private List<Cliente> clientes;
    private List<Administrador> administradores;
    private List<Hotel> hoteles;
    private int numClientes;
    private int numAdministeadores;
    private int numHoteles;

    @PostConstruct
    private void init() {
        clientes = new ArrayList<>();
        administradores = new ArrayList<>();
        hoteles = new ArrayList<>();
        numClientes = 1;
        numAdministeadores = 1;
        numHoteles = 1;
    }

    @Override
    public Cliente registroCliente(Cliente cliente) {
        log.info("Cliente con datos: " + cliente + " registrandose");
        cliente.setId(numClientes++);
        clientes.add(cliente);
        log.info("Cliente con id: " + cliente.getId() + " registrado");
        return cliente;
    }

    @Override
    public Administrador registroAdministrador(Administrador administrador) {
        log.info("Administrador con datos: " + administrador + " registrandose");
        administrador.setId(numAdministeadores++);
        administradores.add(administrador);
        log.info("Administrador con id: " + administrador.getId() + " registrado");
        return administrador;
    }

    @Override //fixme controlar que lo haga solo administraddor
    public Hotel agregarHotel(Hotel hotel) {
        hotel.setId(numHoteles++);
        hoteles.add(hotel);
        log.info("Hotel con id: " + hotel.getId() + " registrado");
        return hotel;
    }

    @Override
    public boolean loginAdministrador(String username, String password) {
        for (Administrador administrador : administradores) {
            if (administrador.getUsername().equals(username)
                    && administrador.getPassword().equals(password)) {
                log.info("Login valido");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean loginCliente(String username, String password) {
        for (Cliente cliente : clientes) {
            if (cliente.getUsername().equals(username)
                    && cliente.getPassword().equals(password)) {
                log.info("Login valido");
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Hotel> hacerReserva(ReservaDTO reservaDTO) {
        return hoteles
                .stream()
                .filter(hotel -> hotel.getDireccion().equals(reservaDTO.getDestino())
                        && hotel.getHabitaciones().size() >= reservaDTO.getNumHambitaciones()
                        && hotel.getHabitaciones()
                        .stream()
                        .filter(Habitacion::isDisponible)
                        .count() >= reservaDTO.getNumHambitaciones())
                .collect(Collectors.toList());
    }
}

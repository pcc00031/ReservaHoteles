package uja.controlador;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uja.controlador.dto.*;
import uja.entidades.Hotel;
import uja.servicio.IServicioMangue;

import java.util.List;

@RestController
@Slf4j
public class ControladorMangue {

    @Autowired
    IServicioMangue servicioMangue;

    @PostMapping("cliente")
    public ResponseEntity<?> addCliente(@RequestBody ClienteDTO clienteDTO) {
        log.info("Intentando registrar: " + clienteDTO);
        return new ResponseEntity<>(
                servicioMangue.registroCliente(clienteDTO.clienteDTOtoCliente()), HttpStatus.CREATED);
    }

    @PostMapping("administrador")
    public ResponseEntity<?> addAdministrador(@RequestBody AdministradorDTO administradorDTO) {
        log.info("Intentando registrar: " + administradorDTO);
        return new ResponseEntity<>(
                servicioMangue.registroAdministrador(
                        administradorDTO.administradorDTOtoAdministrador()), HttpStatus.CREATED);
    }

    @PostMapping("hotel")
    public ResponseEntity<?> addHotel(@RequestBody HotelDTO hotelDTO) {
        log.info("Intentando registrar: " + hotelDTO);
        return new ResponseEntity<>(
                servicioMangue.agregarHotel(
                        hotelDTO.hotelDTOtoHotel()), HttpStatus.CREATED);
    }


    @GetMapping("login/{tipo}")
    public ResponseEntity<?> login(@PathVariable int tipo, @RequestParam String username, @RequestParam String password) {
        log.info("Cliente con username: " + username + " intentando hacer login");
        if (tipo == 1) {
            if (!servicioMangue.loginAdministrador(username, password)) {
                return new ResponseEntity<>(new Login("Credenciales invalidos", username, "ADMINISTRADOR"),
                        HttpStatus.CONFLICT);
            }
            return new ResponseEntity<>(new Login("Credenciales correctos", username, "ADMINISTRADOR"),
                    HttpStatus.OK);
        } else {
            if (!servicioMangue.loginCliente(username, password)) {
                return new ResponseEntity<>(new Login("Credenciales invalidos", username, "USUARIO"),
                        HttpStatus.CONFLICT);
            }
            return new ResponseEntity<>(new Login("Credenciales correctos", username, "USUARIO"),
                    HttpStatus.OK);
        }
    }

    @PostMapping("reserva")
    public ResponseEntity<?> reserva(@RequestBody ReservaDTO reservaDTO) {
        log.info("Buscando hoteles disponibles para: " + reservaDTO);
        List<Hotel> hoteles = servicioMangue.hacerReserva(reservaDTO);
        if (hoteles.isEmpty())
            return new ResponseEntity<>(
                    new RespuestaReserva("No hay hoteles disponibles", hoteles),
                    HttpStatus.OK);

        return new ResponseEntity<>(
                new RespuestaReserva("Registros disponibles: " + hoteles.size(), hoteles),
                HttpStatus.OK);
    }
}

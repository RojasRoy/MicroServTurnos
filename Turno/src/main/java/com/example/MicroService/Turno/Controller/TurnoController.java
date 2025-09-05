package com.example.MicroService.Turno.Controller;

import com.example.MicroService.Turno.DTO.TurnoDTO;
import com.example.MicroService.Turno.Model.Turno;
import com.example.MicroService.Turno.Service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turno")
public class TurnoController {

    @Autowired
    private ITurnoService turnoServ;

    //1 crear un nuevo turno
    @PostMapping("/crear")
    public String crearTurno(@RequestBody TurnoDTO turno){
        turnoServ.saveTurno(turno.getFecha(), turno.getTratamiento(), turno.getDniPaciente());

        return "turno creado correctamente";
    }

    //2 traer todos los turnos
    @GetMapping("/traer")
    public List<Turno> traerTurno(){
        return turnoServ.getTurno();
    }

    //3 eliminar turno
    @DeleteMapping("/borrar/{id}")
    public String deleteTurno(@PathVariable Long id){
        turnoServ.deleteTurno(id);

        return "turno borrado correctamente";
    }

    //4 editar turno
    @PutMapping("/editar/{idOriginal}")
    public Turno editTurno(@PathVariable Long idOriginal,
                            @RequestBody Turno turnoEditar){

        turnoServ.editTurno(idOriginal, turnoEditar);
        Turno turnoEditado = turnoServ.findTurno(idOriginal);

        return turnoEditado;
    }

    //5 obtener un turno en particular
    @GetMapping("/traer/{id}")
    public Turno traerTurno(@PathVariable Long id){
        return turnoServ.findTurno(id);
    }

}

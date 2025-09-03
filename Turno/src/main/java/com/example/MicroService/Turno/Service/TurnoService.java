package com.example.MicroService.Turno.Service;

import com.example.MicroService.Turno.Model.Turno;
import com.example.MicroService.Turno.Repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private ITurnoRepository repoTurno;


    @Override
    public List<Turno> getTurno() {
        return repoTurno.findAll();
    }

    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {

        //Buscar el paciente en la Api paciente
        //paciente pac = buscar en al api
        //String nombreCompletoPaciente = lo que consumo del nombre de la api

        Turno turno = new Turno();
        turno.setFecha(fecha);
        turno.setTratamiento(tratamiento);
        //turno.setNombreCompletoPaciente();

        repoTurno.save(turno);

    }

    @Override
    public void deleteTurno(Long id) {
        repoTurno.deleteById(id);
    }

    @Override
    public Turno findTurno(Long id) {
        return repoTurno.findById(id).orElse(null);
    }

    @Override
    public void editTurno(Long id, Turno turno) {
        Turno turn = this.findTurno(id);
        turn.setFecha(turno.getFecha());
        turn.setTratamiento(turno.getTratamiento());
        turn.setNombreCompletoPaciente(turno.getNombreCompletoPaciente());

        repoTurno.save(turn);
    }
}

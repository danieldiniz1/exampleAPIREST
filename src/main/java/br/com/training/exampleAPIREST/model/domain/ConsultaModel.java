package br.com.training.exampleAPIREST.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity(name = "tb_consultas")
@Data
@EqualsAndHashCode(of = "id")
public class ConsultaModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private MedicoModel medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private PacienteModel paciente;

    private LocalDateTime data;

    public static ConsultaModel valueOf(MedicoModel medico, PacienteModel paciente, LocalDateTime data){
        ConsultaModel consultaModel = new ConsultaModel();
        consultaModel.setMedico(medico);
        consultaModel.setPaciente(paciente);
        consultaModel.setData(data);
        return consultaModel;

    }
}

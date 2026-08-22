package com.java.appointment_booking.infrastructure.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java.appointment_booking.infrastructure.entity.AgendamentoEntity;

import jakarta.transaction.Transactional;

public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long> {

	AgendamentoEntity findByServicoAndDataHoraAgendamentoBetween(String servico, LocalDateTime dataHoraInicio,
			LocalDateTime dataHoraFinal);

	@Transactional
	void deleteByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);

	AgendamentoEntity findByDataHoraAgendamentoBetween(LocalDateTime dataHorainicial, LocalDateTime dataHoraFinal);
}
package com.java.appointment_booking.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.java.appointment_booking.infrastructure.entity.AgendamentoEntity;
import com.java.appointment_booking.infrastructure.repository.AgendamentoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AgendamentoService {

	private final AgendamentoRepository agendamentoRepository;

	public AgendamentoEntity salvarAgendamento(AgendamentoEntity agendamento) {
		
		LocalDateTime horaAgendamento = agendamento.getDataHoraAgendamento();
		LocalDateTime horaFim = agendamento.getDataHoraAgendamento().plusHours(1);
		
		AgendamentoEntity agendados = agendamentoRepository.findByServicoAndDataHoraAgendamentoBetween(agendamento.getServico, horaAgendamento, horaFim)
	
		if(Objects.nonNull(agendados)) {
			throw new RuntimeException("Horário já está preenchido.");
		}
		return agendamentoRepository.save(agendamento);
	
	}

	public void deletarAgendamento(LocalDateTime dataHoraAgendamento, String cliente) {

		agendamentoRepository.deleteByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);
	}

}

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

	public AgendamentoService(AgendamentoRepository agendamentoRepository) {
		this.agendamentoRepository = agendamentoRepository;
	}

	public AgendamentoEntity salvarAgendamento(AgendamentoEntity agendamento) {

		LocalDateTime horaAgendamento = agendamento.getDataHoraAgendamento();
		LocalDateTime horaFim = agendamento.getDataHoraAgendamento().plusHours(1);

		AgendamentoEntity agendados = agendamentoRepository
				.findByServicoAndDataHoraAgendamentoBetween(agendamento.getServico(), horaAgendamento, horaFim);

		if (Objects.nonNull(agendados)) {
			throw new RuntimeException("Horário já está preenchido.");
		}
		return agendamentoRepository.save(agendamento);

	}

	public void deletarAgendamento(LocalDateTime dataHoraAgendamento, String cliente) {

		agendamentoRepository.deleteByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);
	}

	public AgendamentoEntity buscarAgendamentosDia(LocalDate data) {
		LocalDateTime primeiraHoraDia = data.atStartOfDay();
		LocalDateTime horaFinalDia = data.atTime(23, 59, 59);

		return agendamentoRepository.findByDataHoraAgendamentoBetween(primeiraHoraDia, horaFinalDia);
	}

	public AgendamentoEntity alterarAgendamento(AgendamentoEntity agendamento, String cliente,
			LocalDateTime dataHoraAgendamento) {
		AgendamentoEntity agenda = agendamentoRepository.findByDataHoraAgendamentoAndCliente(dataHoraAgendamento,
				cliente);
		if (Objects.isNull(agenda)) {
			throw new RuntimeException("Horário não está preenchido.");
		}
		agendamento.setId(agenda.getId());
		return agendamentoRepository.save(agendamento);
	}
}

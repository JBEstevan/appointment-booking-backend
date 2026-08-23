package com.java.appointment_booking.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.appointment_booking.infrastructure.entity.AgendamentoEntity;
import com.java.appointment_booking.service.AgendamentoService;

import lombok.RequiredArgsConstructor;

@RestController("/agendamentos")
@RequiredArgsConstructor

public class AgendamentoController {

	private final AgendamentoService agendamentoService;

	@PostMapping
	public ResponseEntity<AgendamentoEntity> salvarAgendamento(@RequestBody AgendamentoEntity agendamento) {
		return ResponseEntity.accepted().body(agendamentoService.salvarAgendamento(agendamento));
	}

	@DeleteMapping
	public ResponseEntity<Void> deletarAgendamento(@RequestParam String cliente,
			@RequestParam LocalDateTime dataHoraAgendamento) {

		agendamentoService.deletarAgendamento(dataHoraAgendamento, cliente);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<AgendamentoEntity> buscarAgendamentosDia(@RequestParam LocalDate data) {
		return ResponseEntity.ok().body(agendamentoService.buscarAgendamentosDia(data));
	}

	@PutMapping
	public ResponseEntity<AgendamentoEntity> alterarAgendamentos(@RequestBody AgendamentoEntity agendamento,
			@RequestParam String cliente, @RequestParam LocalDateTime dataHoraAgendamento) {
		return ResponseEntity.accepted()
				.body(agendamentoService.alterarAgendamento(agendamento, cliente, dataHoraAgendamento));
	}
}

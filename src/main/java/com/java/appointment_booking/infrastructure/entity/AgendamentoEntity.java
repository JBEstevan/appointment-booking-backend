package com.java.appointment_booking.infrastructure.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agendamento")

public class AgendamentoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String servico;
	private String profissional;
	private LocalDateTime dataHoraAgendamento;
	private String cliente;
	private String telefoneCliente;
	private LocalDateTime dataInsercao = LocalDateTime.now();

	public AgendamentoEntity() {
	}

	public AgendamentoEntity(Long id, String servico, String profissional, LocalDateTime dataHoraAgendamento,
			String cliente, String telefoneCliente, LocalDateTime dataInsercao) {
		this.id = id;
		this.servico = servico;
		this.profissional = profissional;
		this.dataHoraAgendamento = dataHoraAgendamento;
		this.cliente = cliente;
		this.telefoneCliente = telefoneCliente;
		this.dataInsercao = dataInsercao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getProfissional() {
		return profissional;
	}

	public void setProfissional(String profissional) {
		this.profissional = profissional;
	}

	public LocalDateTime getDataHoraAgendamento() {
		return dataHoraAgendamento;
	}

	public void setDataHoraAgendamento(LocalDateTime dataHoraAgendamento) {
		this.dataHoraAgendamento = dataHoraAgendamento;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public LocalDateTime getDataInsercao() {
		return dataInsercao;
	}

	public void setDataInsercao(LocalDateTime dataInsercao) {
		this.dataInsercao = dataInsercao;
	}

}

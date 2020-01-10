package com.kazale.api.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.kazale.api.enums.PerfilEnum;

@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name= "nome", nullable = false)
	private String nome;
	
	@Column(name= "email", nullable = false)
	private String email;
	
	@Column(name= "cpf", nullable = false)
	private String cpf;
	
	@Column(name= "valor_hora", nullable = true)
	private BigDecimal valorhora;
	
	@Column(name= "qtd_horas_trabalho_dia", nullable = true)
	private Float qtdHorasTrabalhoDia;
	
	@Column(name= "qtd_horas_almoco_dia", nullable = true)
	private Float qtdHorasAlmoco;
	
	@Enumerated(EnumType.STRING) @Column(name = "perfil", nullable= false)
	private PerfilEnum perfil;
	
	@Column(name="data_criacao",nullable=false)
	private Date dataCriacao;
	
	@Column(name="data_atualizacao",nullable=false)
	private Date dataAtualizacao;
	
	@Column(name="senha",nullable=false)
	private String senha;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Empresa empresa;
	
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Lancamento> lancamentos;
	
	public Funcionario() {
		
	}
	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getNome() {
		return nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public BigDecimal getValorhora() {
		return valorhora;
	}


	public void setValorhora(BigDecimal valorhora) {
		this.valorhora = valorhora;
	}


	public Float getQtdHorasTrabalhoDia() {
		return qtdHorasTrabalhoDia;
	}


	public void setQtdHorasTrabalhoDia(Float qtdHorasTrabalhoDia) {
		this.qtdHorasTrabalhoDia = qtdHorasTrabalhoDia;
	}


	public Float getQtdHorasAlmoco() {
		return qtdHorasAlmoco;
	}


	public void setQtdHorasAlmoco(Float qtdHorasAlmoco) {
		this.qtdHorasAlmoco = qtdHorasAlmoco;
	}


	public PerfilEnum getPerfil() {
		return perfil;
	}


	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}


	public Date getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}


	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}


	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}


	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", valorhora="
				+ valorhora + ", qtdHorasTrabalhoDia=" + qtdHorasTrabalhoDia + ", qtdHorasAlmoco=" + qtdHorasAlmoco
				+ ", perfil=" + perfil + ", dataCriacao=" + dataCriacao + ", dataAtualizacao=" + dataAtualizacao
				+ ", senha=" + senha + ", empresa=" + empresa + "]";
	}
	
	
	
}

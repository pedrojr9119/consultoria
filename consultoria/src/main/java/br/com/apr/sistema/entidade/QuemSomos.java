package br.com.apr.sistema.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class QuemSomos implements Serializable {

	private static final long serialVersionUID = 201701071924L;

	@Id
	@GenericGenerator(name = "quem_somos_id", strategy = "increment")
	@GeneratedValue(generator = "quem_somos_id")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@NotBlank(message = "Descricao é obrigatório")
	@Column(name = "descricao", nullable = false)
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
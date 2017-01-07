package br.com.apr.sistema.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "servico_id", strategy = "increment")
	@GeneratedValue(generator = "servico_id")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@NotBlank(message = "Nome é obrigatório")
	@Column(name = "nome", nullable = false)
	private String nome;

	@NotBlank(message = "Descricao é obrigatório")
	@Column(name = "descricao", nullable = false)
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

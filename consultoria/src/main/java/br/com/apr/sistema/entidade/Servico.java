package br.com.apr.sistema.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Servico {

	@Id
	@GenericGenerator(name = "servico_id", strategy = "increment")
	@GeneratedValue(generator = "servico_id")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "nome", nullable = false, unique = false)
	@NotBlank(message = "Nome é Obrigatório")
	private String nome;

	@Column(name = "nome", nullable = false, unique = false)
	@NotBlank(message = "Descrição é Obrigatório")
	private String descricao;

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

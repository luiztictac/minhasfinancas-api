package br.com.luiztictac.minhasFinancas.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="usuario", schema = "financas") //Se eu omitir o schema ele fara procura no public do post
@Builder
@Data //já ativa todos os gets e sets e hashcode
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	
	@Id //Preciso determinar qual é o ID
	@Column(name = "id") //Posso omitir se quiser o name e propriedade
	@GeneratedValue( strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name=" nome")
	private String nome;
	
	@Column(name= "email")
	private String email;
	
	@Column(name= "senha")
	private String senha;
	
}

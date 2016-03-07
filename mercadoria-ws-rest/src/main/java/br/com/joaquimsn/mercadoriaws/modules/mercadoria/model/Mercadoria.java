package br.com.joaquimsn.mercadoriaws.modules.mercadoria.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import br.com.joaquimsn.mercadoriaws.modules.mercadoria.enums.TipoNegocioEnum;

@XmlRootElement
@XmlType(name = "Mercadoria")
@Entity
@Table(name = "mercadoria")
public class Mercadoria implements Serializable {
	private static final long serialVersionUID = -4337260964198820741L;

	@Id
	@Column(name = "id_mercadoria")
	private int idMercadoria;
	
	private String codigo;
	
	private String nome;

	private String tipo;

	@Column(name = "tipo_negocio")
	private int tipoNegocio;
	
	private double preco;

	private int quantidade;

	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Column(name = "data_manutencao")
	private Date dataManutencao;
	
	@Column(name = "ativo", columnDefinition = "BIT", length = 1)
	private boolean ativo;


	public int getIdMercadoria() {
		return this.idMercadoria;
	}

	public void setIdMercadoria(int idMercadoria) {
		this.idMercadoria = idMercadoria;
	}

	public boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataManutencao() {
		return this.dataManutencao;
	}

	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public TipoNegocioEnum getTipoNegocio() {
		return TipoNegocioEnum.getEnumByCode(this.tipoNegocio);
	}

	public void setTipoNegocio(TipoNegocioEnum tipoNegocioEnum) {
		this.tipoNegocio = tipoNegocioEnum.getCode();
	}
	
	/**
	 * A cada atualização do objeto na base a data também é atualizada
	 * @author Joaquim Neto
	 * Created on Mar 7, 2016 - 3:31:35 AM
	 */
	@PreUpdate
	public void alterarDataManutencao() {
		this.dataManutencao = new Date();
	}
	
	/**
	 * Atribui a data de manutenção, cadastro e status ativo
	 * no momento da persistencia
	 * @author Joaquim Neto
	 * Created on Mar 7, 2016 - 3:31:35 AM
	 */
	@PrePersist
	public void prePersist() {
		this.dataCadastro = new Date();
		this.dataManutencao = this.dataCadastro;
		this.ativo = true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "idMercadoria: " + getIdMercadoria() + " codigo: " + getCodigo() + " nome: " + getNome();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMercadoria;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Mercadoria other = (Mercadoria) obj;
		if (idMercadoria != other.idMercadoria) {
			return false;
		}
		return true;
	}
}
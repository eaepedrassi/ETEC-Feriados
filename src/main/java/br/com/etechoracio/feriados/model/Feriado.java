package br.com.etechoracio.feriados.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import br.com.etechoracio.feriados.dao.TipoEnum;
import java.sql.Date;
import javax.persistence.Column;


@Entity
@Table(name="FER")

public class Feriado {

	@Id
	@GeneratedValue
	@Column(name = "FER_GUID")
    private String id;

	@Column(name = "FER_TIPO")
    private TipoEnum tipo;
	
	@Column(name = "FER_DESC")
    private String desc;
	
	@Column(name = "FER_DATA")
    private Date data;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}

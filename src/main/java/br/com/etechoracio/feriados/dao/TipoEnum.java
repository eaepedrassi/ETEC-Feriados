package br.com.etechoracio.feriados.dao;

public enum TipoEnum {
	 Municipal(0),
	 Estadual(1),
	 Nacional(2);
	
	public int tipoF;
	
	TipoEnum(int tipo){
		tipoF = tipo;
	}
	
}

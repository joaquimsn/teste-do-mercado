package br.com.joaquimsn.mercadoriaws.modules.mercadoria.enums;

import java.util.ArrayList;
import java.util.List;

public enum TipoNegocioEnum {
	VENDA("Venda", 1), 
	COMPRA("Compra", 2);

	private String display;
	private int code;

	private TipoNegocioEnum(String display, int code) {
		this.display = display;
		this.code = code;
	}
	
	public static List<String> getDisplayList() {
		List<String> lista = new ArrayList<String>();
		for(TipoNegocioEnum objeto : values()) {
			lista.add(objeto.display);
		}
		return lista;
	}
	
	public static int getValueByDisplay(String display) {
		for(TipoNegocioEnum objeto : values()) {
			if(objeto.display.equals(display)) {
				return objeto.code;
			}
		}
		return 0;
	}
	
	public static String getDisplayByValue(int code) {
		for(TipoNegocioEnum objeto : values()) {
			if(objeto.code == code) {
				return objeto.display;
			}
		}
		return null;
	}
	
	public static TipoNegocioEnum getEnumByCode(int code) {
		for (TipoNegocioEnum object: values()) {
			if (object.getCode() == code) {
				return object;
			}
		}
		
		return null;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

}

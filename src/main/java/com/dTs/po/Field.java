package com.dTs.po;

public class Field {

	private String COLUMN_NAME;
	private String DATA_TYPE;
	private String DATA_LENGTH;
	private String NULLABLE;
	private String COMMENTS;

	public String getCOLUMN_NAME() {
		return COLUMN_NAME;
	}

	public void setCOLUMN_NAME(String cOLUMN_NAME) {
		COLUMN_NAME = cOLUMN_NAME;
	}

	public String getDATA_TYPE() {
		return DATA_TYPE;
	}

	public void setDATA_TYPE(String dATA_TYPE) {
		DATA_TYPE = dATA_TYPE;
	}

	public String getDATA_LENGTH() {
		return DATA_LENGTH;
	}

	public void setDATA_LENGTH(String dATA_LENGTH) {
		DATA_LENGTH = dATA_LENGTH;
	}

	public String getNULLABLE() {
		return NULLABLE;
	}

	public void setNULLABLE(String nULLABLE) {
		NULLABLE = nULLABLE;
	}

	public String getCOMMENTS() {
		return COMMENTS;
	}

	public void setCOMMENTS(String cOMMENTS) {
		COMMENTS = cOMMENTS;
	}

}

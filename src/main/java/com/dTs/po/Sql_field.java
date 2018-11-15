package com.dTs.po;

public class Sql_field {

	private String name;
	private String shortTableName;
	private String shortName;

	public String getName() {
		return name;
	}

	public void setName(String field) {

		boolean hasShortName = false;
		String shortNameFlag = null;
		if (field.contains(" AS ")) {
			hasShortName = true;
			shortNameFlag = " AS ";
		} else if (field.contains(" ")) {
			hasShortName = true;
			shortNameFlag = " ";
		}

		if (hasShortName) {
			String[] split = field.split(shortNameFlag);
			String fieldname = split[0];
			String shortName = split[1];
			this.shortName = shortName;
			if (fieldname.contains(".")) {
				String[] split2 = fieldname.split("\\.");
				this.shortTableName = split2[0];
				this.name = split2[1];
			}
			return;
		}
		
		if(field.contains(".")){
			String[] split = field.split("\\.");
			this.shortTableName = split[0];
			this.name = split[1];
			return;
		}
		
		this.name = field;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getShortTableName() {
		return shortTableName;
	}

	public void setShortTableName(String shortTableName) {
		this.shortTableName = shortTableName;
	}

}

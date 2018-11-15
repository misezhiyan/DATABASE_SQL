package util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ExcelConfig {

	private Map<Integer, String> configMap = new HashMap<Integer, String>();
	public String READOUTPATH;
	public String READINPATH;
	public String OUTFILENAME;

	public void put(String key, String value) {
		Integer key_int = Integer.parseInt(key);
		this.configMap.put(key_int, value);
	}

	public void setConfig(Properties properties) {
		Set<Object> keySet = properties.keySet();
		Iterator<Object> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			String value = properties.getProperty(key);
			Integer key_int = Integer.parseInt(key);
			this.configMap.put(key_int, value);
		}
	}

	public void setPathConfig(Properties properties_path) {

		this.READINPATH = (String) properties_path.get("readInPath");
		this.READOUTPATH = (String) properties_path.get("readOutPath");
		this.OUTFILENAME = (String) properties_path.get("outFileName");
	}

	public Map<Integer, String> getConfig() {

		return this.configMap;
	}

}

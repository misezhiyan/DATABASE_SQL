package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.fastjson.JSONObject;
import com.dTs.StringUtil;

public class ExcelUtil {

	private static ExcelConfig config = new ExcelConfig();

	public static void main(String[] args) throws Exception {

		// 当前类路径
		URL resource = ExcelUtil.class.getResource("");
		String path = resource.toString().substring(6);
		// 获取配置文件
		Properties properties = new Properties();
		properties.load(new FileInputStream(path + "config.properties"));
		config.setConfig(properties);

		// 获取路径配置文件
		Properties properties_path = new Properties();
		properties_path.load(new FileInputStream(path + "pathConfig.properties"));
		config.setPathConfig(properties_path);

		boolean success = writeToExcel(config.READINPATH, config.READOUTPATH, config.OUTFILENAME);
		System.out.println(success);
	}

	public static boolean writeToExcel(String url_in, String url_out, String outFileName) throws Exception {

		File pack = new File(url_in);
		if (!pack.exists() || pack.isFile())
			return false;

		File[] subFiles = pack.listFiles();

		List<JSONObject> list = new ArrayList<JSONObject>();
		for (File fileTmp : subFiles) {
			JSONObject json = paseToJson(fileTmp);
			list.add(json);
		}

		// writInNewFile(url_out, "json", "xls");
		Workbook workbook = new HSSFWorkbook();
		Sheet createSheet = workbook.createSheet();
		// 首行标题行
		Row title = createSheet.createRow(0);
		matchTitle(title);
		for (int i = 0; i < list.size(); i++) {

			JSONObject json = list.get(i);

			Row content_row = createSheet.createRow(i + 1);
			matchContent(content_row, json);
		}

		String fullFileName = outFileName + "." + "xls";
		writInNewFile(workbook, url_out, fullFileName);

		return true;
	}

	private static void matchContent(Row title, JSONObject json) {

		Map<Integer, String> config_map = config.getConfig();
		Set<Integer> keySet = config_map.keySet();
		Iterator<Integer> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			Integer positon = iterator.next();
			String value_name = config_map.get(positon);
			Cell cell = title.createCell(positon);
			String value = (String) json.get(value_name);
			cell.setCellValue(value);
		}
	}

	private static void matchTitle(Row title) {
		Map<Integer, String> config_map = config.getConfig();
		Set<Integer> keySet = config_map.keySet();
		Iterator<Integer> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			Integer positon = iterator.next();
			String value = config_map.get(positon);
			Cell cell = title.createCell(positon);
			cell.setCellValue(value);
		}
	}

	private static void writInNewFile(String url_out, String fileName, String fileType) throws Exception {

		Workbook workbook = null;
		if ("xls".equals(fileType))
			workbook = new HSSFWorkbook();// xls
		else if ("xlsx".equals(fileType))
			workbook = new XSSFWorkbook();// xlsx

		String fullFileName = fileName + "." + fileType;

		writInNewFile(workbook, url_out, fullFileName);

	}

	private static void writInNewFile(Workbook workbook, String url_out, String fullFileName) throws Exception {

		File pack_out = new File(url_out);
		if (!pack_out.exists())
			pack_out.mkdirs();
		File file_out = new File(url_out + "\\" + fullFileName);
		OutputStream output = new FileOutputStream(file_out);
		workbook.write(output);
	}

	private static JSONObject paseToJson(File file) throws Exception {

		String content = fileContent(file);

		JSONObject json = JSONObject.parseObject(content);

		return json;
	}

	private static String fileContent(File file) throws Exception {

		String fileCode = FileUtil.getFileCode(file);
		if (StringUtil.isEmpty(fileCode))
			fileCode = "UTF-8";

		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		String result = "";
		String countent;
		while ((countent = in.readLine()) != null) {
			result += countent + "\r\n";
		}
		in.close();

		return result;
	}
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SolveOnLine {
	public static void main(String[] args) {

		// intoMap();
		// intoList();

		Map<String, String> map = getMapArr();
		List<String> list = getList();
		getFromParams(map, list);
	}

	private static void getFromParams(Map<String, String> map, List<String> list) {
		while (true) {
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println();
			String allLine = "";
			Scanner sn = new Scanner(System.in);
			while (!sn.hasNextInt()) {
				String line = sn.nextLine();
				line = line.trim();
				if (isEmpyt(line))
					continue;
				allLine += line;
			}

			String[] lines = allLine.split(",");
			for (String line : lines) {

				if (line.startsWith("arr[i][")) {
					line = line.replace("arr[i][", "").replace("]", "").trim();
					String result = map.get(line);
					System.out.println(result);
				} else if (line.startsWith("obj[")) {
					line = line.replace("obj[", "").replace("]", "");
					int parseInt = Integer.parseInt(line);
					String result = list.get(parseInt);
					System.out.println(result);
				} else {
					System.out.println("没有匹配到参数:" + line);
				}
			}

		}
	}

	private static List<String> getList() {
		List<String> paramList = new ArrayList<String>();
		paramList.add("customer_name");
		paramList.add("vip_type");
		paramList.add("vip_no");
		paramList.add("country");
		paramList.add("province");
		paramList.add("city_name");
		paramList.add("regoin_id");
		paramList.add("area_id");
		paramList.add("road_id");
		paramList.add("postcode");
		paramList.add("address");
		paramList.add("area_code1");
		paramList.add("home_telephone");
		paramList.add("office_telephone");
		paramList.add("mobile_phone");
		paramList.add("email");
		paramList.add("branch_id");
		paramList.add("customer_id");
		paramList.add("customer_id");
		paramList.add("applytype");
		paramList.add("service_class");
		paramList.add("fedback_mode");
		paramList.add("fedback_time");
		paramList.add("emap_id");
		paramList.add("i_remark");
		paramList.add("ss_branch_id");
		paramList.add("yesorno");
		paramList.add("zx_disat_id");
		paramList.add("zx_disat_name");
		paramList.add("tree_solution_1");
		paramList.add("part_info_1");
		paramList.add("fault_trail");
		paramList.add("material_info1");
		paramList.add("fault_code");
		paramList.add("code_solution");
		return paramList;
	}

	private static void intoList() {

		Scanner sn = new Scanner(System.in);
		String allLine = "";
		while (!sn.hasNextInt()) {
			String line = sn.nextLine();
			if (isEmpyt(line))
				continue;
			allLine += line.trim();
		}

		String[] splits = allLine.split(",");
		for (String split : splits) {
			System.out.println("paramList.add(\"" + split + "\");");
		}

	}

	private static Map<String, String> getMapArr() {

		Map<String, String> params = new HashMap<String, String>();
		params.put("0", "PRODUCT_BIG_ID");
		params.put("1", "PRODTYPE_ID");
		params.put("2", "PRODUCT_MID_ID");
		params.put("3", "FAULT_DESC");
		params.put("4", "SERVICE_TYPE_ID");
		params.put("5", "INPUT_TYPE");
		params.put("6", "REQUIRE_SERVICE_DATE");
		params.put("7", "REQUIRE_DESC");
		params.put("8", "INFO_CLASS");
		params.put("44", "TS_REASON_CODE");
		params.put("45", "TS_REASON_NAME");
		params.put("9", "IMPORTANT_LEVEL");
		params.put("10", "URGENT_LEVEL");
		params.put("11", "BRAND_ID");
		params.put("12", "BRAND_NAME");
		params.put("13", "APPEAL_WO_ID");
		params.put("14", "PRODUCT_NO");
		params.put("15", "BUY_DATE");
		params.put("16", "DEALER_ID");
		params.put("17", "PRICE");
		params.put("18", "DEALER_NAME");
		params.put("19", "zx_mode");
		params.put("20", "prod_flag");
		params.put("21", "PRODUCT_MID_NAME");
		params.put("22", "MODAL_NAME");
		params.put("23", "PROD_ROWID");
		params.put("24", "bill_flag");
		params.put("25", "zx_type");
		params.put("26", "service_mode");
		params.put("27", "is_project");
		params.put("28", "project_count");
		params.put("29", "by_type");
		params.put("30", "by_obj");
		params.put("31", "ts_obj");
		params.put("32", "belong_branch");
		params.put("33", "prod_remark");
		params.put("34", "project_corp");
		params.put("35", "BOOKING_END_DATE");
		params.put("36", "BOOKING_RANGE");
		params.put("37", "project_total");
		params.put("38", "zx_type2");
		params.put("39", "zx_type3");
		params.put("40", "zx_type4");
		params.put("41", "project_num");
		params.put("42", "is_mountWX");
		params.put("43", "manager_code");
		params.put("48", "zx_assign_auto");
		params.put("49", "market_level");
		params.put("50", "online_type_id");
		params.put("51", "online_type_name");
		params.put("52", "i_if_fifteen");
		params.put("53", "attribute15");
		params.put("54", "wb_row_id");
		params.put("55", "emp_a_id");
		params.put("56", "commu_result");
		return params;
	}

	private static void intoMap() {
		Scanner sn = new Scanner(System.in);
		while (!sn.hasNextInt()) {
			String line = sn.nextLine();

			if (isEmpyt(line))
				continue;
			line = line.trim();

			String num = line.split("array\\[i\\]\\[")[1].split("\\] = \\(String\\)requestUtil.getParameter\\(\"")[0];

			String name = line.split("array\\[i\\]\\[")[1].split("\\] = \\(String\\)requestUtil.getParameter\\(\"")[1];
			if (line.contains("\"+i);")) {
				name = name.split("\"\\+i\\);")[0];
			} else {
				name = name.split("\"\\);")[0];
			}
			String comment = line.split("array\\[i\\]\\[")[1].split("\\] = \\(String\\)requestUtil.getParameter\\(\"")[1];
			if (line.contains("\"+i);")) {
				// comment = comment.split("\"\\+i\\);")[1];
			} else {
				String[] commentarr = comment.split("\"\\);");
				if (commentarr.length == 1) {
					comment = "";
				} else {
					comment = commentarr[1];
				}
			}

			System.out.println("params.put(\"" + num + "\", \"" + name + "\");");

		}
	}

	private static boolean isEmpyt(String line) {
		return null == line || "".equals(line.trim());
	}

}

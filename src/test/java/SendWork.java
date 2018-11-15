import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SendWork {
	public static void main(String[] args) {

		// 换行
		// changeX();
		// intoMap();
		// intoList();

		Map<String, String> map = getMapArr();
		List<String> list = getList();
		getFromParams(map, list);

	}

	private static void changeX() {

		Scanner sn = new Scanner(System.in);
		while (!sn.hasNextInt()) {
			String line = sn.nextLine();
			String[] lines = line.split(",");
			for (String temp : lines)
				System.out.println(temp.trim());

		}

	}

	private static void getFromParams(Map<String, String> map, List<String> list) {
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println();
		// System.out.println("选择map 请选1; 选择list 请选2");
		Scanner sn = new Scanner(System.in);
		while (!sn.hasNextInt()) {
			String line = sn.nextLine();
			line = line.trim();
			if (isEmpyt(line))
				continue;
			if (line.startsWith("arr[i][")) {
				// System.out.println("请输入匹配字段名:");
				// Scanner sn2 = new Scanner(System.in);
				// String line = sn2.nextLine();

				line = line.replace("arr[i][", "").replace("]", "").trim();

				String result = map.get(line);
				System.out.println(result);
			} else if (line.startsWith("obj[")) {
				// System.out.println("请输入要查找的数");
				// Scanner sn2 = new Scanner(System.in);
				// int nextInt2 = sn2.nextInt();
				// String line = sn2.nextLine();
				line = line.replace("obj[", "").replace("]", "");
				int parseInt = Integer.parseInt(line);
				String result = list.get(parseInt);
				System.out.println(result);
			} else {
				System.out.println("没有匹配到参数:" + line);
			}
		}
		// 自调
		// getFromParams(map, list);
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
		while (!sn.hasNextInt()) {
			String line = sn.nextLine();
			if (isEmpyt(line))
				continue;
			System.out.println("paramList.add(\"" + line + "\")");
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
		params.put("57", "i_online_flag");
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
			String comment = line.split("array\\[i\\]\\[")[1]
					.split("\\] = \\(String\\)requestUtil.getParameter\\(\"")[1];
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
			// ToMap toMap= new ToMap();
			// toMap.num = num;
			// toMap.name = name;
			// toMap.comment = comment;

			System.out.println("params.put(\"" + num + "\", \"" + name + "\");");

		}
	}

	private static boolean isEmpyt(String line) {
		return null == line || "".equals(line.trim());
	}

	public static Map<String, String> getUrlMap() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("PRODUCT_BIG_ID0", "KT");
		params.put("PRODUCT_MID_ID0", "KT01");
		params.put("PRODUCT_MID_NAME0", "家用空调");
		params.put("PRODTYPE_ID0", "2008042300000006");
		params.put("MODAL_NAME0", "KFR-35GW/97FZBP");
		params.put("BRAND_ID0", "HXBRAND_NAME0");
		params.put("FAULT_DESC0", "123");
		params.put("SERVICE_TYPE_ID0", "ZX");
		params.put("INPUT_TYPE0", "1");
		params.put("REQUIRE_SERVICE_DATE0", "2018-06-19");
		params.put("BOOKING_END_DATE0", "2018-06-19");
		params.put("BOOKING_RANGE0", "");
		params.put("REQUIRE_DESC0", "");
		params.put("INFO_CLASS0", "");
		params.put("TS_REASON_CODE0", "");
		params.put("TS_REASON_NAME0", "请选择");
		params.put("IMPORTANT_LEVEL0", "");
		params.put("ts_obj0", "");
		params.put("URGENT_LEVEL0", "0APPEAL_WO_ID0");
		params.put("PRODUCT_NO0", "888888888");
		params.put("BUY_DATE0", "2013-04-01");
		params.put("DEALER_ID0", "");
		params.put("DEALER_NAME0", "");
		params.put("PRICE0", "0");
		params.put("PROD_ROWID0", "PRD1304249534974");
		params.put("prod_flag0", "1");
		params.put("bill_flag0", "1");
		params.put("zx_type0", "");
		params.put("zx_type20", "");
		params.put("zx_type30", "");
		params.put("zx_type40", "");
		params.put("zx_mode0", "1");
		params.put("online_type_id0", "");
		params.put("online_type_name0", "请选择");
		params.put("service_mode0", "KTZX01");
		params.put("is_project0", "0");
		params.put("project_count0", "");
		params.put("by_type0", "");
		params.put("by_obj0", "");
		params.put("belong_branch0", "H-BD-532-00");
		params.put("market_level0", "二类地区");
		params.put("prod_remark0", "");
		params.put("project_corp0", "");
		params.put("project_total0", "");
		params.put("project_num0", "");
		params.put("zx_assign_auto0", "0");
		params.put("i_if_fifteen0", "0");
		params.put("attribute150", "");
		params.put("customer_id", "USR1304170580296");
		params.put("customer_name", "史珊珊测试");
		params.put("vip_type", "1");
		params.put("country", "中国");
		params.put("province", "山东省");
		params.put("city_name", "青岛市");
		params.put("postcode", "266300");
		params.put("regoin_id", "370281000");
		params.put("road_id", "370281680");

		params.put("address", "中国山东省青岛市胶州市水寨七公");

		return params;
	}

}

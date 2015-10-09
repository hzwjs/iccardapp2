package com.iccardapp.util;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jxls.transformer.XLSTransformer;

import com.iccardapp.entity.ReportEntity;

public class ExcelUtil {
	/**
	 * 根据模板生成Excel文件.
	 * 
	 * @param templateFileName
	 *            模板文件.
	 * @param list
	 *            模板中存放的数据.
	 * @param report
	 * 			   存放打印信息，如果打印时间等
	 * @param resultFileName
	 *            生成的文件.
	 */
	public void createExcel(String templateFileName, List<?> list, ReportEntity report, String resultFileName) {
		try {
			// 创建XLSTransformer对象
			XLSTransformer transformer = new XLSTransformer();

			// 获取java项目编译后根路径
			URL url = this.getClass().getClassLoader().getResource("");
			File file = new File(url.getFile());
			String path = file.getPath();
			// 得到模板文件路径
			String srcFilePath = path + File.separator + "template" + File.separator + templateFileName;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", list);
			map.put("report", report);
			String destFilePath = path + File.separator + "download" + File.separator + resultFileName;

			// 生成Excel文件
			transformer.transformXLS(srcFilePath, map, destFilePath);
		} catch (Exception e) {
			throw new RuntimeException("error happens...", e);
		}
	}
}

package com.driverco.dyd.pages;

public class HTMLCommon {
	public static String getHeader() {
		StringBuilder html = new StringBuilder();
		html.append(
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
		html.append("<html>");
		html.append("<head>");
		html.append("  <link rel=\"stylesheet\" type=\"text/css\" href=\"css/dyd.css\">");
		html.append("  <title>DyD by Driverco</title>");
		html.append("  <script src=\"https://kit.fontawesome.com/360d273b9f.js\" crossorigin=\"anonymous\"></script>");
		html.append("  <script src=\"js/jquery-3.5.1.min.js\" type=\"text/javascript\"></script>");
		html.append("</head>");
		html.append("<body>");
		html.append("  <div id='header' >");
		html.append(
				"    <div id='headerTitle'><i class=\"fab fa-fort-awesome-alt\"></i>DyD in Commands by WRC</div>");
		html.append("  </div>");

		return html.toString();
	}

	public static String getFooter() {
		StringBuilder html = new StringBuilder();
		html.append("  </div>");
		html.append("</body>");
		html.append("</html>");
		return html.toString();
	}

	public static String getStartPage() {
		StringBuilder html = new StringBuilder();
		html.append("  <div id='appDescription' >");
		html.append("    App Created to simulate basic gameplay of a Dungeons and Dragons in commands");
		html.append("    <br />Created by <a href='mailto:driverco@gmail.com'>Wilmer Rodriguez C.</a>");
		html.append("    <br />Electiva 3");
		html.append("    <br />Universidad Antonio Nariño - 2020");
		html.append("  </div>");
		html.append("  <a href='Game'><div id='buttonStart' > Start</div>");
		html.append("  </a>");
		return html.toString();
	}

}

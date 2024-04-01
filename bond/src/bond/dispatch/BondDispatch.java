package bond.dispatch;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import bond.controller.*;

/**
 * 이 클래스는 .bond로 들어오는 요청을 처리할 서블릿 클래스
 * @author	전은석
 * @since	2024.03.29
 * @version	v.1.0
 * 			2024.03.29 - 클래스 제작 [ 담당자: 전은석 ]
 */
@WebServlet("*.bnd")
public class BondDispatch extends HttpServlet {
	private HashMap<String, BondInter> map;
	
	public void init(ServletConfig config) throws ServletException {
		// 할일
		// properties 준비
		Properties prop = new Properties();
		
		FileInputStream fin = null;
		try {
			String path = this.getClass().getResource("/bond").getPath();
			path = path + "/resources/bond.properties";
			fin = new FileInputStream(path);
			prop.load(fin);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch(Exception e) {}
		}
		
		Enumeration<String> en = (Enumeration) prop.keys();
		map = new HashMap<String, BondInter>();
		
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			try {
				BondInter obj = (BondInter) Class.forName(prop.getProperty(key)).newInstance();
				map.put(key, obj);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String full = req.getRequestURI();
		String domain = req.getContextPath();
		String sreq = full.substring(domain.length());
		
//		System.out.println("################## " + sreq);
		
		resp.setCharacterEncoding("UTF-8");
		req.setAttribute("METHOD", "FORWARD");
		BondInter respClass = map.get(sreq);
		String view = respClass.exec(req, resp);
		
		String respMethod = (String) req.getAttribute("METHOD");
		
		if(respMethod.equals("AJAX")) {
			PrintWriter pw = resp.getWriter();
			pw.print(view);
		} else if(respMethod.equals("REDIRECT")) {
			resp.sendRedirect(view);
		} else if(respMethod.equals("FORWARD")) {
			String prefix = "/WEB-INF/views/";
			String suffix = ".jsp";
			RequestDispatcher rd = req.getRequestDispatcher(prefix + view + suffix);
			rd.forward(req, resp);
		}
	}

}

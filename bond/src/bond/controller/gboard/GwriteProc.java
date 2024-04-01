package bond.controller.gboard;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import bond.controller.*;
import bond.dao.*;

public class GwriteProc implements BondInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 뷰
		String view = "/gboard/gboard.bnd";
		// 응답방식
//		req.setAttribute("isRedirect", true);
		req.setAttribute("METHOD", "REDIRECT");
		
		// 파라미터 꺼내고
		String id = req.getParameter("id");
		String body = req.getParameter("body");
		
		// 데이터베이스 작업
		GboardDao gDao = new GboardDao();
		int cnt = gDao.addGboard(id, body);
		
		String msg = "?msg=OK";
		if(cnt == 1) {
			// 글 등록에 성공한 경우
			msg = "?msg=OK";
		} else {
			// 글 등록에 실패한 경우
			msg = "?msg=NO";
		}
		return view + msg;
	}

}

package bond.controller.gboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bond.controller.BondInter;

public class Gboard implements BondInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 뷰
		String view = "gboard/gboard";
		
		// 할일
		// 세션 검사
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			// 
		}
		
		// 게시글 리스트 꺼내오기
		
		
		return view;
	}

}

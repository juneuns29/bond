package bond.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bond.controller.*;
import bond.dao.*;
import bond.vo.*;

public class LoginProc implements BondInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("METHOD", "REDIRECT");
		String view = "/main.bnd";
		
		if(req.getSession().getAttribute("SID") != null) {
			return view;
		}
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		
		MemberDao mDao = new MemberDao();
		int cnt = mDao.getLogin(vo);
		
		if(cnt != 1) {
			return "/member/login.bnd";
		} else {
			req.getSession().setAttribute("SID", id);
		}
		
		return view;
	}

}

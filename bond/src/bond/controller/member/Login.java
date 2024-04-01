package bond.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bond.controller.BondInter;

public class Login implements BondInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "member/login";
		
		if(req.getSession().getAttribute("SID") != null) {
			req.setAttribute("METHOD", "REDIRECT");
			return "/main.bnd";
		}
		return view;
	}

}

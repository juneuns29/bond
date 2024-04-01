package bond.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bond.controller.BondInter;

public class Join implements BondInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("SID") != null) {
			req.setAttribute("METHOD", "REDIRECT");
			return "/main.bnd";
		}
		
		return "member/join";
	}

}

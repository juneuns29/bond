package bond.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bond.controller.BondInter;

public class LogoutProc implements BondInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("METHOD", "REDIRECT");
		String view = "/main.bnd";
		if(req.getSession().getAttribute("SID") == null) {
			return view;
		}
		req.getSession().removeAttribute("SID");
		return view;
	}

}

package configuration;

import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

import BO.UserBO;
import modal.User;

@WebFilter("/*")
public class AdminFilter implements Filter {
	private static final List<String> WHITELIST = Arrays.asList("/auth", "/img/", "/js/", "/assets/", "/home");
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		String path = req.getRequestURI().substring(req.getContextPath().length());
		
		for(String allowed:WHITELIST) {
			if(path.startsWith(allowed)) {
				chain.doFilter(req, res);
				return;
			}
		}
		
		if(session.getAttribute("userLogin")!=null) {
			chain.doFilter(req, res);
			return;
		}
		
//		UserBO userBO = new UserBO();
//
//		User user = (User) session.getAttribute("userLogin");
//		if (user != null) {
//			chain.doFilter(req, res);
//			return;
//		}

//		// Nếu chưa có, kiểm tra cookie
//		Cookie[] cookies = req.getCookies();
//		String cookieSessionId = null;
//
//		if (cookies != null) {
//			for (Cookie c : cookies) {
//				if ("JSESSIONIDUSER".equals(c.getName())) { // dùng cookie riêng
//					cookieSessionId = c.getValue();
//					break;
//				}
//			}
//		}
//
//		if (cookieSessionId != null) {
//			User userFromDb = userBO.getUserBySessionId(cookieSessionId);
//
//			if (userFromDb != null && userFromDb.getSessionExpire().isAfter(Instant.now())) {
//				session.setAttribute("userLogin", userFromDb);
//				chain.doFilter(req, res);
//				return;
//			}
//		}

		// Không có session hoặc cookie hợp lệ → bắt login lại
		res.sendRedirect(req.getContextPath() + "/auth?action=login");
	}
}

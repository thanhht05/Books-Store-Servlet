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
	private static final List<String> WHITELIST = Arrays.asList("/login", "/register", "/img/", "/js/", "/assets/",
			"/home", "/accessDeniedController");

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		String path = req.getRequestURI().substring(req.getContextPath().length());

		for (String allowed : WHITELIST) {
			if (path.startsWith(allowed)) {
				chain.doFilter(req, res);
				return;
			}
		}

		User user = (User) session.getAttribute("userLogin");
		if (user == null) {
			// Chưa login
			res.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		//  Kiểm tra quyền admin cho đường dẫn /admin/**
		if (path.startsWith("/admin") && !user.getRole().getName().toLowerCase().equals("admin")) {
			res.sendRedirect(req.getContextPath() + "/AccessDeniedController");
			return;
		}
        chain.doFilter(req, res);


		
		
	}
}

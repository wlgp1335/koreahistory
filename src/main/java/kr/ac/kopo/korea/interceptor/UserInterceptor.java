package kr.ac.kopo.korea.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.kopo.korea.model.Member;

/*servlet-context와 연관*/
public class UserInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//요청된 session값을 HttpSession의 session에 저장
		HttpSession session = request.getSession();
		
		//model에 정의된 값이 저장되니까 Import
		Member member = (Member) session.getAttribute("member");
		
		if(member != null) {
			System.out.println("UserInterceptor:TRUE");
		//true : 문제가 없으면 정보 전달, false : 문제가 있으면 정보 차단
			return true;
		}
		
		//uri값의 앞부분 저장
		String query = request.getQueryString();
		
		//서버 Session에 들어간 페이지의 url를 저장, query이 null이면 앞에 아니면 뒤 :삼항연산자      
		session.setAttribute("target_url", request.getRequestURI() + (query != null ? "?" + query : ""));
		
		
		System.out.println("UserInterceptor:FALSE");
		
		//응답을 login창으로
		response.sendRedirect("/login");
		
		return false;                                                               
	}

}

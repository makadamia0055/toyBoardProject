package com.ppl.toyboard.root.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ppl.toyboard.root.dto.AuthenticateUser;
import com.ppl.toyboard.root.dto.LoginUserDTO;
import com.ppl.toyboard.root.dto.UserVerifyResponseDTO;
import com.ppl.toyboard.root.service.UserService;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequiredArgsConstructor
@Component
public class VerifyUserFilter implements Filter {
    public static final String AUTHENTICATE_USER = "authenticateUser";
    
//  Jackson 라이브러리 오브젝트 매핑을 해주는데, 리퀘스트에서 Attribute 형태로 들어오는 데이터를 매핑해주는
    private ObjectMapper objectMapper;
    
    private UserService userService;
    
    
    // Component와 RequireArgsConstructor가 있으면 Autowired가 없어도 자동 DI된다고 함. 
    @Autowired
    VerifyUserFilter(ObjectMapper objectMapper, UserService userService){
    	this.objectMapper = objectMapper;
    	this.userService = userService;
    }
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 메소드를 추출하기 위한 캐스팅
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		// Post일때만 필터가 작동함.
		if((httpServletRequest.getMethod().equals("POST"))) {
			try {
				// 오브젝트 매핑
				LoginUserDTO loginUserDto = new LoginUserDTO();
				String id = (String)httpServletRequest.getAttribute("username");
				String pw = (String)httpServletRequest.getAttribute("password");
				System.out.println(id+pw);
				loginUserDto.setUs_id(id);
				loginUserDto.setUs_pw(pw);

				
				//LoginUserDTO loginUserDto = objectMapper.readValue(request.getReader(), LoginUserDTO.class);
				// Login을 위한 DTO -> verify를 위한 DTO -> 인증완료를 알리는 User DTO를 넘기는 과정
				UserVerifyResponseDTO verifyResponse = userService.checkUser(loginUserDto);
				if(verifyResponse.isVaild()) {
					request.setAttribute(AUTHENTICATE_USER, new AuthenticateUser(loginUserDto.getUs_id(), verifyResponse.getUs_nickname(), verifyResponse.getUser_Auth()));
				} else {
					throw new IllegalArgumentException();
				}
			}catch(Exception e) {
				 log.error("Fail User Verify");
				 e.printStackTrace();
	             HttpServletResponse httpServletResponse = (HttpServletResponse) response;
	             httpServletResponse.sendError(HttpStatus.BAD_REQUEST.value());
			}
		}
		chain.doFilter(request, response);
	

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}

package com.ohgiraffers.chap02securityjwt.interceptor;

import com.ohgiraffers.chap02securityjwt.common.AuthConstants;
import com.ohgiraffers.chap02securityjwt.common.utils.TokenUtiles;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public class JwtTokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String header = request.getHeader(AuthConstants.AUTH_HEADER);
        String token = TokenUtiles.splitHeader(header);

        if(token != null) {
            if(TokenUtiles.isValidToken(token)){
                return true;
            }else{
                throw new RemoteException("token이 만료되었습니다.");
            }
        }else{
            throw new RemoteException("token정보가 없습니다.")
        }
    }
}

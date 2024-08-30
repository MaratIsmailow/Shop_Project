package ait.shop.security.filter;

import ait.shop.security.AuthInfo;
import ait.shop.security.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;


@Component
public class TokenFilter extends GenericFilterBean {

    private final TokenService tokenService;

    public TokenFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    /*
    1. Извлечь токен из запроса
    2. Проверка валидности токена
    3. Авторизация пользователя (добавить в SecurityContext)
    4. Продолжить цепочку фильтров
     */

    // Authorization: Bearer <token>

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, java.io.IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String token = getTokenFromRequest(httpServletRequest);

        if (token != null && tokenService.validateAccessToken(token)) {
            // Извлекаем информацию о пользователе из токена
            Claims claims = tokenService.getAccessClaims(token);
            AuthInfo authInfo = tokenService.mapClaimsToAuthInfo(claims);

            //Установить пользователя как аутентифицированного
            authInfo.setAuthenticated(true);

            // Помещаю объект AuthInfo(Authentication) в SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authInfo);
        }

        // Отправляем запрос в следующий фильтр цепочки
        filterChain.doFilter(servletRequest, servletResponse);

    }

    // "Bearer 5gf5t656ytjhtjteyjety5"
    private String getTokenFromRequest(HttpServletRequest request) {
        // Извлекаем заголовок Authorization
        String bearerToken = request.getHeader("Authorization");

        // Проверяем, что заголовок не пустой и начинается с префикса "Bearer "
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            // вытащить то, что в строке после префикса
            return bearerToken.substring(7);
        }

        // Если заголовок пустой или не начинается с префикса "Bearer ", вернем null.
        return null;
    }
}
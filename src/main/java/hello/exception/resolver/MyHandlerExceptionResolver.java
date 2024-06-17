package hello.exception.resolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.ScriptAssert;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        log.info("call resolver", ex);

        // 예외 처리 : IllegalArgumentException 발생 시 400 ERROR 를 발생
        try {
            if (ex instanceof IllegalArgumentException) {
                log.info("IllegalArgumentException resolver to 400");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage()); // 오류를 변경 (SC_BAD_REQUEST : 400)
                return new ModelAndView(); // 정상상태로 리턴 (ModelAndView 를 통하여 예외를 먹어버린다)
            }

        } catch(Exception e) {
            log.error("resolver ex", e);
        }
        return null;
    }
}

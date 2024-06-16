package hello.exception.sevlet;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Slf4j
@Controller
public class ServletExController {

    @GetMapping("/error-ex")
    public void errorEx() {
        // RuntimeException : server 500 error
        throw new RuntimeException("예외 발생!");
    }

    // 실제로 예외가 발생하는 것은 아니다.
    // WAS 에서 response.sendError 기록 확인
    @GetMapping("/error-404") // 발생하는 error(404) 페이지를 개발자가 html 파일과 연결하여 정의 할 수 있다.
    public void error404(HttpServletResponse response) throws IOException  {
        response.sendError(404, "404 오류!"); // 에러메세지를 html 페이지에 출력
    }

    @GetMapping("/error-400") // 발생하는 error(400) 페이지를 개발자가 html 파일과 연결하여 정의 할 수 있다.
    public void error400(HttpServletResponse response) throws IOException  {
        response.sendError(400, "400 오류!"); // 에러메세지를 html 페이지에 출력
    }

    @GetMapping("/error-500")
    public void error500(HttpServletResponse response) throws IOException {
        response.sendError(500, "500 오류!");
    }
}

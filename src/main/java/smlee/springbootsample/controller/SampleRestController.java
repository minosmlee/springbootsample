package smlee.springbootsample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;

// @Controller의 경우 view 를 리턴하기 위한 것으로 객체나 문자열을 리턴하려면 @ResponseBody를 매서드에 추가해야한다.
// 하지만 @RestController를 사용할 경우 @ResponseBody 를 생략해도 자동으로 문자열이나 json 객체를 응답을 준다.
@RestController
public class SampleRestController {

    // 문자열을 리턴하는 경우
    @GetMapping("string")
    public String string() {
        return "String returned";
    }

    @GetMapping("object")
    public SampleObject object() {
        SampleObject object = new SampleObject();
        object.setMemVar("Object Returned");
        return object;
    }

    @Getter
    @Setter
    static class SampleObject {
        private String memVar;
    }
}

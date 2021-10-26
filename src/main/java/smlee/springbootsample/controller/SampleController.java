package smlee.springbootsample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import smlee.springbootsample.service.SampleService;

@Controller // @Controller, @Service, @Repository와 같은 어노테이션은 내부적으로 @Component 어노테이션을 내장하고 있어서 자동으로 Bean 객체로 등록된다.
@RequiredArgsConstructor
public class SampleController {

    private final SampleService service;

    // 아래의 코드가 생성자 방식의 Bean 주입이다. @RequiredArgsConstructor를 사용하면 아래 코드를 생략 가능하다.
    // @Autowired
    // public SampleController(SampleService service) {
    //     this.service = service;
    // }

    // Template 하위의 html 파일을 리턴하는 경우
    @GetMapping("templateHtml")
    public String templateHtml(Model model) {
        model.addAttribute("name", "templateHtml");
        return "templateHtml";
    }

    // Template 하위의 html 파일을 리턴하는 경우 + Request Parameter 전달
    @GetMapping("templateHtmlWithParam")
    public String templateHtmlWithParam(@RequestParam("requestParam") String requestParam, Model model) {
        model.addAttribute("name", "templateHtmlWithParam");
        model.addAttribute("requestParam", requestParam);
        return "templateHtmlWithParam";
    }

    // 문자열을 리턴하는 경우
    @GetMapping("string")
    @ResponseBody // @ResponseBody 가 붙은 경우 html을 찾지 않고, String이나 객체를 바로 반환한다.
    public String string() {
        return "String returned";
    }

    // JSON 객체를 리턴하는 경우
    @GetMapping("object")
    @ResponseBody // @ResponseBody 가 붙었는데 객체를 반환하는 경우 JSON 형태로 자동 변환하여 반환한다.
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

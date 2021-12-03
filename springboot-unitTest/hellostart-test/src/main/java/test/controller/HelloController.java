package test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.HelloService;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-07-14
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable(value = "name") String name) {
        log.info(helloService.sayHello(name + " , "));
        return helloService.sayHello(name + " , ");
    }

}

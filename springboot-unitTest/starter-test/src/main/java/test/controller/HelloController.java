package test.controller;

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
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable(value = "name") String name) {
        return helloService.sayHello( name + " , " );
    }

}

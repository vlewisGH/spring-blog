package com.blog.blog.extras;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MathController {

    @GetMapping("/add/{firstNumber}/and/{secondNumber}")
    @ResponseBody
    public int add(@PathVariable int firstNumber, @PathVariable int secondNumber){
        return (firstNumber + secondNumber);
    }

}

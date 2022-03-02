package com.training.spring.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class FirstRestController {


    // /first/hello2/osman/yaycıoğlu
    @GetMapping("/hello2/{abc}/{xyz}")
    public String helloEx(@PathVariable("abc") final String name,
                          @PathVariable("xyz") final String surname) {
        return "hello 2 " + name + " " + surname;
    }

    // /first/hello3?abc=osman&xyz=yaycıoğlu
    @GetMapping("/hello3")
    public String helloEx3(@RequestParam("abc") final String name,
                           @RequestParam("xyz") final String surname) {
        return "hello 3 " + name + " " + surname;
    }

    @GetMapping("/hello4/{abc}")
    public String helloEx4(@PathVariable("abc") final String name,
                           @RequestParam("xyz") final String surname) {
        return "hello 4 " + name + " " + surname;
    }

    @PostMapping("/hello5")
    public String helloEx5(@RequestBody final Person person) {
        return "hello 5 " + person;
    }


    //    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/hello")
    public String hello2() {
        return "hello POST";
    }

    @PutMapping("/hello")
    public String hello3() {
        return "hello PUT";
    }

    @PatchMapping("/hello")
    public String hello4() {
        return "hello PATCH";
    }

    @DeleteMapping("/hello")
    public String hello5() {
        return "hello DELETE";
    }

}

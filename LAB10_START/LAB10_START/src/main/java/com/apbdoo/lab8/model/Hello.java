package com.apbdoo.lab8.model;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Hello {
    private Long id;
    private String name;

    public String getName (){
        return name;
    }

    public void test(){}
}

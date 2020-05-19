package exe.application;

import api.config.ApiConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses  = {ApiConfig.class})
public class Main {
    public static void main(String[] args) {SpringApplication.run(Main.class,args);}
}

package com.training.springeurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringEurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringEurekaClientApplication.class, args);
    }


}
@RestController
class EurekaClientRestController {

  /*  @Value("${discovery-client.message}")
    private String msg1;

    @Value("${discovery-client.key}")
    private String msg2;

    @GetMapping(value = "/data")
    public String data() {
        System.out.println(msg1);
        System.out.println(msg2);
        return msg1 + " " + msg2;

    }*/
  @RequestMapping("/clients/data")
  public @ResponseBody String getData() {
      return "Hello";
  }

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/clients/{applicationName}")
    public @ResponseBody String getClientsByApplicationName(@PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName).get(0).getUri().toString();
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

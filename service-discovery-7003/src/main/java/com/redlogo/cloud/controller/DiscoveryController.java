package com.redlogo.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author redlogo
 * @version 0.1
 */
@RestController
@Slf4j
public class DiscoveryController {
    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    /**
     * Discovery service.
     *
     * @return DiscoveryClient
     */
    @GetMapping("/discovery")
    public DiscoveryClient discovery() {
        // get all services
        List<String> services = discoveryClient.getServices();
        log.info("***** " + instanceId + " DiscoveryController /discovery services:" + services);

        // get all instances for one service
        for (String service : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            log.info("***** " + instanceId + " DiscoveryController /discovery service under " + service);
            for (ServiceInstance instance : instances)
                log.info("      " + instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return discoveryClient;
    }
}

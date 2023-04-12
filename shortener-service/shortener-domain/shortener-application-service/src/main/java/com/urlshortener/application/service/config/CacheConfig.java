package com.urlshortener.application.service.config;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class CacheConfig {
    @Value("${ignite.addresses}")
    private String[] addresses;

    @Bean
    public Ignite igniteInstance() {
        var configuration = new IgniteConfiguration();
        configuration.setClientMode(true);
        configuration.setIgniteInstanceName("shortener-cache-client");

        var ipFinder = new TcpDiscoveryVmIpFinder();
        ipFinder.setAddresses(Arrays.asList(addresses));

        var discoverySpi = new TcpDiscoverySpi();
        discoverySpi.setIpFinder(ipFinder);
        configuration.setDiscoverySpi(discoverySpi);

        return Ignition.start(configuration);
    }
}

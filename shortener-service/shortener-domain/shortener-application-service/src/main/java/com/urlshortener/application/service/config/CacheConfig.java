package com.urlshortener.application.service.config;

import java.util.List;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean
    public Ignite igniteInstance() {
        IgniteConfiguration igniteConfiguration = new IgniteConfiguration();
        igniteConfiguration.setIgniteInstanceName("shortener-application-cache");
        igniteConfiguration.setPeerClassLoadingEnabled(true);

        TcpDiscoverySpi tcpDiscoverySpi = new TcpDiscoverySpi();
        TcpDiscoveryVmIpFinder tcpDiscoveryVmIpFinder = new TcpDiscoveryVmIpFinder();
        tcpDiscoveryVmIpFinder.setAddresses(List.of("127.0.0.1:47500"));
        tcpDiscoverySpi.setIpFinder(tcpDiscoveryVmIpFinder);

        igniteConfiguration.setDiscoverySpi(tcpDiscoverySpi);

        return Ignition.start(igniteConfiguration);
    }
}

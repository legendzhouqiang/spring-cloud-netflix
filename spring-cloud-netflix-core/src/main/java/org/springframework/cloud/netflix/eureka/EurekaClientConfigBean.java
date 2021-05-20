/*
 * Copyright 2013-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.netflix.eureka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.netflix.discovery.EurekaClientConfig;

/**
 * @author Dave Syer
 */
@Data
@ConfigurationProperties("eureka.client")
public class EurekaClientConfigBean implements EurekaClientConfig {
    
    public static final String DEFAULT_URL = "http://localhost:8761"
                                                     + EurekaServerConfigBean.DEFAULT_PREFIX + "/";
    
    public static final String DEFAULT_ZONE = "defaultZone";
    
    private static final int MINUTES = 60;
    
    private boolean enabled = true;
    
    /**
     * 从eureka服务器注册表中获取注册信息的时间间隔
     */
    private int registryFetchIntervalSeconds = 30;
    
    /**
     * 复制实例变化信息到eureka服务器所需要的时间间隔
     */
    private int instanceInfoReplicationIntervalSeconds = 30;
    
    /**
     * 最初复制实例信息到eureka服务器所需的时间
     */
    private int initialInstanceInfoReplicationIntervalSeconds = 40;
    
    /**
     * 询问Eureka服务url信息变化的时间间隔
     */
    private int eurekaServiceUrlPollIntervalSeconds = 5 * MINUTES;
    
    /**
     * 获取eureka服务的代理主机，默认为null
     */
    private String proxyPort;
    
    /**
     * 获取eureka服务的代理端口, 默认为null
     */
    private String proxyHost;
    
    /**
     * 获取 eureka 服务的代理用户名，默认为null
     */
    private String proxyUserName;
    
    /**
     * 获取 eureka 服务的代理密码，默认为null
     */
    private String proxyPassword;
    
    /**
     * eureka 需要超时读取之前需要等待的时间，默认为8秒
     */
    private int eurekaServerReadTimeoutSeconds = 8;
    
    /**
     * eureka 需要超时连接之前需要等待的时间
     */
    private int eurekaServerConnectTimeoutSeconds = 5;
    
    /**
     * 获取实现了eureka客户端在第一次启动时读取注册表的信息作为回退选项的实现名称
     */
    private String backupRegistryImpl;
    
    /**
     * eureka客户端允许所有eureka服务器连接的总数目，默认是200
     */
    private int eurekaServerTotalConnections = 200;
    
    /**
     * eureka客户端允许eureka服务器主机连接的总数目，默认是50
     */
    private int eurekaServerTotalConnectionsPerHost = 50;
    
    /**
     * 表示eureka注册中心的路径，如果配置为eureka，则为http://x.x.x.x:x/eureka/，
     * 在eureka的配置文件中加入此配置表示eureka作为客户端向注册中心注册，
     * 从而构成eureka集群。此配置只有在eureka服务器ip地址列表是在DNS中才会用到，默认为null
     */
    private String eurekaServerURLContext;
    
    /**
     * 获取eureka服务器的端口，此配置只有在eureka服务器ip地址列表是在DNS中才会用到。默认为null
     */
    private String eurekaServerPort;
    
    /**
     * 获取要查询的DNS名称来获得eureka服务器，此配置只有在eureka服务器ip地址列表是在DNS中才会用到。默认为null
     */
    private String eurekaServerDNSName;
    
    private String region = "us-east-1";
    
    /**
     * Eureka服务的http请求关闭之前其响应的时间，默认为30 秒
     */
    private int eurekaConnectionIdleTimeoutSeconds = 30;
    
    /**
     * 此客户端只对一个单一的VIP注册表的信息感兴趣
     */
    private String registryRefreshSingleVipAddress;
    
    /**
     * 心跳执行程序线程池的大小,默认为5
     */
    private int heartbeatExecutorThreadPoolSize = 2;
    
    /**
     * 心跳执行程序回退相关的属性，是重试延迟的最大倍数值，默认为10
     */
    private int heartbeatExecutorExponentialBackOffBound = 10;
    
    /**
     * 执行程序缓存刷新线程池的大小，默认为2
     */
    private int cacheRefreshExecutorThreadPoolSize = 2;
    
    /**
     * 执行程序指数回退刷新的相关属性，是重试延迟的最大倍数值，默认为10
     */
    private int cacheRefreshExecutorExponentialBackOffBound = 10;
    
    private Map<String, String> serviceUrl = new HashMap<String, String>();
    
    {
        this.serviceUrl.put(DEFAULT_ZONE, DEFAULT_URL);
    }
    
    private boolean gZipContent = true;
    
    private boolean useDnsForFetchingServiceUrls = false;
    
    private boolean registerWithEureka = true;
    
    private boolean preferSameZoneEureka = true;
    
    private boolean logDeltaDiff;
    
    private boolean disableDelta;
    
    private String fetchRemoteRegionsRegistry;
    
    private Map<String, String> availabilityZones = new HashMap<String, String>();
    
    private boolean filterOnlyUpInstances = true;
    
    private boolean fetchRegistry = true;
    
    private String dollarReplacement = "_-";
    
    private String escapeCharReplacement = "__";
    
    @Override
    public boolean shouldGZipContent() {
        return this.gZipContent;
    }
    
    @Override
    public boolean shouldUseDnsForFetchingServiceUrls() {
        return this.useDnsForFetchingServiceUrls;
    }
    
    @Override
    public boolean shouldRegisterWithEureka() {
        return this.registerWithEureka;
    }
    
    @Override
    public boolean shouldPreferSameZoneEureka() {
        return this.preferSameZoneEureka;
    }
    
    @Override
    public boolean shouldLogDeltaDiff() {
        return this.logDeltaDiff;
    }
    
    @Override
    public boolean shouldDisableDelta() {
        return this.disableDelta;
    }
    
    @Override
    public String fetchRegistryForRemoteRegions() {
        return this.fetchRemoteRegionsRegistry;
    }
    
    @Override
    public String[] getAvailabilityZones(String region) {
        String value = this.availabilityZones.get(region);
        if (value == null) {
            value = DEFAULT_ZONE;
        }
        return value.split(",");
    }
    
    @Override
    public List<String> getEurekaServerServiceUrls(String myZone) {
        String serviceUrls = this.serviceUrl.get(myZone);
        if (serviceUrls == null || serviceUrls.isEmpty()) {
            serviceUrls = this.serviceUrl.get(DEFAULT_ZONE);
        }
        if (serviceUrls != null) {
            return Arrays.asList(serviceUrls.split(","));
        }
        
        return new ArrayList<>();
    }
    
    @Override
    public boolean shouldFilterOnlyUpInstances() {
        return this.filterOnlyUpInstances;
    }
    
    @Override
    public boolean shouldFetchRegistry() {
        return this.fetchRegistry;
    }
    
}

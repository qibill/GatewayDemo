package com.qibill.config;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 */
public class SuffixRoutePredicateFactory extends AbstractRoutePredicateFactory<SuffixRoutePredicateFactory.Config> {
    
    public SuffixRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("suffix");
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return exchange -> {
            String url = exchange.getRequest().getURI().toString();
            return url.endsWith(config.getSuffix());
        };
    }

    public static class Config {

        private String suffix;

        public String getSuffix() {
            return suffix;
        }

        public void setSuffix(String suffix) {
            this.suffix = suffix;
        }
    }
}

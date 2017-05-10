package com.unic.gatling.web.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@WebFilter(urlPatterns = "*")
public class LoggingFilter implements Filter {

    private Logger log = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        long startTime = currentTimeMillis();
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        chain.doFilter(request, response);

        log.info(format("%s %s - duration %dms", httpServletRequest.getMethod(), getRequestURLWithParams(httpServletRequest), currentTimeMillis() - startTime));
    }

    private StringBuffer getRequestURLWithParams(HttpServletRequest httpServletRequest) {
        StringBuffer requestURL = httpServletRequest.getRequestURL();

        String queryString = httpServletRequest.getQueryString();

        if (StringUtils.hasText(queryString)) {
            requestURL.append(format("?%s", queryString));
        }
        return requestURL;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}

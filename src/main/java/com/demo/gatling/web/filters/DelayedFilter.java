package com.demo.gatling.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName = "com.demo:name=DelayConfiguration")
@WebFilter(urlPatterns = "*")
public class git add DelayedFilter implements Filter {

    private int delayInSeconds = 0;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        delayIfNeeded();

        chain.doFilter(request, response);
    }

    private void delayIfNeeded() {
        if (delayInSeconds > 0) {
            try {
                Thread.sleep(delayInSeconds * 1000);
            } catch (InterruptedException e) {
            }
        }
    }

    @ManagedAttribute
    public void setDelayInSeconds(int delayInSeconds) {
        this.delayInSeconds = delayInSeconds;
    }

    @ManagedAttribute
    public int getDelayInSeconds() {
        return delayInSeconds;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}

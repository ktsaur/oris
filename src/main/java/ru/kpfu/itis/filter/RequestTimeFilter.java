package ru.kpfu.itis.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

//@WebFilter(urlPatterns = "")
public class RequestTimeFilter implements Filter { //фильтр для замера времени выполнения запроса
    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long startTime = System.nanoTime(); // время до обработки запроса
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        chain.doFilter(request, response);

        long endTime = System.nanoTime(); // время после обработки запроса
        long duration = endTime - startTime; // в наносекундах

        String uri = httpServletRequest.getRequestURI();
        String method = httpServletRequest.getMethod();

        LOG.info("Запрос к URI " + uri + " с использованием метода " + method + " занял " + duration / 1_000_000.0 + " мс");
    }

}

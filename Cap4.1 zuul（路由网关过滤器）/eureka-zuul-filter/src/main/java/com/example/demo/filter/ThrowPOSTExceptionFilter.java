package com.example.demo.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ThrowPOSTExceptionFilter extends ZuulFilter{

	private static Logger log = LoggerFactory.getLogger(ThrowPOSTExceptionFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 15;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }
/*    @Override
	public Object run() {
	    log.info("This is a pre filter, it will throw a RuntimeException");
	    RequestContext ctx = RequestContext.getCurrentContext();
	    try {
	        doSomething();
	    } catch (Exception e) {
	        ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        ctx.set("error.exception", e);
	    }
	  	return null;
	}*/

    
    @Override
    public Object run() {
        log.info("This is a post filter, it will throw a RuntimeException");
        doSomething();
        return null;
    }

    private void doSomething() {
        throw new RuntimeException("Exist post some errors...");
    }
}

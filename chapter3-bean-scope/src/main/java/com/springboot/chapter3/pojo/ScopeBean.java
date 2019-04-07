package com.springboot.chapter3.pojo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Here ConfigurableBeanFactory only have two options: SCOPE_SINGLETON and SCOPE_PROTYPE
 * If you need more options, please use WebApplicationContext which contains SCOPE_REQUEST,
 * SCOPE_SESSION, and SCOPE_APPLICATION
 * @author xiaoqiangliu
 *
 */
@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class ScopeBean {

}

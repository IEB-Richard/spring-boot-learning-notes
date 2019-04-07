package com.springboot.chapter3.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DataBaseConditional implements Condition {
	/**
	 * @param context - condition context
	 * @param metadata
	 * @return true - inject bean; false - will not inject the bean
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		
		Environment env = context.getEnvironment();
		
		return env.containsProperty("database.driverName") 
				&& env.containsProperty("database.url")
				&& env.containsProperty("database.username")
				&& env.containsProperty("database.password");
	}

}

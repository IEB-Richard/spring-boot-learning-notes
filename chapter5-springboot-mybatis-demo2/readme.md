# About this demo project

A demo project of integration of Springboot and mybatis. 



## Packages

```XML
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>2.0.1</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-configuration-processor</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
```



## Configurations

This demo project make configurations via a configuration class.  

```Java
package com.springboot.chapter5.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages= {"com.springboot.chapter5.dao"})
public class AppConfig {

}

```

the annotation `@MapperScan(basePackages= {"com.springboot.chapter5.dao"})` define which packages.



You can avoid writting this configuration class. There is another solution that you can make the configutation directly in application.properties files. Please check on another demo project for details.



### application.properties configuration and how it works

make the following configurations in the `application.properties` configuration file

```properties
#MySQL Datasource configurations
spring.datasource.url=jdbc:mysql://localhost:3306/spring_boot_chapter5
spring.datasource.username=springstudent
spring.datasource.password=springstudent

# MyBatis Configutations
mybatis.mapper-locations=classpath:mapper/*.xml
mybatis.type-aliases-package=com.springboot.chapter5.pojo
mybatis.type-handlers-package=com.springboot.chapter5.typehandler
#logging.level.root=DEBUG
#logging.level.org.springframework=DEBUG
logging.level.org.org.mybatis=DEBUG
```



`mybatis.mapper-locations=classpath:mapper/*.xml` means the mapper files we defined will be placed under `resource/mapper` folder

Please note the configuration `mybatis.type-aliases-package`. With this configuration, it could work with annotation `@Alias` when defining the entity classes.



```java
@Alias(value = "user")// MyBatis指定别名
public class User {
	
	private Long id = null;
	private String userName = null;
	private SexEnum sex = null;
	private String note = null;
	
	public User() {
	}
  
  ...
```

then we can use type `user` in the XML mapper file.

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.springboot.chapter5.dao.UserDao">
	<select id="getUser" parameterType="Long" resultType="user">
		select id, user_name as userName, sex, note from t_user where id = #{id}
	</select>
</mapper> 
```



### Type handler

because attribute sex is an type of Enumeration, here we assign one typehanlder class, and did the following configuration in the properties file:

```properties
mybatis.type-handlers-package=com.springboot.chapter5.typehandler
```


# Spring Dependency Injection
-----

### Add Spring core and spring context dependency
1. Through XML files
    ### One type one configuration.All configuration inside xml file
    ### Need to configure Bean using <bean/> Element
    1. Setter Injection
        1. Set value Using Element(Tags)
        2. Set value Using Attribute
        3. Set value Using `P` schema
    2. Constructor Injection
        1. Set Using Element(Tag)
        2. Set Using Attribute
        3. Set Using `C` scehma
2. Through Annotations(still xml file needed.Need to enable annotation in xml file)
    ### Need two types of config - (i)Specify base package in xml file.(ii)Annotate Bean
    ### Does not need to configure Bean using <bean/> Element
    1. Add @Component annotation on Bean class (Same as configuring with <bean/>).You can pass component name in Annotation.
    2. Specify base package
        1. in XML file specify package using `<context:component-scan base-package=""/>`
        2. in java config file use @ComponentScan annotation
    3. Annotation configuration creates object in camelCase .Example : You have Bean Student. You will get object like  `(Student)context.getBean("student")`
    4. Add @Value Annotation on top of fields to pass value
    5. To pass name of another Bean user `#{}` spring Expression language
3. Auto Wiring(Works with only Objects)
    1. XML
        1. `autowire` attribute values(no,byName,byType,constructor,autodetect(Depricated))
    2. Annotation
        1. Both Annotation and xml file
            1. Add @AutoWiried on (Variable/constructor/setter)
            2. You still need to configure Bean in xml(or somewhere else) file without passing dependency using `<bean/>`
            3. auto wiring injects dependencies matching types (byType).uses setter injection method.
            4. Using @Qualifier you pass the dependency name.(If you have multiple dependency Bean configured with different name)
        2. Java file configuration and Annotation and java config file
            1. Annotate Bean wih @Component Annotation
            2. Add @AutoWiried and @Qualifier Annotation on field
            3. Add @ComponentScan annotation to specify base package in java config file
        
4. Using Only Annotation(No more xml files But needs java file)`Better Option use this option.simple steps`
    1. In this method you do not need any xml file.You just need to follow these steps
        1. Create a java class
        2. Annotate that class with `@Configuration` Annotation.(Now it is your configuration file like xml file)
        3. create methods in side you java config file that returns expected Bean instance and annotate that method with `@Bean` Annotation
        4. you will get bean intance using that method name (default) like:Suppose you have getStudent() method that returns Student Bean instance `context.getBean("getStudent",Student.class)`.You can specify name in @Bean Annotation
        5. In Main file create intance of `AnnotationConfigApplicationContext` insteed of ClassPathXmlApplicationContext`;
    2. You can annotate Bean class with @Component Annotation but as you are using @Bean Annotation on method and method returns Bean instance, this is not needed.
    3. You can Specify base package with Bean with `@ComponentScan` (what we were doing in xml file while using @Component Annotation).If you use @Bean Annotation that Annotation is not needed.




    
# Spring Bean life cycle config
-----

1. init method
2. destryo method

1. XML
    1. create init and destroy method with same signature in Bean and add `init-method and destroy-method` attribute in xml file.
    2. init and destroy methods name can be different but signature should be same
2. Interface
    1. Implement `InitializingBean` interface for `init` method and `DesposableBean` interface for `destroy` method
    2. afterPropertiesSet() == init()
    3. destroy()==destroy()
3. Annotation
    1. Add another project dipendency javax.annotation
    2. init == @PostConstruct
    3. destroy == @PreDestroy
    4. enable `context:annotation-config` in xml file

# Spring Bean Scope
------

### You can change Beans scope using `scope` attribute in <bean/> tag in xml or `@Scope` Annotation beneath @Component Annotation

1. Singleton(Creates object onece and when requested gives that same object)
2. ProtoType(Creates new object every time when called)
3. request(works with web)
4. session(works with web)
5. globalsession

# Tips
-----

1. To call static method inside Spring Expression language use this pattern `T(class).method(param)`
2. To call static field inside Spring Expression language use this pattern `T(class).var`
3. Use Spring Expression in Double quetes.If you need to use quetes in SpEL use single quetes


# Spring JDBC
-----

1. Add spring jdbc dependency
2. Add mysql dependency
3. No need to handle error,No need to close connection/statement.

### Setup

`you just need to configure two Bean(Class).Same as regular Bean`

1. using xml file
    1. First configure `JdbcTemplate` Bean.Then provide its dependency `DataSource`
        `Package = org.springframework.jdbc.core.JdbcTemplate`
    2. `DataSource` is a interface it has a Implementation called `DriverManagerDataSource`.Configure it and provide in 'JdbcTemplate'.It has 4 dependencies
        1. `driverClassName` = mysql driver class path
        2. `url` = database url
        3. `username`
        4. `password`
    3. Done
    4. you will get object of JdbcTemplate 

2. using java config(Annotation)
    1. create a java config file (Annotate the class with `@Configuration` annotation)
    2. configure `JdbcTemplate` and `DriverManagerDataSource` in the same way as other Beans are configured (using method and @Bean Annotation)
    3. do not forget to set required values
    
3. you can configure spring jdbc using autowiring also.(both xml and Annotation)

### Best practises

1. user DTO class
2. user service and repository interface
3. configure both serviceImp and repositoryImp class
4. serviceImp class has an dependency of repositoryImp class, (inject  using constructor injection (using spring))
5. repositoryImp class has an dependency of JdbcTemplte class, (inject using constructor injection (using spring))

### Short informations
1. If you add @Component Annotation on any Bean you do not need to config that bean inside xml file.Just need to specify base package in either xml file or java sonfig file.
2. In Autowiring you need to config that bean either in xml or using @Component;

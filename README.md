# SpringCheetSheat
------

# Spring Dependency Injection

1. Through XML files
    ### One type one configuration.All configuration inside xml file
    ### Need to configure Bean using <bean/> Element
    1. Setter Injection
        1. Set value Using Element(Tags)
        2. Set value Using Attribute
        3. Set value Using `P` context
    2. Constructor Injection
        1. Set Using Element(Tag)
        2. Set Using Attribute
        3. Set Using `C` context
2. Through Annotations(still xml file needed.Need to enable annotation in xml file)
    ### Need two types of config - (i)Specify base package in xml file.(ii)Annotate Bean
    ### Does not need to configure Bean using <bean/> Element
    1. Add @Component annotation on Bean class (Same as configuring with <bean/>).You can pass component name in Annotation.
    2. in XML file specify package using `<context:component-scan base-package=""/>`
    3. Annotation configuration creates object in camelCase .Example : You have Bean Student. You will get object like  `(Student)context.getBean("student")`
    4. Add @Value Annotation on top of fields to pass value
    5. To pass name of another Bean user `#{}` spring Expression language
3. Auto Wiring(Works with only Objects)
    1. XML
        1. `autowire` attribute values(no,byName,byType,constructor,autodetect(D))
    2. Annotation
        1. Add @AutoWiried on (Variable/constructor/setter)
        2. You still need to configure Bean in xml(or somewhere else) file without passing dependency using `<bean/>`
        3. auto wiring injects dependencies matching types (byType)
        4. Using @Qualifier you pass the dependency name.(If you have multiple dependency Bean configured with different name)
        
4. Using Only Annotation(No more xml files But needs java file)`Better Option use this option.simple steps`
    1. In this method you do not need any xml file.You just need to follow these steps
        1. Create a java class
        2. Annotate that class with `@Configuration` Annotation.(Now it is your configuration file like xml file)
        3. create methods in side you java config file that returns expected Bean instance and annotate that method with `@Bean` Annotation
        4. you will get bean intance using that method name like:Suppose you have getStudent() method that returns Student Bean instance `context.getBean("getStudent",Student.class)`
        5. In Main file create intance of `AnnotationConfigApplicationContext` insteed of ClassPathXmlApplicationContext`;
    2. You can annotate Bean class with @Component Annotation but as you are using @Bean Annotation on method and method returns Bean instance, this is not needed.
    3. You can Specify base package with Bean with `@ComponentScan` (what we were doing in xml file while using @Component Annotation).If you use @Bean Annotation that Annotation is not needed.
    4. You can pass name of you Bean instance inside you @Bean Annotation




    
# Spring Bean life cycle config

1. XML
    1. create init and destroy method with same signature in Bean and add `init-method and destroy-method` attribute in xml file.
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

### You can change Beans scope using `scope` attribute in Bean tag in xml or `@Scope` Annotation beneath @Component Annotation

1. Singleton(Creates object onece and when requested gives same object)
2. ProtoType(Created new object when called)
3. request(works with web)
4. session(works with web)
5. globalsession

# Tips

1. To call static method inside Spring Expression language use this pattern `T(class).method(param)`
2. To call static field inside Spring Expression language use this pattern `T(class).var`
3. Use Spring Expression in Double quetes.If you need to use quetes in SpEL use single quetes


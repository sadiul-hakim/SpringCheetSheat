# SpringCheetSheat
------
# Spring Dependency Injection

1. Through XML files
    1. Setter Injection
        1. Use Element
        2. Use Property
        3. User P context
    2. Constructor Injection
        1. Use Element
        2. Use Property
        3. Use `P` context
2. Through Annotations
3. Auto Wiring(Works with only Objects)
    1. XML
        1. autowiri attribute values(no,byName,byType,constructor,autodetect(D))
    2. Annotation
        1. Add @AutoWiried on (Variable/constructor/setter)
        2. You still need to configure Bean in xml(or somewhere else) file without passing dependency
        3. auto wiring injects dependencies matching types (byType)
        4. Using @Qualifier you pass the dependency name.(If you have multiple dependency bean configured with different name)
        
    

# Spring Bean life cycle config

1. XML
    1. create init and destroy method with same signature in Bean and add `init-method and destroy-method` attribute in xml file.
2. Interface
    1. Implement `InitializingBean` interface for init method and `DesposableBean` interface for destroy method
    2. afterPropertiesSet method == init()
    3. destroy()==destroy()
3. Annotation
    1. Add another project dipendency javax.annotation
    2. init == @PostConstruct
    3. destroy == @PreDestroy
    4. enable `context:annotation-config` in xml file

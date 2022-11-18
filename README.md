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
        1. no
        2. byName
        3. byType
        4. constructor
        5. autodetect(Deprecated)
    2. Annotation
        1. @AutoWiried
    

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

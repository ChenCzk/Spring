Spring 
======
SpringIOC
------
    一.依赖注入的三种方式
    
        1.构造器注入
         Role(String,String)-->Role(index=0,index=1)
            <constructor-arg index="0" value="xx"/>
            <constructor-arg index="1" value="xx"/>
        2.setter注入
        3.接口注入 P226
    
    二.装配Bean
    
        1.使用XMl配置装配Bean
        2.使用命名空间装配Bean P234
        3.使用注解装配Bean
        注意：对于第三方的包或者其他外部的接口,用XML,自己写的包用注解
             无论是XML还是注解的方式,最终都是将Bean装配到IOC容器中
    
    
    三.使用注解装载bean
    
        1.@Configuration用于定义配置类，可替换xml配置文件.
            1.被注解的类内部包含有一个或多个被@Bean注解的方法
            2.这些方法将会被AnnotationConfigApplicationContext
            3.或AnnotationConfigWebApplicationContext类进行扫描
            4.并用于构建bean定义，初始化Spring容器。
    
        2.@ComponentScan: 扫描特定的包（位置：config类上）
            1.basePackageClasses
                @ComponentScan(basePackageClasses = {A.Class,B.Class,...}//扫描这两个类所在的包和子包.
            2.basePackages
                @ComponentScan(basePackages = {"com.ssm.czk.annotation.pojo","com.ssm.czk.annotation.service"})//扫描指定的包和子包.
            3.basePackageClasses+basePackages
                @ComponentScan(basePackages = {"com.ssm.czk.annotation.pojo","com.ssm.czk.annotation.service"},
                        ComponentScan(basePackageClasses = {Role.class, RoleServiceImp.class}
          XML:使用组件扫描:<context:component-scan base-package="com.ssm.czk.annotation">
          @Component("id"):被扫描时,会被加入到Spring IOC容器中.
            * @Controller :WEB层
            * @Service :业务层
            * @Repository :持久层
          @Value("value"):值的注入
          
         
        3.自动装配
            @Autowired:从 spring IOC 容器中自动按类型（ByType）装配（位置:属性,方法,参数前）
            歧义性（当在有多个实现类的接口用自动装配时，按类型装配）：
                @Primary：优先注入（位置：某一个接口实现类）
                @Qualifier("某个接口实现类名称")：按照名称注入（位置：在@Autowirte下面）
                
                
        4.@Bean: 将方法返回的对象作为Spring的Bean,存放在IOC容器中.（位置：在方法上面）
            4个配置项:
                1.name:别名,可配置多个,如果为空,默认值为方法名。
                2.autowire：标志是否是一个引用的Bean对象,默认值是AutoWire.NO。
                3.initMethod:自定义初始化方法,在存放在IOC容器前执行。
                4.destoryMethod:自定义摧毁方法,服务器正常关闭或IOC容器关闭前执行。
                
                
        5.@ImportResource:在注解中配置多个XML配置文件,位置(@ComponentScan下面),@ImportResource({"classpath:xxx.xml"})
        
        
        6.@Import:1.在ApplicationConfig中import多个配置类。
                  2.在XML文件中引入其他的XML文件。
       
       
        7.Profile
            1.配置Profile
                1.@Profile("xx") xx代表自定义的ID值，在使用时调用
                2.在XML中使用profile="xx"（位置: beans 或者 xsi中）
            2.使用Profile
                由于配置Profile后，对应的Bean不会加载到SpringIOC容器中，所以要自行激活。
                1.在Spring MVC中可以配置Web上下文参数或者DispatchServlet。
                2.作为JNDI条目。
                3.配置环境变量
                4.配置JVM启动参数
                5.在集成测试环境中使用@ActiveProfiles、
       
       
        8.加载properties
            a.使用注解
                1.导入Properties文件
                    在ApplicationConfig中导入文件
                        @PropertySource(value={"classpath:xxx.properties"},3个可选配置) P254
                2.获取Properties文件的值
                    a.使用getProperty方法获取
                        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
                        String property = ctx.getEnvironment().getProperty("jdbc.database.driver");
                    b.使用${}获取
                        PropertySourcesPlaceholderConfigurer:属性文件解析类，使用他就意味者允许Spring解析对应的属性文件，通过占位符获取！
                        1.首先在ApplicationConfig中定义PropertySourcesPlaceholderConfigurer类并添加到IOC容器中
                            @Bean
                            public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
                                return new PropertySourcesPlaceholderConfigurer();
                            }
                        2.通过${xx}获取对应的值,eg:${jdbc.database.driver},${a}
        
            b.使用XML(都是用${}获取)
                a.使用<context:property-placeholder>元素,当有多个文件时不建议。
                        <context:property-placeholder location="classpath:asd.properties" 。。。/>
                b.使用PropertyPlaceHolderConfigurer的bean,内置数组,可以方便导入多个文件
                    <bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer" >
                            <!--可以配置多个属性-->
                            <property name="locations">
                                <array>
                                    <value>classpath:asd.properties</value>
                                    <value>classpath:database-config.properties</value>
                                </array>
                            </property>
                    </bean>
       
       
        9.@Conditional:条件化Bean,满足自定义条件才可装配Bean。
            1.创建一个DataSourceCondition类实现org.springframework.context.annotation.Condition接口。
                重写matches方法:
                    参数：1.context:获取Sprign的上下文。
                         2.AnnotatedTypeMetadata:获得该Bean的注解信息。
            2.在对应的Bean上添加注解 @Conditional({DataSourceCondition.class})即可。
       
        
        10.SpEL
            格式：@Value("#{xx}")
            xx：经常用来获取IOC容器的Bean，比如@Value("#{role}")
                进而用来获取方法属性值，比如@Value("#{role.id}")@Value("#{role.getId()}")
        
        
        11.加载配置文件
            1.在XML文件中引用XML文件
                <import resource = "xxxx.xml"/>
            2.在java配置类加入java配置类
                @Import(xxx.class)
            3.在Java配置类加入XML文件
                @ImportResource({xx.xml},{xxxx.xml})
         
Spring AOP
------
    
    Spring Aop步骤：

    1.选择连接点
        比如：1.JDK代理(连接点某个接口的Imp方法):
                 一个接口RoleService有个方法printRole()，
                 有个该接口的实现类RoleServiceImp调用方法printRole()，设置该方法为连接点，在创建切面时定义
                 系统会为该Imp类生成代理对象，然后拦截printRole方法，于是可以产生各种AOP通知方法。
             2.CGLib代理(实现类的方法，不需要接口)
                 选择一个类的方法作为连接点，在创建切面类时定义。
    2.创建切面类（RoleAspect）
        用@Aspect注解一个类，Spring就会把这个类当作一个切面。
        该切面类实现可以实现5种通知：
                   @Before("xx")：前置通知
                   @Around("xx")：环绕通知
                   @After("xx")：后置通知
                   @AfterReturning("xx")：返回通知（正常）
                   @AfterThrowing("xx")：异常通知
        "xx":execution("* com.ssm.xx.RoleServiceImp.printRole(..)")
             1.execution:代表执行方法的时候后会触发。
             2.*: 代表任意返回类型。
             3.com.xx：代表连接点属于的类（Imp）的全限定类名。
             4.printRole(..):被拦截的方法名称（连接点）,..代表任意参数。
        更方便的操作：
             1.定义一个方法 public void print(){}
             2.在他头上加注解：@Pointcut("execution("* com.ssm.xx.RoleServiceImp.printRole(..)")")
             3.这样通知上直接使用该方法就行，比如：@Before("print()")
    3.添加配置
        在config中使用注解：
                1.@EnableAspectJAutoProxy:启动AspectJ框架的自动代理。
                2.@Bean：返回一个切面的实例
                     @Bean
                      public RoleAspect getRoleService(){
                          return new RoleAspect();
                      }

    4.测试（以注解的方式）
        JDK代理：
            ApplicationContext ctx= new AnnotationConfigApplicationContext(AopConfig.class);
            Role r = new Role(1l,"asd","asdss");
            RoleService bean = ctx.getBean(RoleService.class); //获取连接点该类的接口的bean。
            bean.printRole(r);
        CGLib代理:
             ApplicationContext ctx= new AnnotationConfigApplicationContext(AopConfig.class);
             Role r = new Role(1l,"asd","asdss");
             RoleServiceImp roleServiceImp = (RoleServiceImp)ctx.getBean("roleServiceImp"); //获取连接点该类的bean。
             roleServiceImp.printRole(r);


    环绕通知（@Around）：
    
         public void around(ProceedingJoinPoint jp) throws Throwable {
                System.out.println("around before");//前置通知
                try {
                    jp.proceed();//调用连接点方法
                } catch (Throwable throwable) {
                    throwable.printStackTrace();//异常通知
                }
                System.out.println("around after");//后置通知
            }
         注意：1.参数ProceedingJoinPoint，由Spring提供，使用他可以反射连接点方法。
              2.环绕通知的具体各个通知优先与其他通知执行，
                    around before
                    before--
                    Role{id=1, roleName='asd', note='asdss'}
                    around after
                    after
                    afterReturning。
    
    给通知方法传递多个参数args:
        1.在通知方法上定义参数类型before(Role role,int sort)。
        2.在注解上加 "&& args(role,sort)"
            @Before(execution("* com.ssm.xx.RoleServiceImp.printRole(..)"+"&& args(role,sort)"))
            public void before(Role role,int sort){
                System.out.println(role+sort)
            }
    
    引入：
        简介：有一个类，需要条件约束，然后自定义一个条件类，引入到切面从而起到约束的作用。
        目的：获得条件类，从而实现一定条件逻辑
        重点：定义一个接口和接口实现类（条件类）,在需要条件化的类上实现该接口，然后可以在Ioc容器中获取需要条件化的类通过强制转换得到条件类，从而实现条件逻辑处理。
        步骤：1.定义一个接口和接口实现类（条件类）
              2.在需要条件化的类上实现该接口
                    在切面类中定义该条件类接口的返回方法并添加注解@DeclareParents
                       @DeclareParents(value = "需要条件化的类的权限定类名",defaultImpl = 条件类.Class)
                   eg:
                       @DeclareParents(value = "com.ssm.czk.annotation.AOP.Imp.RoleServiceImp",defaultImpl = RoleVerifierImp.class)
                       public RoleVerifier roleVerifier;
              3.通过该类获取条件类(强制转换)
                RoleServiceImp roleServiceImp = (RoleServiceImp)ctx.getBean("roleServiceImp");
                RoleVerifier roleVerifier = (RoleVerifier) roleServiceImp;
                只要AOP让代理对象挂到RoleVerifier接口下，就可以把对应的Bean通过强制装换
    
    
    
    使用XML实现AOP：
    定义接口,接口实现类（如果要引入，private RoleVerifier roleVerifier= null;）,切面类（定义通知方法）
        <!--定义切面类-->
             <bean id="XMLAspect" class="com.ssm.czk.annotation.AOP.Imp.XMLAspect"/>
        <!--定义实现类-->
             <bean id="roleServiceImp" class="com.ssm.czk.annotation.AOP.Imp.RoleServiceImp"/>
        <!--AOP配置-->
             <aop:config>
                 <!--引用XMLAspect作为切面类-->
                 <aop:aspect ref="XMLAspect">
                     <!--定义切点-->
                     <aop:pointcut id="printRole" expression="execution(* com.ssm.czk.annotation.AOP.Imp.RoleServiceImp.printRole(..))"/>
                     <!--定义通知-->
                     <aop:before method="before" pointcut="execution(* com.ssm.czk.annotation.AOP.Imp.RoleServiceImp.printRole(..)) and args(role,sort)" />
                     <aop:after method="after" pointcut-ref="printRole"/>
                     <aop:after-throwing method="afterThrowing" pointcut-ref="printRole"/>
                     <aop:after-returning method="afterReturning" pointcut-ref="printRole"/>
                     <aop:around method="around" pointcut-ref="printRole"/>
                     <!--引入-->
                     <aop:declare-parents types-matching="com.ssm.czk.annotation.AOP.Imp.RoleServiceImp" implement-interface="com.ssm.czk.annotation.AOP.service.RoleVerifier"  default-impl="com.ssm.czk.annotation.AOP.Imp.RoleVerifierImp"/>
                 </aop:aspect>
             </aop:config>
             
Spring整合MyBatis
------
    Spring 整合 MyBatis
         1.配置dataSource：
                            MyBatis的配置文件的<environments>交由Spring管理，可以由SimpleDriverDataSource（不支持数据池），或者第三方数据库连接池DBCP，C3P0管理。
         2.配置SQLSessionFactory，类型Mybatis的配置文件
            a. <!--引入数据源-->
                      <property name="dataSource" ref="dataSource"/>
            b. <!--引入Mybatis配置文件-->
                      <property name="configLocation" value="classpath:mybatis.xml"/>
         3.配置MapperScannerConfigurer,才可以使用Mapper接口编程方式。
            <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
                    <!--扫描特定的包（找到Mapper）-->
                    <property name="basePackage" value="com.czk.Mapper"/>
                    <property name="sqlSessionFactoryBeanName" value="SqlSessionFactory"/>
                    <!--指定注解@Repository为Mapper-->
                    <property name="annotationClass" value="org.springframework.stereotype.Repository"/>
            </bean>
            扫描：@EnableTransactionManagement
        
    
    事务有四个特性：ACID
        原子性（Atomicity）：事务是一个原子操作，由一系列动作组成。事务的原子性确保动作要么全部完成，要么完全不起作用。
        一致性（Consistency）：一旦事务完成（不管成功还是失败），系统必须确保它所建模的业务处于一致的状态，而不会是部分完成部分失败。在现实中的数据不应该被破坏。
        隔离性（Isolation）：可能有许多事务会同时处理相同的数据，因此每个事务都应该与其他事务隔离开来，防止数据损坏。
        持久性（Durability）：一旦事务完成，无论发生什么系统错误，它的结果都不应该受到影响，这样就能从任何系统崩溃中恢复过来。通常情况下，事务的结果被写到持久化存储器中。
    
    Spring并不直接管理事务，而是提供了多种事务管理器，由持久层框架实现，Mybatis主要由DataSourceTransactionManage事务管理器实现。
        配置DataSourceTransactionManage事务管理器：
        1.XML配置
             <!--配置数据源事务管理器-->
              <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
                   <property name="dataSource" ref="dataSource"/>
              </bean>
    
        2.注解
             @Bean(name = "transactionManager")
             public PlatformTransactionManager getplatformTransactionManager(){
                 DataSourceTransactionManager transactionManager =new DataSourceTransactionManager();
                 transactionManager.setDataSource(initDataSource());
                 return transactionManager;
             }
    
     声明式事务：
        1.需要配置注解驱动：<tx:annotation-driven transaction-manager="transactionManager"/>
        2.a.使用XMl声明式配置：
            1.配置事务拦截器：TransactionInterceptor
                根据正则式表达式匹配度决定采用哪种属性值！
            2.配置拦截类：BeanNameAutoProxyCreator
                定义需要拦截的类，一旦这些类启动，拦截器生效，给该类定义事务属性！
    
            <!--配置事务拦截器-->
            <bean id="transactionInterceptor" class="org.springframework.transaction.interceptor.TransactionInterceptor">
                <property name="transactionManager" ref="transactionManager"/>
                <!--配置事务属性-->
                <property name="transactionAttributes">
                    <props>
                       <!--key 代表业务方法的正则表达式，而其内容可以配置各类事务定义参数，这里值传播行为和隔离级别-->
                       <prop key="intsert*">PROPAGATION_REQUIRED,ISOLATION_READ_UNCOMMITTED</prop>
                    </props>
                </property>
             </bean>
            重点：Spring Ioc启动时会将transactionAttributes的内容解析放进TransactionDefinition事务定义器中，在运行时根据正则式表达式匹配度决定采用哪种方法
    
            <!--指明哪些类要使用事务拦截器进行拦截-->
            <bean class="org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator">
                <property name="beanNames">
                    <list>
                        <!--关于Service是实现类都会被其拦截-->
                        <value>*ServiceImpl</value>
                    </list>
                </property>
                <property name="interceptorNames">
                    <list>
                        <!--定义事务拦截器-->
                        <value>transactionInterceptor</value>
                    </list>
                </property>
            </bean>
        b.用注解@Transaction进行配置
            可以在类或方法上配置:@Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)

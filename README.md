# Blueberry 蓝莓
这是一个小程序后端项目，取名`jiafly.Blueberry(我家的蓝莓)` ，这将成为一个`传统`。(`最终你将会明白什么是传统！！`)

## 项目环境
- JDK14
- 集成
    + Spring Boot Starter Web
    + Lombok(已移除)
    + MySQL connector java
    + Druid 
    + MyBaits
    + Swagger2 3.0.0
    + Twitter 雪花ID生成算法
    + Lettuce Redis
    + Spring Boot Mail
    + Thymeleaf(模板引擎)
    + restTemplate
    + 全局异常处理
    + 全局跨域处理（真正一般使用 nginx）

### 1.集成 Druid 数据库连接池

#### 1-1 引入 jar 包
```xml
<dependencies>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid-spring-boot-starter</artifactId>
        <version>1.1.23</version>
    </dependency>
</dependencies>
```
#### 1-2 application.yml 配置文件
```yaml
server:
  port: 8080
  servlet:
    context-path: /

spring:
  datasource:
    druid:
      url: jdbc:mysql://localhost:3306/blueberry?useUnicode=true&characterEncoding=UTF-8&useSSL=false&useTimezone=true&serverTimezone=Asia/Shanghai&allowMultiQueries=true&autoReconnect=true
      driver-class-name: com.mysql.cj.jdbc.Driver
      username: root
      password: root
      # 初始化时建立物理连接的个数
      initial-size: 5
      # 最大连接池数量
      max-active: 30
      # 最小连接池数量
      min-idle: 5
      # 获取连接时最大等待时间，单位毫秒
      max-wait: 60000
      # 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
      time-between-eviction-runs-millis: 60000
      # 连接保持空闲而不被驱逐的最小时间
      min-evictable-idle-time-millis: 300000
      # 用来检测连接是否有效的sql，要求是一个查询语句
      validation-query: SELECT 1 FROM DUAL
      # 建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
      test-while-idle: true
      # 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
      test-on-borrow: false
      # 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
      test-on-return: false
      # 是否缓存preparedStatement，也就是PSCache。PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭。
      pool-prepared-statements: true
      # 要启用PSCache，必须配置大于0，当大于0时，poolPreparedStatements自动触发修改为true。
      max-pool-prepared-statement-per-connection-size: 50
      # 配置监控统计拦截的filters，去掉后监控界面sql无法统计
      filters: stat,wall
      # 合并多个DruidDataSource的监控数据
      use-global-data-source-stat: true
      # 通过connectProperties属性来打开mergeSql功能；慢SQL记录
      connection-properties:
        druid:
          stat:
            mergeSql: true
            slowSqlMillis: 500
```
#### 1-3 配置类
```java
@Configuration
public class DruidConfig {
    @Bean
    public ServletRegistrationBean<StatViewServlet> druidStatViewServlet() {
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        // IP白名单 (没有配置或者为空，则允许所有访问)
        registrationBean.addInitParameter("allow", "127.0.0.1");
        // IP黑名单 (存在共同时，deny优先于allow)
        registrationBean.addInitParameter("deny", "");
        registrationBean.addInitParameter("loginUsername", "admin");
        registrationBean.addInitParameter("loginPassword", "123456");
        registrationBean.addInitParameter("resetEnable", "false");
        return registrationBean;
    }
}
```
#### 1-4 访问
在浏览器中输入 [http://localhost:8080/druid](http://localhost:8080/druid) 进入登录页面，在表单中输入 `1-3 配置类` 中的用户名密码登录即可。

### 2.集成 Thymeleaf 静态模板
#### 2-1 引入 jar 包
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```
#### 2-2 application.yml 配置文件
```yaml
server:
  port: 8080
  servlet:
    context-path: /

spring:
  thymeleaf:
    cache: false
    check-template: false
    encoding: utf-8
    mode: HTML5
    prefix: classpath:templates/
    servlet:
      content-type: text/html
  mvc:
    view:
      prefix: templates/
      suffix: .html
```

### 3.集成 Mybatis 和通用 Mapper
#### 3-1 引入 jar 包
```xml
<dependencies>
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>2.1.3</version>
    </dependency>
    <dependency>
        <groupId>tk.mybatis</groupId>
        <artifactId>mapper-spring-boot-starter</artifactId>
        <version>2.1.5</version>
    </dependency>
    <dependency>
        <groupId>org.mybatis.generator</groupId>
        <artifactId>mybatis-generator-core</artifactId>
        <version>1.4.0</version>
    </dependency>
</dependencies>
```

### 4.集成 Swagger2 
#### 4-1 引入 jar 包
这里引入的是3.0.0版本，不在是2.9.2版本，相比于之前版本引用 jar 包只有这一个
```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
```
#### 4-2 配置
```java
@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jiafly.blueberry.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Blueberry API")
                .description("Blueberry 文档")
                .termsOfServiceUrl("")
                .version("1.0")
                .contact(new Contact("东邪", "http://www.jiafly.com", "liuyi@jiafly.com"))
                .build();
    }
}
```
#### 4-3 访问
访问路径相比于之前 2.9.2 的路径已经发生了变化，
[http://127.0.0.1:项目端口/swagger-ui/index.html](http://127.0.0.1:8080/swagger-ui/index.html)

#### 4-4 使用
```
在 参数 和 返回对象中使用
@ApiModel("标记对象")
@ApiModelProperty("标记属性")

在 controller 类中使用
@Api(tags="标记controller作用")
@ApiOperation(value = "方法描述", notes = "方法概述")
@ApiIgnore 在方法上标记则忽略此方法
```

### 5.雪花ID生成算法
```java
public class SnowIdUtils {
    /**
     * 私有的 静态内部类
     */
    private static class SnowFlake {

        /**
         * 内部类对象（单例模式）
         */
        private static final SnowIdUtils.SnowFlake SNOW_FLAKE = new SnowIdUtils.SnowFlake();
        /**
         * 序列号占用位数
         */
        private final long SEQUENCE_BIT = 12;
        /**
         * 机器标识占用位数
         */
        private final long MACHINE_BIT = 10;
        /**
         * 生成id机器标识部分
         */
        private long machineIdPart;
        /**
         * 序列号
         */
        private long sequence = 0L;
        /**
         * 上一次时间戳
         */
        private long lastStamp = -1L;

        /**
         * 构造函数初始化机器编码
         */
        private SnowFlake() {
            long localIp = 4321;
            // 最大机器编号 （1023）
            long maxMachineId = ~(-1L << MACHINE_BIT);
            machineIdPart = (localIp & maxMachineId) << SEQUENCE_BIT;
        }

        /**
         * 获取雪花ID
         */
        public synchronized long nextId() {
            long currentStamp = timeGen();
            //避免机器时钟回拨
            while (currentStamp < lastStamp) {
                // 服务器时钟被调整了,ID生成器停止服务.
                throw new RuntimeException(String.format("时钟已经回拨.  Refusing to generate id for %d milliseconds", lastStamp - currentStamp));
            }
            if (currentStamp == lastStamp) {
                // 最大序列号  （4095）
                long maxSequence = ~(-1L << SEQUENCE_BIT);
                sequence = (sequence + 1) & maxSequence;
                // 毫秒内序列溢出
                if (sequence == 0) {
                    // 阻塞到下一个毫秒,获得新的时间戳
                    currentStamp = getNextMill();
                }
            } else {
                //不同毫秒内，序列号置0
                sequence = 0L;
            }
            lastStamp = currentStamp;
            // 时间戳位移位数 时间戳部分+机器标识部分+序列号部分
            long timeStampLeft = SEQUENCE_BIT + MACHINE_BIT;
            // 起始的时间戳
            long startTimeStamp = 157489395327L;
            return (currentStamp - startTimeStamp) << timeStampLeft | machineIdPart | sequence;
        }

        /**
         * 阻塞到下一个毫秒，直到获得新的时间戳
         */
        private long getNextMill() {
            long mill = timeGen();
            //
            while (mill <= lastStamp) {
                mill = timeGen();
            }
            return mill;
        }

        /**
         * 返回以毫秒为单位的当前时间
         */
        protected long timeGen() {
            return System.currentTimeMillis();
        }
    }

    /**
     * 获取long类型雪花ID
     */
    public static long uniqueLong() {
        return SnowIdUtils.SnowFlake.SNOW_FLAKE.nextId();
    }

    /**
     * 获取String类型雪花ID
     */
    public static String uniqueLongHex() {
        return String.format("%016x", uniqueLong());
    }

    /**
     * test
     */
    public static void main(String[] args) throws InterruptedException {
        //计时开始时间
        long start = System.currentTimeMillis();
        //让100个线程同时进行
        final CountDownLatch latch = new CountDownLatch(100);
        //判断生成的20万条记录是否有重复记录
        final Map<String, Integer> map = new ConcurrentHashMap();
        for (int i = 0; i < 100; i++) {
            //创建100个线程
            new Thread(() -> {
                for (int s = 0; s < 2000; s++) {
                    String snowId = SnowIdUtils.uniqueLongHex();
                    System.out.println("生成雪花ID=" + snowId);
                    Integer put = map.put(snowId, 1);
                    if (put != null) {
                        throw new RuntimeException("主键重复");
                    }
                }
                latch.countDown();
            }).start();
        }
        //让上面100个线程执行结束后，在走下面输出信息
        latch.await();
        System.out.println("生成20万条雪花ID总用时=" + (System.currentTimeMillis() - start));
    }
}
```

### 6.Lettuce Redis
#### 6-1 引入 jar 包
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>
<!-- Lettuce 缺少 Common-Pool 依赖 -->
    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-pool2</artifactId>
        <version>2.8.1</version>
    </dependency>
</dependencies>
```
#### 6-2 yml文件配置
```yaml
spring:
  redis:
    database: 0
    host: 127.0.0.1
    port: 6379
    password: root
    timeout: 3000
    lettuce:
      pool:
        max-active: 8
        max-idle: 8
        min-idle: 0
        max-wait: -1
```
#### 6-3 配置类
```java
@Configuration
public class LettuceRedisConfig {
    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }
}
```

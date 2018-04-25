## @Cacheable
### cacheNames：
指定缓存的名称
### key：
定义组成的key值，如果不定义，则使用全部的参数计算一个key值。可以使用spring El表达式

### keyGenerator：
定义key生成的类，和key的不能同时存在

### sync：
如果设置sync=true：a. 如果缓存中没有数据，多个线程同时访问这个方法，则只有一个方法会执行到方法，其它方法需要等待; b. 如果缓存中已经有数据，则多个线程可以同时从缓存中获取数据

### condition和unless
 只满足特定条件才进行缓存： 
condition: 在执行方法前，condition的值为true，则缓存数据
unless ：在执行方法后，判断unless ，如果值为true，则不缓存数据
conditon和unless可以同时使用，则此时只缓存同时满足两者的记录

## @CacheEvict

删除缓存

### allEntries
allEntries = true: 清空缓存里的所有值
allEntries = false: 默认值，此时只删除key对应的值


## @CachePut

每次执行都会执行方法，无论缓存里是否有值，同时使用新的返回值的替换缓存中的值。这里不同于@Cacheable：@Cacheable如果缓存没有值，从则执行方法并缓存数据，如果缓存有值，则从缓存中获取值

## @CacheConfig

@CacheConfig: **类级别**的注解：如果我们在此注解中定义cacheNames，则此类中的所有方法上 @Cacheable的cacheNames默认都是此值。当然@Cacheable也可以重定义cacheNames的值
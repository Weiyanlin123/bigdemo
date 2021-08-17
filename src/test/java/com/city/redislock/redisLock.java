package com.city.redislock;



/**
 * @author weiyl
 * @date 2021/4/6 17:13
 */
public class redisLock {
    public static void main(String[] args) {
//        // 1.构造redisson实现分布式锁必要的Config
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setPassword("123456").setDatabase(0);
//// 2.构造RedissonClient
//        RedissonClient redissonClient = Redisson.create(config);
//// 3.获取锁对象实例（无法保证是按线程的顺序获取到）
//        RLock rLock = redissonClient.getLock(lockKey);
//        try {
//            /**
//             * 4.尝试获取锁
//             * waitTimeout 尝试获取锁的最大等待时间，超过这个值，则认为获取锁失败
//             * leaseTime   锁的持有时间,超过这个时间锁会自动失效（值应设置为大于业务处理的时间，确保在锁有效期内业务能处理完）
//             */
//            boolean res = rLock.tryLock((long)1000, (long)1000, TimeUnit.SECONDS);
//            if (res) {
//                //成功获得锁，在这里处理业务
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("aquire lock fail");
//        }finally{
//            //无论如何, 最后都要解锁
//            rLock.unlock();
//        }
    }
}

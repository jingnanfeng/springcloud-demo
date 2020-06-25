package cn.com.nanfeng.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liutao
 * @Title InitThreadPool
 * @Description 通用线程池，用于异步执行写操作不影响主线程
 * @date 2020-06-11 11:03
 */
@Configuration
@EnableAsync
public class InitThreadPool {

    /**
     * 线程池维护线程的最小数量
     */
    private static final int CORE_POOL_SIZE = 10;
    /**
     * 最大线程数
     */
    private static final int MAX_POOL_SIZE = 50;

    /**
     * 缓存队列
     */
    private static final int QUEUE_CAPACITY = 10;

    /**
     * 允许的空闲时间
     */
    private static final int KEEP_ALIVE = 60;

    @Bean
    public Executor myExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(CORE_POOL_SIZE);
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setQueueCapacity(QUEUE_CAPACITY);
        executor.setThreadNamePrefix("executor-");
        /**
         * 使用此策略，如果添加到线程池失败，那么主线程会自己执行该任务，不会等待线程池的线程去执行
         */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setKeepAliveSeconds(KEEP_ALIVE);
        executor.initialize();
        return executor;
    }
}

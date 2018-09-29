package com.abosen.demo.spring.aop.springaop;

import com.abosen.demo.spring.aop.monitor.PerformanceMonitor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import java.lang.reflect.Method;

/**
 * @author qiubaisen
 * @date 2018/9/29
 */
public class IntroductionMonitor extends DelegatingIntroductionInterceptor implements Monitorable {
    /**
     * 引介增强可以为目标类创建实现某接口的代理
     * 这里实现了一个可以开关的监测接口
     */
    private ThreadLocal<Boolean> monitorStateMaps = new ThreadLocal<>();

    @Override
    public void setMonitorState(boolean active) {
        monitorStateMaps.set(active);
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object res = null;
        if (monitorStateMaps.get() != null && monitorStateMaps.get() && !isMonitorSetMethod(mi.getMethod())) {
            // 开启性能监测
            String info = mi.getThis().getClass().getName() + "." + mi.getMethod().getName();
            PerformanceMonitor.begain(info);
            res = super.invoke(mi);
            PerformanceMonitor.end();
        } else {
            res = super.invoke(mi);
        }

        return res;
    }

    private boolean isMonitorSetMethod(Method method) {
        boolean classMatch = Monitorable.class.isAssignableFrom(method.getDeclaringClass());
        boolean methodMatch = "setMonitorState".equals(method.getName()) &&
                method.getParameterCount() == 1 &&
                boolean.class.equals(method.getParameterTypes()[0]);
        /**
         * 目标方法为 Monitorable 接口方法，且方法签名 setMonitorState(boolean)
         * 因为 setMonitorState 也被 代理了，可以通过切面解决
         * 切面单独写例子，这里偷懒
         */
        return classMatch && methodMatch;
    }
}

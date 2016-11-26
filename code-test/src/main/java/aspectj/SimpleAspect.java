package aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by emirbobo on 2016/11/26.
 */
@Component
@Aspect
public class SimpleAspect {

    @Pointcut("execution(* aspectj.*Service.*(..))")
    public String pointCut() {
        return "pointCut......";
    }

    @After("pointCut()")
    public void after(JoinPoint  joinPoint) {
        System.out.println("after aspect executed");
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        //如果需要这里可以取出参数进行处理
        //Object[] args = joinPoint.getArgs();
        System.out.println("before aspect executing");
    }

    @AfterReturning(pointcut = "pointCut()", returning = "returnVal")
    public void afterReturning(JoinPoint joinPoint, Object returnVal) {
//        returnVal = "addPerson success afterReturning value replaced.........";
        System.out.println("afterReturning executed, return result is "
                + returnVal);
    }

    @Around("pointCut()") //在方法入参的时候替换入参对象，使用自己定义的对象
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around start..");
        try {
            pjp.proceed(new Object[]{new NewObject()});
        } catch (Throwable ex) {
            System.out.println("error in around");
            throw ex;
        }
        System.out.println("around end");
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "error")
    public void afterThrowing(JoinPoint jp, Throwable error) {
        System.out.println("error:" + error);
    }
}

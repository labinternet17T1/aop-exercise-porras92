package cat.tecnocampus.aop;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
@Component
public class LoggerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(LoggerAdvice.class);

    @Pointcut("execution(* cat.tecnocampus.controller.ControllerClassRoom.*(..))")

    public void pointcutClassroom() {logger.info("POINTCUT1.-Going to get a classroom method");}

    @Before("pointcutClassroom()")
    public void beforeListClassroom(){logger.info("Working with a classroom");}



    @Pointcut("execution(* cat.tecnocampus.controller.ControllerClassRoom.find*(..))")

    public void pointcutFind() {logger.info("POINCUT2.-Going to show a method with find word");}

    @After("pointcutFind()")
    public void afterListClassroom(){logger.info("Finding classrooms");}



    @Pointcut("execution(* cat.tecnocampus.controller.ControllerClassRoom.insertBatch(..))")

    public void pointcutBach() {logger.info("Insterting a batch");}


    @Around("pointcutBach()")

    public int[] dealRequestParam(ProceedingJoinPoint jp) {

        try {
            logger.info("Before showing classrooms");

            int[] res = (int[])jp.proceed();
            logger.info("After showing classrooms");
            return res;
        } catch (Throwable throwable) {
            logger.info("Showing notes: Something went wrong");
            throwable.printStackTrace();
            return new int[]{};
        }
    }

}
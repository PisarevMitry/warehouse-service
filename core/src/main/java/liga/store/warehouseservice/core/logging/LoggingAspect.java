package liga.store.warehouseservice.core.logging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.store.warehouseservice.core.model.entity.LogEntity;
import liga.store.warehouseservice.core.repository.LogRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Autowired
    LogRepository logRepository;

   /* @Pointcut("within (liga.medical.personservice.core.controller.LoginController)")
    public void loginController() {
    }*/

    /**
     *
     */
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restController() {
    }
/*

    @Around("loginController()")
    public Object loginControllerLogger(ProceedingJoinPoint pjp) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        PersonDataEntity personDataEntity = (PersonDataEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Object[] array = pjp.getArgs();

        LogEntity logEntityBefore = new LogEntity(LocalDateTime.now(), methodName, className, personDataEntity.getUsername());
        log.info(
                logEntityBefore.getCreateDttm() + " Начата авторизация: " + logEntityBefore.getClassName() + ":" +
                        logEntityBefore.getMethodName() + " ()" + " с аргументами" + mapper.writeValueAsString(
                        array) + logEntityBefore.getUserName());
        logRepository.insert(logEntityBefore);

        Object object = null;
        try {
            object = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        LogEntity logEntityAfter = new LogEntity(LocalDateTime.now(), methodName, className, personDataEntity.getUsername());
        log.info(
                logEntityAfter.getCreateDttm() + " Закончена авторизация: " + logEntityAfter.getClassName() + ":" +
                        logEntityAfter.getMethodName() + " ()" + " с аргументами" + mapper.writeValueAsString(
                        array) + logEntityAfter.getUserName());
        logRepository.insert(logEntityAfter);

        return object;
    }
*/

    @Around("restController()")
    public Object restControllerLogger(ProceedingJoinPoint pjp) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();

        Object[] array = pjp.getArgs();

        LogEntity logEntityBefore = new LogEntity(null, LocalDateTime.now(), methodName, className, "UserEntity.getUsername()");
        log.info(
                logEntityBefore.getCreateDttm() + " Вызван метод: " + logEntityBefore.getClassName() + "." +
                        logEntityBefore.getMethodName() + " ()" + " с аргументами" + mapper.writeValueAsString(
                        array) + " Пользователем " + logEntityBefore.getUserName());
        logRepository.insert(logEntityBefore);

        Object object = null;
        try {
            object = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        LogEntity logEntityAfter = new LogEntity(null, LocalDateTime.now(), methodName, className, "UserEntity.getUsername()");
        log.info(
                logEntityAfter.getCreateDttm() + " Завершен метод : " + logEntityAfter.getClassName() + "." +
                        logEntityAfter.getMethodName() + " ()" + " с аргументами" + mapper.writeValueAsString(
                        array) + " Пользователем " + logEntityAfter.getUserName());
        logRepository.insert(logEntityAfter);

        return object;
    }

}
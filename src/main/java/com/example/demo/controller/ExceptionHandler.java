package com.example.demo.controller;

import com.example.demo.UnProcessableException;
import com.example.demo.model.MessageInfo;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// AOP
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(UnProcessableException.class)
    public ResponseEntity<MessageInfo> handleUnprocessableException(UnProcessableException e) {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode("1003");
        messageInfo.setDescription(e.getMessage());

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(messageInfo);
    }
}

@Aspect
@Service
class LoggingAspect {
    @Before(
            "execution(* xxx.api..*(..)) "
                    + "&& !execution(* rest.app.api.PingApiController..*(..))")
    public void logBeforeController() {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        String name = joinPoint.getTarget().getClass().getCanonicalName();
//        Method method = signature.getMethod();
//        log.info(
//                String.format(">>>>>>>>>> Enter controller : %s , method : %s", name, method.getName()));
    }
}

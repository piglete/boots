package com.bych.aspect;


import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: lxl
 * Date: 2019-05-10
 * Time: 8:52
 * Description:
 */
//@Aspect
//@Component
//@Configuration
/*
public class LogAspect {

    private ByBLogManager byBLogManager;
    private BySUserInformationManager bySUserInformationManager;

    public LogAspect(ByBLogManager byBLogManager,
                     BySUserInformationManager bySUserInformationManager) {
        this.byBLogManager = byBLogManager;
        this.bySUserInformationManager = bySUserInformationManager;
    }

    */
/**
     * 日志截取，增加/修改（编辑），删除的日志记录，并根据@ApiOperation的value值记录
     *//*

    @After("execution(* com.bych.controller.*.*edit*(..)) || execution(* com.bych.controller.*.*remove*(..))")
    public void logAspect(JoinPoint joinPoint) {
        String[] servletRequest = getServletRequest();
        BySUserInformation bySUserInformation = bySUserInformationManager.simpleSearch(servletRequest[0], servletRequest[1]);
        if (bySUserInformation != null) {
            String annotationValue = getAnnotationValue(joinPoint);
            String moduleName = "";
            String operationName = "";
            try {
                String[] str = annotationValue.split("-");
                moduleName = str[0].trim();
                operationName = str[1].trim();
            }catch (Exception e){
                moduleName="模块异常";
                operationName="操作异常";
            }
            ByBLog sysLog = new ByBLog();
            sysLog.setId(null);
            sysLog.setLoginName(servletRequest[0]);
            sysLog.setModuleName(moduleName);
            sysLog.setOperationName(operationName);
            sysLog.setIp(servletRequest[2]);
            byBLogManager.upperSave(sysLog);
        }
    }

    public String[] getServletRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String loginName = request.getHeader("loginName");
        String password = request.getHeader("password");
        String ip = request.getHeader("ip");
        return new String[]{loginName, password, ip};
    }

    private String getAnnotationValue(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        ApiOperation annotation = method.getAnnotation(ApiOperation.class);
        return annotation.value();
    }
}
*/

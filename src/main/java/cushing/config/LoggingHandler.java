package cushing.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Slf4j

@Aspect
@Component
public class LoggingHandler {

	@Autowired private ObjectMapper objectMapper;

	@Pointcut(value = "@annotation(cushing.Loggable)")
	public void methodLoggable() {}

	@Before("methodLoggable()")
	public void getInformation(JoinPoint joinPoint) throws JsonProcessingException {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		String params = objectMapper.writeValueAsString(joinPoint.getArgs());

		log.info("ip-address "+request.getRemoteAddr());
		log.info("name "+request.getRemoteUser());
		log.info("URL "+request.getRequestURL().toString());
		log.info("Body "+ params);
		log.info("Time " + ((new Date( request.getSession().getCreationTime()))));
		log.info("HTTP-method "+joinPoint.getSignature().getName());
	}

}

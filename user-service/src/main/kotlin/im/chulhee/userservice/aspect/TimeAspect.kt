package im.chulhee.userservice.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import kotlin.system.measureTimeMillis


@Component
@Aspect
class TimeAspect {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @Around("execution(* im.chulhee.userservice..*.*(..))")
    fun checkMethodTime(joinPoint: ProceedingJoinPoint): Any? {
        val result: Any?
        val elapsed: Long = measureTimeMillis {
            result = joinPoint.proceed()
        }

        val className = joinPoint.target.javaClass.name.substringAfterLast(".")
        val methodName = joinPoint.signature.name

        logger.info("Time : $className $methodName elapsed : $elapsed ms")
        return result

    }
}

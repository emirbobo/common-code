package springioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import util.UtilLog;

/**
 * Created by Mtime on 2016/12/23.
 */
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AutoConfigTest {

    UtilLog utilLog ;

    @Bean
    public UtilLog utilLog(){
        utilLog = new UtilLog();
        return utilLog;
    }
}

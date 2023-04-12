package kr.co.softsoldesk.conifg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import kr.co.softsoldesk.beans.DataBean1;
import kr.co.softsoldesk.beans.DataBean2;

//프로젝트 bean
@Configuration
public class RootAppContext {

	@Bean
	@RequestScope //@RequestScope : 새로운 요청정보 때 적용
	public DataBean1 dataBean1() {
		return new DataBean1();
	}
	@Bean("requestBean2")
	@RequestScope //@RequestScope : 새로운 요청정보 때 적용
	public DataBean2 dataBean2() {
		return new DataBean2();
	}
}

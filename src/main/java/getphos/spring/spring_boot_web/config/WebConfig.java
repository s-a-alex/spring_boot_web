package getphos.spring.spring_boot_web.config;

import getphos.spring.spring_boot_web.util.DateFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

@Configuration
@ComponentScan(basePackages = {"getphos.spring.spring_boot_web.web"})
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebConfig implements WebMvcConfigurer/*, ApplicationContextAware*/ {

	//Определяет простые автоматизированные контроллеры, предварительно сконфигурированные с ответным кодом состояния и/или представлением
	//для воспроизведения тела ответа. Такие представления не содержат логику контроллера и служат для воспроизведения приветственной страницы,
	//выполнения простых видов переадресации веб-сайтов по URL, возврата кода состояния 4О4 и прочих действий.
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/login").setViewName("login");
	}

	@Override
	public void addFormatters(FormatterRegistry formatterRegistry) {
		formatterRegistry.addFormatter(dateFormatter());
	}

	@Bean
	public DateFormatter dateFormatter() {
		return new DateFormatter();
	}

	// Регистрация перехватчиков
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	// В классе LocaleChangeinterceptor из модуля Spring MVC определяется перехватчик всех запросов к сервлету диспетчера типа DispatcherServlet.
	// Этот перехватчик поддерживает смену региональных настроек с помощью настраиваемого параметра запроса. В конфигурации этого перехватчика
	// определяется параметр URL под именем lang для смены региональных настроек веб-приложения. Например, http://localhost:8080/singers?lang=zh_HK
	@Bean
	LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}

	// В классе CookieLocaleResolver поддерживается хранение и извлечение региональных настроек из сооkiе-файла пользовательского браузера.
	@Bean
	CookieLocaleResolver localeResolver() {
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
		cookieLocaleResolver.setCookieMaxAge(3600);
		cookieLocaleResolver.setCookieName("locale");
		return cookieLocaleResolver;
	}
}

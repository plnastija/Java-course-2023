package lt.anastasija.BaigiamasisProjektas.controller;

import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Darbo paieška");
        model.addAttribute("data", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
        return "home";
    }

    @GetMapping("/abaut")
    public String abaut(Model model) {
        model.addAttribute("title", "Mano kontaktai");
        return "abaut";

    }
    @Bean
    public LocaleResolver localeResolver(){
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(Locale.US);
        return cookieLocaleResolver;

    }

}
package org.avatao.springcsrf.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * A HTTP kapcsolat biztonságáért felelős, a különböző oldalak elérésének jogosultságait kezeli 
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest().fullyAuthenticated() //Bármilyen lekérés autentikációhoz kötött [kiv.-ek mindjárt]
            .and().formLogin().loginPage("/login") //definiáljuk az (alapértelmezett) loginpage nézetet
            	.failureUrl("/login?error").permitAll() //hibás bejelentkezés esetén - mindenkinek engedélyezett
            .and().logout().permitAll() //a kijelentkezés mindenkinek engedélyezett
            .and().logout()
            	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            	.logoutSuccessUrl("/login"); //kijelentkezés után ide dob
    }

    /**
     * Itt a felhasználókat lehet definiálni, illetve azoknak a jogosultságát, szerepköreit, stb.
     * Ezt lehet akár adatbázisból is kikérni, mert a AuthenticationManagerBuilder biztosít API-t hozzá, 
     * most explicit definiáljuk, mert a feladat ezt nem igényelte, így belső memóriába írtuk bele.
     */
    @Override 
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication() 
                .withUser("admin")
                .password("admin")
                .roles("ADMIN", "USER");
    }

}
package com.springbootdemo.springboot.component;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/*
   可以在连接上携带区域信息
 */
public class MyLocaleResolver implements LocaleResolver
{
    @Override
    public Locale resolveLocale(HttpServletRequest Request) {
        String l=Request.getParameter("l");
        Locale locale=Locale.getDefault();
        if(!StringUtils.isEmpty(l))
        {
            String [] spilt=l.split("_");
            locale=new Locale(spilt[0],spilt[1]);
        }
        return  locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, @Nullable HttpServletResponse httpServletResponse, @Nullable Locale locale) {

    }
}

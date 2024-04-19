package com.api_customQueries02.api_customQueries02.Interceptors;

import com.api_customQueries02.api_customQueries02.Entities.Month;
import io.micrometer.common.lang.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Component
public class MonthInterceptor implements HandlerInterceptor {
    private List<Month> months = new ArrayList<>();

    public MonthInterceptor(){
        months.add(new Month(1, "January", "Gennaio", "Januar"));
        months.add(new Month(2, "February", "Febbraio", "Februar"));
        months.add(new Month(3, "March", "Marzo", "Maggio"));
        months.add(new Month(4, "April", "Aprile", "Agosto"));
        months.add(new Month(5, "May", "Maggio", "Giugno"));
        months.add(new Month(6, "June", "Giugno", "Luglio"));
    }
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumber = request.getHeader("monthNumber");
        if (monthNumber == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST,"Il mese non è presente");
            return false;
        }if (monthNumber.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "E' vuoto");
            return false;
        }  Month month = find(Integer.valueOf(monthNumber));
        request.setAttribute("month", Objects.requireNonNullElseGet(month, () -> new Month(null, "nope", "nope", "nope")));
        response.setStatus(HttpStatus.OK.value());
        return true;


    }

    private Month find(Integer integer) {
        for (Month month : months) {
            if (month.getMonthNumber().equals(integer)) {
                return month;
            }
        }
        return null;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object
            handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object
            handler, @Nullable Exception ex) throws Exception {
    }
}
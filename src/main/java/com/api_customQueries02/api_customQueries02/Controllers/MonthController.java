package com.api_customQueries02.api_customQueries02.Controllers;

import com.api_customQueries02.api_customQueries02.Entities.Month;
import com.api_customQueries02.api_customQueries02.Services.MonthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/month")
public class MonthController {
    @Autowired
    private MonthService monthService;

    @GetMapping
    public Month getMonth(HttpServletRequest request) {
        Month month = (Month) request.getAttribute("monthNumber");
        return month;
    }
}

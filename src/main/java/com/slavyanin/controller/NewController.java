package com.slavyanin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class NewController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView mav = new ModelAndView("/hello.jsp");

        try {
            String login = httpServletRequest.getParameter("login");
            String password = httpServletRequest.getParameter("password");

            String wrong = "Wrong login or password. Or You aren`t client our BANK";

            mav.addObject("login", login);
            mav.addObject("password", password);
            mav.addObject("result", wrong);

        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        return mav;
    }
}

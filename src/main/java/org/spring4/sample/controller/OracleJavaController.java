package org.spring4.sample.controller;

import org.spring4.sample.dao.MyEmpDao;
import org.spring4.sample.model.MyEmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OracleJavaController {

    @Autowired
    private MyEmpDao myEmpDao;

    @RequestMapping(value="/hibernate4")
    public String doAction(ModelMap model) {
        List<MyEmp> list = myEmpDao.list();
        model.addAttribute("emplist", list);
        return "oraclejavacommunity";
    }
}

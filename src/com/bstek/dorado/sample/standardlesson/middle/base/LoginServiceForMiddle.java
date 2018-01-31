package com.bstek.dorado.sample.standardlesson.middle.base;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.sample.standardlesson.dao.SlEmployeeDao;
import com.bstek.dorado.sample.standardlesson.entity.SlEmployee;
import com.bstek.dorado.web.DoradoContext;
@Component
public class  LoginServiceForMiddle {
    @Resource
    private SlEmployeeDao slEmployeeDao;
     
    @Expose
    public Map doLogout(){
        DoradoContext ctx = DoradoContext.getCurrent();
        HttpServletRequest request = request = ctx.getRequest();
        request.getSession().setAttribute("user", null);
        Map result = new HashMap();
        result.put("url", "com.bstek.dorado.sample.standardlesson.middle.base.Login.d");
        result.put("result", true);
        return result;
    }
     
    @Expose
    @Transactional
    public void changePassWord(String newPassWord){
        DoradoContext dc = DoradoContext.getCurrent();
        HttpSession session = dc.getRequest().getSession();
        SlEmployee employee = (SlEmployee)session.getAttribute("user");
        employee.setPassword(newPassWord);
        slEmployeeDao.getSession().update(employee);
    }
}

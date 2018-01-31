package com.bstek.dorado.sample.standardlesson.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.sample.standardlesson.dao.SlEmployeeDao;
import com.bstek.dorado.sample.standardlesson.entity.SlEmployee;
import com.bstek.dorado.web.DoradoContext;
 
@Component
public class LoginService {
    @Resource
    private SlEmployeeDao slEmployeeDao;
 
    @Expose
    public Map doLogin(Map param) {
        String username = (String) param.get("username");
        String password = (String) param.get("password");
        Map result = new HashMap();
        if (isValid(username, password)) {
            // 设置验证成功需要跳转的页面
            result.put("url",
                    "com.bstek.dorado.sample.standardlesson.junior.main.Main.d");
            result.put("result", true);
            return result;
        } else {
            String errormsg = "用户名或者密码不正确";
            result.put("errormsg", errormsg);
            result.put("result", false);
            return result;
        }
    }
 
    // 以下方法需要替换为自己的验证用户名密码的业务逻辑
    public boolean isValid(String username, String password) {
        DetachedCriteria dc = DetachedCriteria.forClass(SlEmployee.class);
        if (username != null && !"".equals(username)) {
            dc.add(Restrictions.eq("userName", username.toUpperCase()));
        }
        List<SlEmployee> employees = slEmployeeDao.find(dc);
        if (employees.size() > 0) {
            SlEmployee employee = employees.get(0);
            if (password.equals(employee.getPassword())) {
                // 验证成功后将用户信息放入session中
                DoradoContext ctx = DoradoContext.getCurrent();
                HttpServletRequest request = request = ctx.getRequest();
                request.getSession().setAttribute("user", employee);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
 
    @Expose
    public Map doLogout() {
        DoradoContext ctx = DoradoContext.getCurrent();
        HttpServletRequest request = ctx.getRequest();
        request.getSession().setAttribute("user", null);
        Map result = new HashMap();
        result.put("url",
                "com.bstek.dorado.sample.standardlesson.junior.base.Login.d");
        result.put("result", true);
        return result;
    }
}


package com.bstek.dorado.sample.standardlesson.service;
 
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
 
import org.hibernate.annotations.common.util.StringHelper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;
import com.bstek.dorado.sample.standardlesson.dao.SlDeptDao;
import com.bstek.dorado.sample.standardlesson.dao.SlEmployeeDao;
import com.bstek.dorado.sample.standardlesson.entity.SlDept;
import com.bstek.dorado.sample.standardlesson.entity.SlEmployee;
 
@Component
public class DeptService {
    @Resource
    private SlDeptDao slDeptDao;
     
    @Resource
    private SlEmployeeDao slEmployeeDao;
     
    @DataProvider
    public Collection<SlDept> getTopDept(){
        return slDeptDao.find("from SlDept where slDept.deptId is null");
    }
     
    @DataProvider
    public Collection<SlDept> getDeptByParentId(Integer parentId){
        if(null != parentId){
            String hql = "from SlDept where slDept.deptId = :deptId";
            Map param = new HashMap();
            param.put("deptId", parentId);
            return slDeptDao.find(hql, param);
        }else{
            return null;
        }
    }
     
    @DataResolver
    @Transactional
    public void saveAll(Collection<SlDept> depts){
        for(SlDept dept:depts){
            slDeptDao.persistEntity(dept);
            Collection<SlDept> childs = dept.getSlDeptSet();
            if(!(childs ==  null)){
                for(SlDept child:childs){
                    //维护关联关系
                    child.setSlDept(dept);
                }
                slDeptDao.persistEntities(childs);
                saveAll(childs);
            }
        }
    }
     
    @DataProvider
    public void getEmployeeByDeptId(Page<SlEmployee> page, Integer deptId){
        if(null !=  deptId){
            String hql = "from SlEmployee where slDept.deptId = :deptId";
            Map param = new HashMap();
            param.put("deptId", deptId);
            slEmployeeDao.find(page, hql, param);
        }        
    }
     
    @DataProvider
    public Collection<SlDept> getAll(){
        return slDeptDao.getAll();
    }
     
    @DataProvider
    public Collection<SlDept> getDeptByDeptName(String deptName){
        String hql = "from SlDept where deptName like :deptName";
        Map param = new HashMap();
        if(StringHelper.isNotEmpty(deptName)){
            param.put("deptName", "%"+deptName+"%");
            return slDeptDao.find(hql, param);
        }else{
            return slDeptDao.getAll();
        }
         
    }
}
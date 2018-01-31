package com.bstek.dorado.sample.standardlesson.service;
 
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.sample.standardlesson.dao.SlMenuDao;
import com.bstek.dorado.sample.standardlesson.entity.SlMenu;
 
@Component
public class MenuService {
    @Resource
    private SlMenuDao slMenuDao;
     
    @DataProvider
    public Collection<SlMenu> getTopMenu(){
        return slMenuDao.find("from SlMenu where slMenu.menuId is null");
    }
     
    @DataProvider
    public Collection<SlMenu> getMenuByParentId(Integer parentId){
        if(null != parentId){
            String hql = "from SlMenu where slMenu.menuId = :menuId";
            Map param = new HashMap();
            param.put("menuId", parentId);
            return slMenuDao.find(hql, param);
        }else{
            return null;
        }
    }
     
    @DataResolver
    @Transactional
    public void saveAll(Collection<SlMenu> menus){
        for(SlMenu menu:menus){
            slMenuDao.persistEntity(menu);
            Collection<SlMenu> childs = menu.getSlMenuSet();
            if(!(childs ==  null)){
                for(SlMenu child:childs){
                    //维护关联关系
                    child.setSlMenu(menu);
                }
                slMenuDao.persistEntities(childs);
                saveAll(childs);
            }
        }
    }
}
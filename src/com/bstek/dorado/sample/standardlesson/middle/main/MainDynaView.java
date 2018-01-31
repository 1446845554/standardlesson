package com.bstek.dorado.sample.standardlesson.middle.main;
 
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.bstek.dorado.common.event.DefaultClientEvent;
import com.bstek.dorado.sample.standardlesson.dao.SlMenuDao;
import com.bstek.dorado.sample.standardlesson.entity.SlMenu;
import com.bstek.dorado.view.widget.base.menu.MenuItem;
import com.bstek.dorado.view.widget.base.toolbar.MenuButton;
import com.bstek.dorado.view.widget.base.toolbar.ToolBar;
 
@Component
public class MainDynaView {
    @Resource
    private SlMenuDao slMenuDao;
     
    /**
     * 动态生成toolbar中的MenuButton以及以下的MenuItem
     * @param toolbarMenu
     */
    public void beforeToolBarInit(ToolBar toolbarMenu){
        //通过slMenuDao获取后台菜单数据
        Collection<SlMenu> menus = getMenuByParentId(null);
        for(SlMenu menu:menus){
            MenuButton mb = new MenuButton();
            mb.setCaption(menu.getMenuName());
            Collection<SlMenu> childs = getMenuByParentId(menu.getMenuId());
            for(SlMenu child:childs){
                MenuItem mi = new MenuItem();
                mi.setCaption(child.getMenuName());
                mi.setIcon(child.getIcon());
                if("登出".equals(child.getMenuName())){
                    mi.addClientEventListener("onClick", new DefaultClientEvent("view.get('#dialogLogout').show();"));
                }else{
                    mi.setTags("menuitem");
                    mi.setUserData(child.getUrl());
                }
                mb.addItem(generateMenuItem(mi,child));
            }
            toolbarMenu.addItem(mb);
        }
    }
     
    /**
     * 获取叶子菜单
     * @param mi
     * @param menu
     * @return
     */
    private MenuItem generateMenuItem(MenuItem mi,SlMenu menu){
        Collection<SlMenu> childs = getMenuByParentId(menu.getMenuId());
        for(SlMenu child:childs){
            MenuItem michild = new MenuItem();
            michild.setCaption(child.getMenuName());
            michild.setIcon(child.getIcon());
            michild.setTags("menuitem");
            michild.setUserData(child.getUrl());
            generateMenuItem(michild,child);
            mi.addItem(michild);
        }
        return mi;
    }
     
    private Collection<SlMenu> getMenuByParentId(Integer parentId){
        if(null != parentId){
            String hql = "from SlMenu where slMenu.menuId = :menuId order by showOrder";
            Map param = new HashMap();
            param.put("menuId", parentId);
            return slMenuDao.find(hql, param);
        }else{
            return slMenuDao.find("from SlMenu where slMenu.menuId is null");
        }
    }
}

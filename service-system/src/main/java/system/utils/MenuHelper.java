package system.utils;

import com.sun.deploy.panel.ITreeNode;
import model.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

public class MenuHelper {
    //构建树形结构
    public static List<SysMenu> buildTree(List<SysMenu> sysMenuList) {
        //创建一个集合封装最终数据
        List<SysMenu> trees = new ArrayList<>();
        //遍历所有菜单的集合
        for (SysMenu sysMenu:sysMenuList){
            //找到递归的入口
            if (sysMenu.getParentId()==0){
                trees.add(findChildren(sysMenu,sysMenuList));
            }
        }
        return trees;
    }
    //从根节点进行递归查询,查询子节点
    //判断id = parentid是否相同,如果是,则是子节点,进行数据封装
    private static SysMenu findChildren(SysMenu sysMenu, List<SysMenu> treeNodes) {
        //进行数据初始化
        sysMenu.setChildren(new ArrayList<>());
        //遍历递归查找
        for(SysMenu it:treeNodes){
            //获取当前菜单id
            //String id = sysMenu.getId();
            //Long cid = Long.parseLong(id);
            //获取所有菜单parentid
            //Long parentId = it.getParentId();
            //比对
            if(Long.parseLong(sysMenu.getId()) == it.getParentId()){
                if(sysMenu.getChildren()==null){
                    sysMenu.setChildren(new ArrayList<>());
                }
                sysMenu.getChildren().add(findChildren(it,treeNodes));
            }
        }
        return sysMenu;
    }
}

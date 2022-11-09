package system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import model.system.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author atguigu
 * @since 2022-11-09
 */
public interface SysMenuService extends IService<SysMenu> {
    //菜单列表(树形)
    List<SysMenu> findNodes();
    //删除菜单
    void removeMenuById(String id);
}

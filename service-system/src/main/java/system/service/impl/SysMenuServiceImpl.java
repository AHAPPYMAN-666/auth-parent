package system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import common.result.Result;
import model.system.SysMenu;
import system.exception.DingZhenExpection;
import system.mapper.SysMenuMapper;
import system.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import system.utils.MenuHelper;

import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2022-11-09
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Override
    public List<SysMenu> findNodes() {
        //获取所有菜单
        List<SysMenu> sysMenuList = baseMapper.selectList(null);
        //所有菜单数据转换为要求数据格式
        return MenuHelper.buildTree(sysMenuList);
    }

    @Override
    public void removeMenuById(String id) {
        //查询当前删除菜单下面是否有子菜单
        //根据id==parentid
        QueryWrapper<SysMenu> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);
        Integer count = baseMapper.selectCount(wrapper);
        //判断是否有子菜单
        if (count>0){
            throw new DingZhenExpection(201,"请先删除子菜单");
        }
        //调用删除方法
        baseMapper.deleteById(id);

    }
}

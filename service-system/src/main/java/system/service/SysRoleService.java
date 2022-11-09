package system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import model.system.SysRole;
import model.vo.AssginRoleVo;
import model.vo.SysRoleQueryVo;

import java.util.Map;

public interface SysRoleService extends IService<SysRole> {
    //条件分页查询
    IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo sysRoleQueryVo);
    //获取用户角色数据
    Map<String, Object> getRoleByUserId(String userId);

    void doAssign(AssginRoleVo assginRoleVo);
}

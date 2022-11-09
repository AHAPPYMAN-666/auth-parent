package system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import model.system.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import model.vo.SysUserQueryVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author atguigu
 * @since 2022-11-07
 */
public interface SysUserService extends IService<SysUser> {
    //用户列表
    IPage<SysUser> selectPage(Page<SysUser> pageParam, SysUserQueryVo sysUserQueryVo);
    //更改用户状态
    void updateStatus(String id,Integer status);
}

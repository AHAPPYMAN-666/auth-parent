package system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import model.system.SysUser;
import model.vo.SysUserQueryVo;
import system.mapper.SysUserMapper;
import system.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2022-11-07
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public IPage<SysUser> selectPage(Page<SysUser> pageParam, SysUserQueryVo sysUserQueryVo) {
        return baseMapper.selectPage(pageParam,sysUserQueryVo);
    }
    //更改用户状态
    @Override
    public void updateStatus(String id, Integer status) {
        SysUser sysUser = baseMapper.selectById(id);
        sysUser.setStatus(status);
        baseMapper.updateById(sysUser);

    }
}

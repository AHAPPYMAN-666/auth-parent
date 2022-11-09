package system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import model.system.SysUser;
import model.vo.SysUserQueryVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author atguigu
 * @since 2022-11-07
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    IPage<SysUser> selectPage(Page<SysUser> pageParam, @Param("vo") SysUserQueryVo sysUserQueryVo);

}

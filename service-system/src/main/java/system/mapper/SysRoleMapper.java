package system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import model.system.SysRole;
import model.vo.SysRoleQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
//BaseMapper里面封装了很多SQL语句
public interface SysRoleMapper extends BaseMapper<SysRole> {
    //条件分页查询
    IPage<SysRole> selectPage(Page<SysRole> pageParam,@Param("vo") SysRoleQueryVo sysRoleQueryVo);


}

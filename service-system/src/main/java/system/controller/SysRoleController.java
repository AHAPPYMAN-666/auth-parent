package system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import model.system.SysRole;
import model.vo.AssginRoleVo;
import model.vo.SysRoleQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import system.service.SysRoleService;

import java.util.List;
import java.util.Map;

@Api(tags = "角色管理接口")
@RestController
@RequestMapping("admin/system/sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;
    @ApiOperation("用户分配角色")
    @PostMapping("doAssign")
    public Result doAssign(@RequestBody AssginRoleVo assginRoleVo) {
        sysRoleService.doAssign(assginRoleVo);
        return Result.ok();
    }
    //获取用户角色数据
    @ApiOperation("获取用户角色数据")
    @GetMapping("toAssign/{userId}")
    public Result toAssign(@PathVariable String userId){
        Map<String,Object> roleMap = sysRoleService.getRoleByUserId(userId);
        return Result.ok(roleMap);

    }
    //批量删除
    //json的数组格式对应java中的list集合
    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> ids){
        sysRoleService.removeByIds(ids);
        return Result.ok();

    }


    //最终修改
    @ApiOperation("最终修改")
    @PostMapping("update")
    public Result updateRole(@RequestBody SysRole sysRole){
        boolean isSuccess = sysRoleService.updateById(sysRole);
        if (isSuccess){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    //修改角色-根据id查询
    @ApiOperation("修改角色")
    @PostMapping("findRoleById/{id}")
    public Result findRoleById(@PathVariable Long id){
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }
    //添加
    @ApiOperation("添加角色")
    @PostMapping("save")
     public Result savaRole(@RequestBody SysRole sysrole){//@RequestBody不能用get提交方式,
        boolean isSuccess = sysRoleService.save(sysrole);//传递json格式数据,把json格式数据封装到对象里面{....}
        if (isSuccess){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }


    //条件分页查询
    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")//page表示当前页,limit表示每页记录数
    public Result findPageQueryRole(@PathVariable Long page,
                                    @PathVariable Long limit,
                                    SysRoleQueryVo sysRoleQueryVo) {
        //创建page对象
        Page<SysRole> pageParam = new Page<>(page,limit);
        //调用service方法
        IPage<SysRole> pageModel = sysRoleService.selectPage(pageParam,sysRoleQueryVo);
        //返回
        return Result.ok(pageModel);
    }
    //逻辑删除
    @ApiOperation("逻辑删除接口")
    @DeleteMapping("remove/{id}")
    public Result removeRole(@PathVariable Long id){
        //调用方法进行删除
        boolean isSuccess = sysRoleService.removeById(id);
        if (isSuccess){
            return Result.ok();
        }
        else{
            return Result.fail();
        }
    }
    @ApiOperation("查询所有记录")
    //查询所有记录的接口
     @GetMapping("findAll")
    public Result findAllRole(){
         //调用service
         List<SysRole> list = sysRoleService.list();
         return Result.ok(list);//用统一结果返回,返回同一类型的对象
     }
}

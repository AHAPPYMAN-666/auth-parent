package system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import model.system.SysUser;
import model.vo.SysUserQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import system.service.SysUserService;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2022-11-07
 */
@Api(tags = "用户管理接口")
@RestController
@RequestMapping("/admin/system/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @ApiOperation("更改用户状态")
    @GetMapping("updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable String id,
                               @PathVariable Integer status){
                      sysUserService.updateStatus(id,status);
                      return Result.ok();
    }
    //删除
    @ApiOperation("删除用户")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable String id){
        boolean isSuccess = sysUserService.removeById(id);
        if (isSuccess){
            return Result.ok();
        }
        else{
            return  Result.fail();
        }
    }
    //修改
    @ApiOperation("修改用户")
    @PostMapping("update")
    public Result update(@RequestBody SysUser sysUser){
        boolean isSuccess = sysUserService.updateById(sysUser);
        if (isSuccess){
            return Result.ok();
        }
        else{
            return  Result.fail();
        }
    }
    //根据ID查询
    @ApiOperation("根据ID查询")
    @GetMapping("getUser/{id}")
    public Result getUser(@PathVariable String id){
        SysUser user = sysUserService.getById(id);
        return Result.ok(user);
    }
    //添加
    @ApiOperation("添加用户")
    @PostMapping("save")
    public Result save(@RequestBody SysUser sysUser){
        boolean isSuccess = sysUserService.save(sysUser);
        if (isSuccess){
            return Result.ok();
        }
        else{
            return  Result.fail();
        }
    }
    @ApiOperation("用户列表")
    @GetMapping("/{page}/{limit}")
    public Result list(@PathVariable Long page,
                       @PathVariable Long limit,
                       SysUserQueryVo sysUserQueryVo){
        //创建page对象
        Page<SysUser> pageParam = new Page<>(page,limit);
        //调用service方法进行分页查询
        IPage<SysUser> pageModel= sysUserService.selectPage(pageParam,sysUserQueryVo);
        return Result.ok( pageModel);

    }

}


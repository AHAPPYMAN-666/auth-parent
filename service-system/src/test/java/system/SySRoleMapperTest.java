package system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import system.mapper.SysRoleMapper;

import java.util.List;

@SpringBootTest
public class SySRoleMapperTest {
    @Autowired//自动装配要和mapper的包一致或者在mapper的子包下,比如system.test,都是在system包下
    //没有写sql语句但是调用了BaseMapper里面封装的SQL语句,方便实现对数据库的增删改查
    private SysRoleMapper sysRoleMapper;
    //条件查询
    @Test
    public void testSelect(){
        //创建一个条件构造器对象
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        //设置条件
       // wrapper.eq("role_name","芝士雪豹");
        //模糊查询,查询表中包含"管理员"字段的对象
        wrapper.like("role_name","管理员");
        List<SysRole> list = sysRoleMapper.selectList(wrapper);
        System.out.println(list);
    }
    //删除一个对象
    @Test
    public void deleteId(){
        sysRoleMapper.deleteById(1);
    }
    //修改一个对象
    @Test
    public void update(){
        //根据id查询
        SysRole sysrole = sysRoleMapper.selectById("1588789704239837185");
        //设置修改值
        sysrole.setDescription("微博之夜裤裆上上下下");
        //调用方法实现修改
        sysRoleMapper.updateById(sysrole);
    }
    @Test
    //添加一个对象
    public void add(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("芝士雪豹");
        sysRole.setRoleCode("你好");
        sysRole.setDescription("都什么年代了还在抽传统香烟");
        int rows = sysRoleMapper.insert(sysRole);
        System.out.println(rows);
    }

    @Test
    //查询表中所有记录
    public void findAll(){
        List<SysRole> list = sysRoleMapper.selectList(null);
        for (SysRole sysRole:list){
            System.out.println(sysRole);
        }

    }

}

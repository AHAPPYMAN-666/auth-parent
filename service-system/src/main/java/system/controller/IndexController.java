package system.controller;

import common.result.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Api(tags="用户登录接口")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {
    //Login
    //code:20000
    //data:{token: "admin-token"}
    @PostMapping("login")
    public Result login(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("token","admindingzhen");
        return  Result.ok(map);
    }
    //info
    @GetMapping("info")
    public Result info(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("introduction","I am a super administrator");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","zhishixuebao");
        return Result.ok(map);
    }
}

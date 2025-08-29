package com.example.user;

import cn.dev33.satoken.stp.StpUtil;
import com.example.common.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private Logger logger = Logger.getLogger(UserController.class.getName());

    @PostMapping("login")
    public ResponseResult<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.findUserByUsername(loginRequest.username());
        if (user != null && user.getPassword().equals(loginRequest.password())) {
            StpUtil.login(user);
            return ResponseResult.success(new LoginResponse(StpUtil.getTokenInfo(), user));
        }
        return ResponseResult.fail(null, "login fail");
    }

    @GetMapping("logout")
    public ResponseResult<String> logout() {
        StpUtil.logout();
        return ResponseResult.success("logout success");
    }

    @GetMapping("get")
    public ResponseResult<User> findUserByUsername(@RequestParam String username) {
        if (redisTemplate.hasKey("user:" + username)) {
            User user = (User) redisTemplate.opsForValue().get("user:" + username);
            logger.info("get users from redis");
            return ResponseResult.success(user);
        } else {
            User user = userService.findUserByUsername(username);
            redisTemplate.opsForValue().set("user:" + username, user);
            logger.info("get users from mysql");
            return ResponseResult.success(user);
        }

    }
}


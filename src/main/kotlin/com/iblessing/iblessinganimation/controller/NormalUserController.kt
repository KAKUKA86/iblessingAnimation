package com.iblessing.iblessinganimation.controller

import com.iblessing.iblessinganimation.pojo.Favorites
import com.iblessing.iblessinganimation.pojo.User
import com.iblessing.iblessinganimation.service.NormalUserService
import com.iblessing.iblessinganimation.util.NoFavResult
import com.iblessing.iblessinganimation.util.NoUserResult
import jakarta.annotation.Resource
import org.springframework.web.bind.annotation.CrossOrigin

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("/noUser")
class NormalUserController {
    @Resource
    val service: NormalUserService? = null

    /**
     * 普通用户登录
     */
    @PostMapping("/login")
    fun userLogin(@RequestBody user: User): NoUserResult? {
        val noUsername: String = user.noUsername
        val noUserPassword: String = user.noUserPassword
        return service?.normalUserLogin(noUsername, noUserPassword)
    }

    /**
     * 普通用户注册
     */
    @PostMapping("/signIn")
    fun userSignIn(@RequestBody user: User): NoUserResult? {
        return service?.normalUserSignIn(user)
    }

    /**
     * 查询用户的收藏表
     */
    @RequestMapping("/queryFavorite")
    fun queryUserFavorite(@RequestBody favorites: Favorites): NoFavResult? {
        return service?.queryFavorite(favorites)
    }
    /**
     * 新增普通用户收藏表
     * @param favorites 填写的收藏表数据
     * @author 14717
     */
    @RequestMapping("/addFavoriteTest")
    fun addUserFavorite(@RequestBody favorites: Favorites): NoFavResult? {
        return service?.normalUserFavorite(favorites)
    }
    /**
     * 测试接口
     */
    @RequestMapping("/test")
    fun hello(): String {
        return "hello world"
    }
}
package com.iblessing.iblessinganimation.service.impl

import com.iblessing.iblessinganimation.dao.NormalUserMapper
import com.iblessing.iblessinganimation.pojo.Favorites
import com.iblessing.iblessinganimation.pojo.User
import com.iblessing.iblessinganimation.service.NormalUserService
import com.iblessing.iblessinganimation.util.NoUserResult
import jakarta.annotation.Resource
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.util.*

@Service
class NormalUserServiceImpl : NormalUserService {
    @Resource
    private var mapper: NormalUserMapper? = null

    /**
     * 普通用户登录
     */
    override fun normalUserLogin(noUsername: String, noUserPassword: String): NoUserResult {
        println("service处 $noUsername")
        val user: User? = mapper?.queryNormalUserByUserName(noUsername)
        val noLogin = Timestamp(System.currentTimeMillis())

        println("service出库 ${user?.noUsername}")

        return if (Objects.isNull(user)) {
            println("该用户不存在")
            NoUserResult(400, "002", "用户不存在", null)
        } else {
            println("用户存在条件")
            NoUserResult(200, "001", "登录成功", user)
            if (Objects.equals(user?.noUserPassword, noUserPassword)) {
                println(user?.noUsername + "登陆成功，写入登录时间")
                mapper?.updateNormalUserLoginTime(noUsername, noLogin)
                NoUserResult(200, "001", "登录成功", user)
            } else {
                println("该用户存在但密码错误")
                NoUserResult(100, "002", "密码错误", null)
            }
        }
    }

    /**
     * 普通用户注册
     */
    override fun normalUserSignIn(user: User): NoUserResult {
        println(user.noUsername)
        val noUsername: String = user.noUsername
        val noUserPassword: String = user.noUserPassword
        val noUserGender: String = user.noGender
        val noUserBirthday: String = user.noBirthday
        val noUserEmail: String = user.noEmail

        return if (mapper?.queryNormalUserByUserName(user.noUsername) == null) {
            val noSignIn = Timestamp(System.currentTimeMillis())
            mapper?.insertNormalUser(noUsername, noUserPassword, noUserGender, noUserBirthday, noSignIn, noUserEmail)
            NoUserResult(200, "003", "注册成功", null)
            /**
             * 输入用户对象
             * 需要返回值？
             */
        } else {
            println("用户名重复或服务器错误")
            NoUserResult(100, "004", "注册失败", null)
        }
    }

    override fun normalUserFavorite(favorites: Favorites): NoUserResult? {
        val noId: Int = favorites.noId
        val arId: Int = favorites.noId
        val faTime = Timestamp(System.currentTimeMillis())
        return if (mapper?.queryNorUserFavByNoIdAndArId(noId, arId) != null) {
            mapper?.addNorUserFav(noId, arId, faTime)
            NoUserResult(200, "200", "收藏成功", null)
        } else {
            NoUserResult(200, "200", "收藏失败", null)

        }

    }
}
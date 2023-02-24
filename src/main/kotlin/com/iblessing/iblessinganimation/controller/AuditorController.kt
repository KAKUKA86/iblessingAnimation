package com.iblessing.iblessinganimation.controller

import com.iblessing.iblessinganimation.pojo.AudiUser
import com.iblessing.iblessinganimation.service.AuditorUserService
import com.iblessing.iblessinganimation.util.AuUserResult
import jakarta.annotation.Resource
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("/auUser")
class AuditorController {
    @Resource
    val service: AuditorUserService? = null

    @RequestMapping("/login")
    fun auditorLogin(@RequestBody audiUser: AudiUser) : AuUserResult?{
        return service?.auditorUserLogin(audiUser)
    }
    /**
     * 审核员审核用户上传的文章
     */
    @RequestMapping("/checkArticle")
    fun checkArticle(@RequestBody audiUser: AudiUser) : AuUserResult?{
        return service?.checkArticle(audiUser)
    }
}
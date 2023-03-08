package com.iblessing.iblessinganimation.controller

import com.iblessing.iblessinganimation.pojo.Article
import com.iblessing.iblessinganimation.service.UtilService
import com.iblessing.iblessinganimation.util.NoArticleResult
import com.iblessing.iblessinganimation.util.UtArticleAndCommentResult
import jakarta.annotation.Resource
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class UtilController {

    @Resource
    val service: UtilService? = null
    //通过编号显示文章
    @RequestMapping("/queArticleByArId")
    fun showArticleByArId(@RequestBody article: Article) : NoArticleResult? {
        return service?.showArticleByArId(article)
    }
    //通过编号查找文章和相关评论
    @RequestMapping("/queArticleAndCommentByArId")
    fun showArticleAndCommentByArId(@RequestBody article: Article) : UtArticleAndCommentResult? {
        return service?.showArticleAndCommentByArId(article.arId)
    }

}
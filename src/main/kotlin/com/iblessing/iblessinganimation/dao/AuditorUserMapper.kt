package com.iblessing.iblessinganimation.dao

import com.iblessing.iblessinganimation.pojo.Article
import com.iblessing.iblessinganimation.pojo.AudiUser
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface AuditorUserMapper {
    @Select("select * from a_audi_user where au_username = #{auUsername}")
    fun queryAuditorUserByAuUserName(auUsername: String): AudiUser?

    @Select("select * from n_article where ar_status = 0")
    fun queryAllArticleByStatus(): List<Article>?
}
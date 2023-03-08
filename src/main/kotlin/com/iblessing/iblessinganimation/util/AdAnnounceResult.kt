package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.Announcement

class AdAnnounceResult(
    var code: Int,
    var statusCode: String,
    var message: String,
    var announcement: Announcement?,
    var announcementList: List<Announcement>?
)
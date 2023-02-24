package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.Announcement

class AdAnnounceResult(
    var statusCode: Int,
    var code: String,
    var message: String,
    var announcement: Announcement?,
    var announcementList: List<Announcement>?
        )
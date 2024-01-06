package com.iblessing.iblessinganimation.pojo

import java.sql.Timestamp

class Bill {
    var name = ""
    var author = ""
    var publishing = ""
    var price = 0.0
    var time: Timestamp? = null
    var comment: String = ""
}
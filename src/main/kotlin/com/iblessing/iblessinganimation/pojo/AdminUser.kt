package com.iblessing.iblessinganimation.pojo

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
class AdminUser {
    var adId: Int = 0
    var adUsername: String = ""
    var adUserPassword: String = ""
    val aCode: Int = 1
}
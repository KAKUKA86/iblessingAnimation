package com.iblessing.iblessinganimation.pojo

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
class AdminUser{
    var adId : Int = 0
    var adUserName : String = ""
    var adUserPassword : String = ""
}
package com.iblessing.iblessinganimation.pojo

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
class User {
    var noId: Int = 0
    var noUsername: String = ""
    var noUserPassword: String = ""
    var noGender: String = ""
    var noBirthday: String = ""
    var noSignIn: Long = 0
    var noLogin: Long = 0
    var noUserExp: Int = 0
    var noEmail: String = ""
}
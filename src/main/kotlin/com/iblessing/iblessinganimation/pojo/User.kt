package com.iblessing.iblessinganimation.pojo

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.sql.Timestamp

@Data
@AllArgsConstructor
@NoArgsConstructor
class User {
    var noId: Int = 0
    var noUsername: String = ""
    var noUserPassword: String = ""
    var noGender: String = ""
    var noBirthday: Timestamp? = null
    var noSignIn: Timestamp? = null
    var noLogin: Timestamp? = null
    var noUserExp: Int = 0
    var noEmail: String = ""
}
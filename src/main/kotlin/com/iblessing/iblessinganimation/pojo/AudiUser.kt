package com.iblessing.iblessinganimation.pojo

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
class AudiUser{
    var auId : Int = 0
    var auUsername : String = ""
    var auPassword : String = ""

}
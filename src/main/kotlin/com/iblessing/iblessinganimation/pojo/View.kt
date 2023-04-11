package com.iblessing.iblessinganimation.pojo

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.sql.Timestamp

@AllArgsConstructor
@Data
@NoArgsConstructor

class View (
    var viId : Int = 0,
    var noId : Int = 0,
    var arId : Int = 0,
    var viTime : Timestamp? = null
        )
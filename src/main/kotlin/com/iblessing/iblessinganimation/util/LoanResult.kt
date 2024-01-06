package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.Loan

class LoanResult(
    var code: String,
    var statusCode: Int,
    var message: String,
    var loan: Loan?,
    var loanList: List<Loan>?,
)
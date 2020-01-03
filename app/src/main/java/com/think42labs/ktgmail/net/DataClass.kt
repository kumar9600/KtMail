package com.think42labs.ktgmail.net

/**
 * @author Vazhavanthakumar
 * @since 30/12/19
 */
data class DataClass(
    val accounting: List<Accounting>,
    val sales: List<Sale>
) {
    companion object {

        data class Accounting(
            val age: Int,
            val firstName: String,
            val lastName: String
        )

        data class Sale(
            val age: Int,
            val firstName: String,
            val lastName: String
        )
    }
}


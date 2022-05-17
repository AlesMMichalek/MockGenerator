package codes.seanhenry.mockgenerator.util

import java.util.*

fun String.simpleCapitalize(): String {
    return replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}

fun String.simpleUpperCase(): String {
    return uppercase(Locale.getDefault())
}

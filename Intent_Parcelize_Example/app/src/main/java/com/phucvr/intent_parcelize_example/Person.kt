package com.phucvr.intent_parcelize_example

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    var name: String?,
    var age: Int,
    var sex: Boolean,
    var abc: String,
) : Parcelable{

}

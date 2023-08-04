package com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class RandomColor(
val timestamp: Long,
val color: String,
@PrimaryKey
val id: Int? = null)
{

}
class InvalidColorException(message:String):Exception(message)






package com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.use_cases

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.model.RandomColor
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.repository.RandomColorRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList

class SaveToFireBaseUseCase(
    private val repository: RandomColorRepository
) {
      suspend operator fun invoke(){
         val db = FirebaseFirestore.getInstance()
        val colors= repository.getRandomColors().conflate().toList().flatten()
          val colorMap = colors.map{
         db.collection("RandomColors")
             .add(colors)
             .addOnSuccessListener {
                 Log.d("firebase","database added")
             }
             .addOnFailureListener {
                 Log.e("firebase","error while adding database ")
             }}
    }

    private fun saveToFireBase(color:String,date:String ){
        val db = FirebaseFirestore.getInstance()
        val colorMap: MutableMap<String, Any> = HashMap()
        colorMap["date"] = date
        colorMap["randomcolor"]=color

        db.collection("RandomColors")
            .add(colorMap)
            .addOnSuccessListener {
                Log.d("firebase","database added")
            }
            .addOnFailureListener {
                Log.e("firebase","error while adding database ")
            }

    }


}
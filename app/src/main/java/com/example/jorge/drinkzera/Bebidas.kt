package com.example.jorge.drinkzera

import java.io.Serializable

data class Bebida (var strDrink: String,
                   var strInstructions: String,
                   var strDrinkThumb: String,
                   var strIngredient1: String,
                   var strIngredient2: String,
                   var strIngredient3: String,
                   var strIngredient4: String,
                   var strMeasure1: String,
                   var strMeasure2: String,
                   var strMeasure3: String,
                   var strMeasure4: String,
                   var idDrink: Int): Serializable

package com.example.maestro.presentation.onBoarding.common

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.maestro.presentation.onBoarding.common.Dimens.Roundedcorner

@Composable
fun NewsButton(
    
    text:String,
    onClick:() ->Unit
){
    
    Button(onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(size = Roundedcorner)
        ) {
        Text(text = text,
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.SemiBold
            ))
    }
    
    

}


@Composable
fun NewsTextButton(
    text:String,
    onClick:() ->Unit
){

    TextButton(onClick = onClick) {
        Text(text = text, style = MaterialTheme.typography.labelMedium.copy(
            fontWeight = FontWeight.SemiBold
        ), color = Color.Gray)
    }


}

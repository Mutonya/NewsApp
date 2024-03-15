package com.example.maestro.utils

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.Visibility
import com.example.maestro.R
import com.example.maestro.ui.theme.BGColor
import com.example.maestro.ui.theme.Primary
import com.example.maestro.ui.theme.Secondary

@Composable
fun NormalTextComponent(value:String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = Color.Black,
        textAlign = TextAlign.Center
    )
}
@Composable
fun HeadingComponent(value:String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = Color.Black,
        textAlign = TextAlign.Center
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(label: String, painterResource: Painter, onTextSelected: (String) -> Unit, errorStatus:Boolean=false){
    val textValue = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label= { Text(text = label) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Black,
            focusedLabelColor = Color.Black,
            cursorColor = Color.Black,

            ),
        keyboardOptions = KeyboardOptions.Default,

        value = textValue.value,
        onValueChange ={
            textValue.value = it
            onTextSelected(it)
        } ,
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = null)
        },
        isError = !errorStatus,
        maxLines = 1
    )

}
@SuppressLint("ResourceType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordFieldComponent(label: String, painterResource: Painter, onTextSelected: (String) -> Unit, errorStatus: Boolean = false){
    val textValue = remember {
        mutableStateOf("")
    }
    val passwordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label= { Text(text = label) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,

            ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = textValue.value,
        onValueChange ={
            textValue.value = it
            onTextSelected(it)
        } ,
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = null)
        },

        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        isError = !errorStatus,
        maxLines = 1

    )

}

@Composable
fun CheckBoxComponent(value: String,onTextSelected:(String) ->Unit,onChecked:(Boolean) ->Unit){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        val checkedState = remember {
            mutableStateOf(true)
        }
        Checkbox(checked = checkedState.value, onCheckedChange ={
            checkedState.value = checkedState.value
            onChecked.invoke(it)
        } )
        clickableTextComponent(value = value,onTextSelected)
    }
}
@Composable
fun clickableTextComponent(value: String,onTextSelected:(String) ->Unit){

    val initialText = "By Continuing you accept our "
    val privacyPolicyText ="Privacy Policy "
    val endText = "and "
    val terms = "Terms of Use"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(endText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = terms, annotation = terms)
            append(terms)
        }
    }

    ClickableText(text = annotatedString, onClick ={ offset ->
        annotatedString.getStringAnnotations(offset,offset).firstOrNull()?.also {span ->

            if ((span.item == terms) || (span.item == privacyPolicyText)){
                onTextSelected(span.item)
            }
        }

    } )
}

@Composable
fun ButtonComponent(value: String,onButtonClicked :() ->Unit,isEnabled:Boolean = false){
    Button(onClick = { onButtonClicked.invoke() }, modifier = Modifier
        .fillMaxWidth()
        .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        enabled = isEnabled

    ) {
        Box (modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp)
            .background(
                brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
                shape = RoundedCornerShape(50.dp),

                ),
            contentAlignment = Alignment.Center
        ){
            Text(text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold )

        }
    }
}

@Composable
fun DividerTextComponent(){
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically

    ){
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = BGColor,
            thickness = 1.dp)
        Text(modifier = Modifier.padding(8.dp)
            ,text = stringResource(id = R.string.or), fontSize = 16.sp, color = Color.Black)
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = BGColor,
            thickness = 1.dp)

    }
}

@Composable
fun ClickableAccout(tryingtologing:Boolean,onTextSelected: (String) -> Unit){

    val initialText = if (tryingtologing)"Already Have an Account? " else "Don't have an account yet? "
    val logintext =if (tryingtologing)" Login " else "Register"


    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = logintext, annotation = logintext)
            append(logintext)
        }

    }

    ClickableText(modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 40.dp),

        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
        ),text = annotatedString, onClick ={
            annotatedString.getStringAnnotations(it,it)
                .firstOrNull()?.also {

                    Log.d("Clickable text","{${it.item}")
                    onTextSelected(it.item)


                }

        })
}
@Composable
fun underlineComponent(value: String){
    Text(text = value, modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ), color = Color.Gray,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}

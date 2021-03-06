package com.artemissoftware.jetpackcomposetutorial3.ui.moneytap

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MoneyTap() {


    var moneyCounter by remember{ mutableStateOf(0) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = Color(0xFF546E7A)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "$${moneyCounter}",
                style = TextStyle(color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)
            )

            Spacer(modifier = Modifier.height(130.dp))
            CreateCircle(moneyCounter = moneyCounter){
                moneyCounter = it + 1
            }

            if(moneyCounter > 5){
                Text(text = "Money money money")
            }

        }


    }


}

@Composable
fun CreateCircle(moneyCounter : Int = 0, updateMoneyCounter: (Int) -> Unit) {

    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(105.dp)
            .clickable {
                updateMoneyCounter(moneyCounter)
            }
        ,
        shape = CircleShape,
        elevation = 4.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "Tap")
        }
    }
}

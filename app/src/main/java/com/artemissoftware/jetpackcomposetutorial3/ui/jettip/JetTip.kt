package com.artemissoftware.jetpackcomposetutorial3.ui.jettip

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = false)
@Composable
private fun TopHeader(totalPerPerson: Double = 0.0) {

    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .clip(shape = CircleShape.copy(all = CornerSize(12.dp))),
        //.clip(shape = RoundedCornerShape(corner = CornerSize(12.dp))) // alternative to clipping borders
    color = Color(0xFFE9D7F7)
    ) {
    
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            val total = "%.2f".format(totalPerPerson)

            Text(
                text= "Total Per Person",
                style = MaterialTheme.typography.h5
            )
            Text(
                text= "$${total}",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
    
}


@Preview(showBackground = true)
@Composable
fun JetTip() {

    Surface(color = MaterialTheme.colors.background) {
        TopHeader()
    }
}

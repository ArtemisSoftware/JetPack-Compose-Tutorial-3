package com.artemissoftware.jetpackcomposetutorial3.ui.jettip

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.jetpackcomposetutorial3.ui.jettip.components.InputField
import com.artemissoftware.jetpackcomposetutorial3.ui.jettip.widgets.RoundIconButton


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



@ExperimentalComposeUiApi
@Preview(showBackground = false)
@Composable
private fun MainContent(

) {


    BillForm(){ billAmount ->



    }

}



@ExperimentalComposeUiApi
@Preview(showBackground = false)
@Composable
private fun BillForm(
    modifier: Modifier = Modifier,
    onValueChange: (String)  -> Unit = {}

) {

    val totalBillState = remember {
        mutableStateOf("")
    }

    val validState = remember(totalBillState.value) {
        totalBillState.value.trim().isNotEmpty()
    }

    val sliderPositionState = remember {
        mutableStateOf(0f)
    }

    val keyboardController = LocalSoftwareKeyboardController.current




    Surface(modifier = Modifier
        .padding(2.dp)
        .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ) {

        Column(
            modifier = Modifier.padding(6.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {

            InputField(
                valueState = totalBillState,
                labelId = "Enter Bill",
                enabled = true,
                isSingleLine = true,
                onAction = KeyboardActions{
                    if(!validState) return@KeyboardActions


                    onValueChange(totalBillState.value.trim())

                    keyboardController?.hide()
                }

            )


            if(/*validState*/ true){

                Row(
                    modifier = Modifier.padding(3.dp),
                    horizontalArrangement = Arrangement.Start
                ){

                    Text(
                        text = "Split",
                        modifier = Modifier.align(alignment = Alignment.CenterVertically)
                    )
                    
                    Spacer(modifier = Modifier.width(120.dp))


                    Row(
                        modifier = Modifier.padding(horizontal = 3.dp),
                        horizontalArrangement = Arrangement.End
                    ){

                        RoundIconButton(
                            imageVector = Icons.Default.Remove,
                            onClick = {

                            }
                        )

                        Text(
                            text = "2",
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(start = 9.dp, end = 9.dp)
                        )

                        RoundIconButton(
                            imageVector = Icons.Default.Add,
                            onClick = {

                            }
                        )
                    }


                }
            }
            else{
                Box(){}
            }


            Row(modifier = Modifier
                .padding(horizontal = 3.dp, vertical = 12.dp)
            ){

                Text(
                    text = "Tip",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)

                )

                Spacer(modifier = Modifier.width(200.dp))

                Text(
                    text = "2",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)

                )

            }


            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Tip"
                )
                Spacer(modifier = Modifier.height(14.dp))

                Slider(
                    value = sliderPositionState.value,
                    onValueChange = {newVal ->

                        sliderPositionState.value = newVal
                    }
                )
            }


        }
    }

}




@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun JetTip() {

    Surface(color = MaterialTheme.colors.background) {
        TopHeader()

        MainContent()
    }
}

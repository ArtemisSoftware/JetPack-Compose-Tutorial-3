package com.artemissoftware.jetpackcomposetutorial3.ui.jettrivia.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.jetpackcomposetutorial3.ui.jettrivia.model.QuestionItem
import com.artemissoftware.jetpackcomposetutorial3.ui.jettrivia.screens.QuestionsViewModel
import com.artemissoftware.jetpackcomposetutorial3.util.AppColors

@Composable
fun Questions( viewModel: QuestionsViewModel) {
    /**
     * Important note: since, Question class returns an
     * ArrayList, we must convert the values of that type
     * into a MutableList() in order to get the size(), and
     * any other methods... if we don't convert to MutableList
     * we receive a nasty "NonSuchMethod" exception.
     *
     */
    val questions = viewModel.data.value.data?.toMutableList() //Important!

    val questionIndex = remember {
        mutableStateOf(0)
    }



    if(viewModel.data.value.loading == true) {
        CircularProgressIndicator()

    }else {
        val question = try {
            questions?.get(questionIndex.value)
        }catch (ex: Exception){
            null
        }

        if (questions != null) {
//            QuestionDisplay(question = question!!, questionIndex = questionIndex,
//                viewModel = viewModel){
//                questionIndex.value = questionIndex.value + 1
//
            }
        }
    }


@Preview
@Composable
fun QuestionDisplay(
//    question: QuestionItem,
//    questionIndex: MutableState<Int>,
//    viewModel: QuestionsViewModel,
//    onNextClicked: (Int) -> Unit = {}

) {

    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(4.dp),
        color = AppColors.mDarkPurple
    ) {

        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {

            QuestionTracker()
            DrawDottedLine(pathEffect = pathEffect)
        }
    }
}

@Composable
fun DrawDottedLine(pathEffect: PathEffect) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp),
    ){
        drawLine(color = AppColors.mLightGray,
            start = Offset(0f, 0f),
            end = Offset(size.width, y = 0f),
            pathEffect = pathEffect)

    }

}

//@Preview
//@Composable
//fun ShowProgress(score: Int = 12) {
//
//    val gradient = Brush.linearGradient(listOf(Color(0xFFF95075),
//        Color(0xFFBE6BE5)))
//
//    val progressFactor by remember(score) {
//        mutableStateOf(score*0.005f)
//
//    }
//    Row(modifier = Modifier
//        .padding(3.dp)
//        .fillMaxWidth()
//        .height(45.dp)
//        .border(width = 4.dp,
//            brush = Brush.linearGradient(colors = listOf(AppColors.mLightPurple,
//                AppColors.mLightPurple)),
//            shape = RoundedCornerShape(34.dp))
//        .clip(RoundedCornerShape(topStartPercent = 50,
//            topEndPercent = 50,
//            bottomEndPercent = 50,
//            bottomStartPercent = 50))
//        .background(Color.Transparent),
//        verticalAlignment = Alignment.CenterVertically) {
//        Button(
//            contentPadding = PaddingValues(1.dp),
//            onClick = { },
//            modifier = Modifier
//                .fillMaxWidth(progressFactor)
//                .background(brush = gradient),
//            enabled = false,
//            elevation = null,
//            colors = buttonColors(
//                backgroundColor = Color.Transparent,
//                disabledBackgroundColor = Color.Transparent
//            )) {
//            Text(text = (score*10).toString(),
//                modifier = Modifier.clip(shape = RoundedCornerShape(23.dp))
//                    .fillMaxHeight(0.87f)
//                    .fillMaxWidth()
//                    .padding(6.dp),
//                color = AppColors.mOffWhite,
//                textAlign = TextAlign.Center)
//
////
//        }
//
//
//    }
//}
//
//
//








@Preview
@Composable
fun QuestionTracker(counter: Int = 10,
                    outOf: Int = 100) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = ParagraphStyle(textIndent = TextIndent.None)){

                    withStyle(style = SpanStyle(
                                                color = AppColors.mLightGray,
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 27.sp)
                    ){
                        append("Question $counter/")
                        withStyle(style = SpanStyle(color = AppColors.mLightGray,
                                                    fontWeight = FontWeight.Light,
                                                    fontSize = 14.sp)){
                                                                        append("$outOf")
                                                                       }

                    }
                }
        },
        modifier = Modifier.padding(20.dp))

}


package com.chencye.demo.unit3_courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chencye.demo.unit3_courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoursesApp()
                }
            }
        }
    }
}

@Composable
fun CoursesApp() {

}

@Composable
fun CoursesList(topicList: List<Topic>, modifier: Modifier = Modifier) {

}

@Composable
fun CourseCard(topic: Topic, modifier: Modifier = Modifier) {
    Row {
        Image(
            painter = painterResource(id = topic.pic),
            contentDescription = stringResource(id = topic.title),
            modifier = Modifier
                .height(68.dp)
                .width(68.dp),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)) {
            Text(
                text = stringResource(id = topic.title),
                style = MaterialTheme.typography.bodyMedium
            )
            Row(modifier = Modifier.padding(top = 8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_grain),
                    contentDescription = null,
                )
                Text(
                    text = topic.amount.toString(),
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

// @Preview(showBackground = true)
@Composable
fun CoursesAppPreview() {
    CoursesTheme {
        CoursesApp()
    }
}


@Preview(showBackground = true)
@Composable
fun CourseCardPreview() {
    CoursesTheme {
        CourseCard(Topic(R.string.architecture, 58, R.drawable.architecture))
    }
}
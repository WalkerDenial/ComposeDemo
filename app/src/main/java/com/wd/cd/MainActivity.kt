package com.wd.cd

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.wd.cd.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                ActivityList(this)
            }
        }
    }
}

data class ActivityModel<T : ComponentActivity>(val name: String, val clazz: Class<T>)

val activities = listOf(
    ActivityModel("基础知识", BasicKnowledgeActivity::class.java),
    ActivityModel("基础知识", BasicKnowledgeActivity::class.java)
)

@Composable
fun ActivityList(context: Context) {
    LazyColumn(Modifier.fillMaxWidth()) {
        items(items = activities) { item ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Jetpack Compose ${item.name}", modifier = Modifier
                        .fillMaxWidth()
                        .clickable { context.startActivity(Intent(context, item.clazz)) }
                        .padding(8.dp)
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp), color = Color.LightGray
                )
            }
        }
    }
}
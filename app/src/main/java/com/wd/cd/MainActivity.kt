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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.wd.cd.animation.AnimationActivity
import com.wd.cd.basic.BasicKnowledgeActivity
import com.wd.cd.basiclayouts.BasicLayoutActivity
import com.wd.cd.state.StateActivity
import com.wd.cd.sunflower.GardenActivity
import com.wd.cd.theming.ui.start.ThemeStartActivity
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
    ActivityModel("SunFlower", GardenActivity::class.java),
    ActivityModel("基础布局", BasicLayoutActivity::class.java),
    ActivityModel("主题设置", ThemeStartActivity::class.java),
    ActivityModel("动画效果", AnimationActivity::class.java),
    ActivityModel("状态", StateActivity::class.java)
)

@Composable
fun ActivityList(context: Context) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "Jetpack Compose"
                )
            })
        },
        content = {
            LazyColumn(Modifier.fillMaxWidth()) {
                itemsIndexed(items = activities) { index, item ->
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "${index + 1}. ${item.name}", modifier = Modifier
                                .fillMaxWidth()
                                .clickable { context.startActivity(Intent(context, item.clazz)) }
                                .padding(16.dp)
                        )
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp), color = Color.LightGray
                        )
                    }
                }
            }
        })
}
package com.example.nbshoesjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nbshoesjetpackcompose.model.Shoes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Nue()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ListItem(item: Shoes){

    var expanded by remember{ mutableStateOf(false)}

    Card(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)
        .padding(10.dp))
    {
        Box(modifier = Modifier.background(color=Color.White)){
            Column(modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )) {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.background(color = Color.White)) {
                    Image(painter = painterResource(id = item.image),
                        contentDescription ="",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(5.dp)
                            .size(90.dp)
                            .clip(CircleShape))
                    Column(modifier = Modifier
                        .padding(start = 16.dp)
                        .weight(1f)) {
                        Text(stringResource(id = item.name))
                    }
                    IconButton(onClick = { expanded = !expanded}) {
                        Icon(imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                            contentDescription = "" )
                    }
                }
                if (expanded) Text(stringResource(id = item.information), fontSize = 14.sp)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Nue(){
    Column() {
    SearchBar()
    LazyColumn(){
        itemsIndexed(listOf(
            Shoes(R.string.nb_numeric_440,R.drawable.nb_numeric_440,R.string.nb_numeric_440_inf),
            Shoes(R.string.nb_numeric_213,R.drawable.nb_numeric_213,R.string.nb_numeric_213_inf),
            Shoes(R.string.nb_ct574,R.drawable.nb_ct574,R.string.nb_ct574_inf),
            Shoes(R.string.nb_ct210,R.drawable.nb_ct210,R.string.nb_ct210_inf),
            Shoes(R.string.nb_997h,R.drawable.nb_997h,R.string.nb_997h_inf),
            Shoes(R.string.nb_numeric_213,R.drawable.nb_numeric_213,R.string.nb_numeric_213_inf),
            Shoes(R.string.nb_numeric_440,R.drawable.nb_numeric_440,R.string.nb_numeric_440_inf),
            Shoes(R.string.nb_997h,R.drawable.nb_997h,R.string.nb_997h_inf),
            Shoes(R.string.nb_ct574,R.drawable.nb_ct574,R.string.nb_ct574_inf),
            Shoes(R.string.nb_ct210,R.drawable.nb_ct210,R.string.nb_ct210_inf),
        )){
            _,item-> ListItem(item = item)
        }
    }
}}

@Preview
@Composable
fun SearchBar(modifier: Modifier=Modifier){
    TextField(value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        placeholder = {Text(stringResource(id = R.string.placeholder_search))},
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .padding(10.dp),)
}



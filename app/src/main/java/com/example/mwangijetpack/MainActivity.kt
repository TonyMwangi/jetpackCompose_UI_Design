package com.example.mwangijetpack

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mwangijetpack.ui.theme.MwangiJetpackTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MwangiJetpackTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            modifier = Modifier
                                .fillMaxWidth(1f),
                            backgroundColor = Color.White,
                            elevation = 0.dp,
                            title = {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(1f),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        modifier = Modifier
                                            .size(30.dp)
                                            .clip(shape = CircleShape),
                                        painter = painterResource(id = R.drawable.avatar),
                                        contentDescription = null
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Notifications,
                                        modifier = Modifier
                                            .clip(shape = CircleShape)
                                            .background(Color.hsl(0.0f, 0.0f, 0.7f, .3f))
                                            .size(25.dp),
                                        contentDescription = null,
                                    )

                                }

                            }
                        )
                    }
                ) {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.fillMaxSize(1f)
                    )
                    {
                        item {
                            LazyRow(modifier = Modifier.fillMaxWidth(1f),) {
                                items(boxContents) { boxcontent ->
                                    MountainViewBox(boxcontent)
                                }
                            }
                        }
                        item {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth(1f)
                                    .padding(horizontal = 8.dp, vertical = 0.dp)
                            ) {
                                Text(
                                    text = "Best Destination",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp
                                )
                                Text(
                                    text = "view all",
                                    fontSize = 14.sp,
                                    color = Color.Blue
                                )
                            }
                        }
                        item {
                            LazyVerticalGrid(
                                columns = GridCells.Fixed(count = 2),
                                modifier = Modifier
                                    .fillMaxWidth(1f)
                                    .height(370.dp)
                            )
                            {
                                items(boxContents.size) { index ->
                                    MountainCell(boxContents[index])
                                }
                            }
                        }

                    }
                }
            }

        }
    }

    @Composable
    private fun MountainViewBox(boxcontent: BoxItem) {
        Box(
            modifier = Modifier
                .width(250.dp)
                .height(170.dp)
                .clip(shape = RoundedCornerShape(5.dp))
                .padding(8.dp)
                .background(Color.White)
        )
        {

            Image(
                painter = painterResource(id = boxcontent.BoxImage),
                modifier = Modifier
                    .width(250.dp)
                    .height(150.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .align(alignment = Alignment.BottomStart),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 0.dp, vertical = 25.dp)
                    .align(alignment = Alignment.BottomStart)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth(1f)
                ) {
                    Text(
                        text = boxcontent.name,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(1.dp)
                    ) {
                        Image(
                            painter = painterResource(id = boxcontent.ratingIcon),
                            modifier = Modifier.size(18.dp),
                            contentDescription = null
                        )
                        Text(
                            text = boxcontent.rating,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                        .fillMaxWidth(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        modifier = Modifier.size(18.dp),
                        tint = Color.White,
                        contentDescription = null,
                    )
                    Text(
                        text = boxcontent.city,
                        color = Color.White,
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp
                    )
                    Text(
                        text = boxcontent.country,
                        color = Color.White,
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp
                    )

                }


            }

        }

    }

    data class BoxItem(
        val BoxImage: Int,
        val ratingIcon: Int,
        val name: String,
        val city: String,
        val country: String,
        val locationIcon: Int,
        val rating: String

    )

    val boxContents = listOf(
        BoxItem(

            BoxImage = R.drawable.mountain3,
            ratingIcon = R.drawable.rating,
            rating = "4.9",
            name = " Norther Mountain",
            city = " Tekergat,",
            country = "Sunamgnj ",
            locationIcon = R.drawable.location

        ),
        BoxItem(

            BoxImage = R.drawable.mountain4,
            ratingIcon = R.drawable.rating,
            rating = "5.0",
            name = " Longonot Mountain",
            city = "Zanzibar,",
            country = "Ethiopa ",
            locationIcon = R.drawable.location

        ),
        BoxItem(

            BoxImage = R.drawable.mountain5,
            ratingIcon = R.drawable.rating,
            rating = "4.0",
            name = "Niladri Restaraunt",
            city = " Nairobi, ",
            country = "Somalia ",
            locationIcon = R.drawable.location

        ),
        BoxItem(

            BoxImage = R.drawable.mountain1,
            ratingIcon = R.drawable.rating,
            rating = "3.5",
            name = " Mt.Kenya Mountain",
            city = " Meru, ",
            country = "Kenya ",
            locationIcon = R.drawable.location,
        ),
        BoxItem(

            BoxImage = R.drawable.mountain5,
            ratingIcon = R.drawable.rating,
            rating = "3.5",
            name = " Evarest Mountain",
            city = " Seattle, ",
            country = "Mexico ",
            locationIcon = R.drawable.location,
        ),
        BoxItem(

            BoxImage = R.drawable.mountain3,
            ratingIcon = R.drawable.rating,
            rating = "3.5",
            name = " Kilimanjaro Mountain",
            city = " Tanganyika, ",
            country = "Tanzania ",
            locationIcon = R.drawable.location,
        ),
        BoxItem(

            BoxImage = R.drawable.mountain1,
            ratingIcon = R.drawable.rating,
            rating = "3.5",
            name = " Favoured Mountain",
            city = " Nyeri, ",
            country = "Kenya ",
            locationIcon = R.drawable.location,
        ),
        BoxItem(

            BoxImage = R.drawable.mountain5,
            ratingIcon = R.drawable.rating,
            rating = "3.5",
            name = " Western Mountain",
            city = " Bungoma, ",
            country = "Uganda ",
            locationIcon = R.drawable.location,
        ),
        BoxItem(

            BoxImage = R.drawable.mountain4,
            ratingIcon = R.drawable.rating,
            rating = "3.5",
            name = " Easter Mountain",
            city = " Nakuru, ",
            country = "Kenya ",
            locationIcon = R.drawable.location,
        ),
    )

    @Composable
    fun MountainCell(boxcontent: BoxItem) {
        Box(
            modifier = Modifier
                .width(250.dp)
                .height(180.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .padding(8.dp)
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(id = boxcontent.BoxImage),
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(12.dp))
                    .width(250.dp)
                    .height(120.dp)
                    .align(Alignment.TopStart),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.bookmark_border),
                modifier = Modifier
                    .width(28.dp)
                    .height(32.dp)
                    .padding(0.dp, 14.dp, 8.dp, 0.dp)
                    .align(Alignment.TopEnd)
                    .clip(shape = CircleShape)
                    .background(Color.hsl(0.0f, 0.0f, 0.6f, .8f)),
                contentDescription = null,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .align(Alignment.BottomStart)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth(1f)
                ) {
                    Text(
                        text = boxcontent.name,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(0.9.dp),
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = boxcontent.ratingIcon),
                            modifier = Modifier.size(12.dp),
                            contentDescription = null
                        )
                        Text(
                            text = boxcontent.rating,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp

                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = boxcontent.locationIcon),
                        modifier = Modifier.size(12.dp),
                        contentDescription = null,
                    )
                    Text(
                        text = boxcontent.city,
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                    Text(
                        text = boxcontent.country,
                        color = Color.Black,
                        fontSize = 12.sp
                    )

                }
            }
        }
    }
}
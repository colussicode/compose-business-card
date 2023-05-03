package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0XFF004d4d)
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Row(
            Modifier.weight(1f),
            verticalAlignment = Alignment.Bottom
        ){
            PersonalInformation()
        }
        Row(
            Modifier
                .weight(0.5f)
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            ContactInformation()
        }
    }
}

@Composable
fun PersonalInformation() {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = stringResource(R.string.jo_o_colussi),
            fontSize = 36.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.android_developer_extraordinaire),
            color = Color(0xFF3ddc84)
        )
    }
}

@Composable
fun ContactInformationItem(
    imageVector: ImageVector,
    stringResource: String ,
    modifier: Modifier,
    color: Color,
    textColor: Color){
    Row(
        modifier = modifier.padding(bottom = 8.dp)
    ){
        Icon(
            imageVector = imageVector,
            modifier = modifier.padding(end = 8.dp),
            contentDescription = null,
            tint = color
        )
        Text(
            text = stringResource,
            color = textColor
        )
    }
}

@Composable
fun ContactInformation() {
    Column(
    ){
        ContactInformationItem(
            imageVector = Icons.Filled.Call,
            stringResource = stringResource(id = R.string._11_123_444_555_666),
            modifier = Modifier,
            color = Color(0XFF3ddc84),
            textColor = Color.White
        )
        ContactInformationItem(
            imageVector = Icons.Filled.Share,
            stringResource = stringResource(id = R.string.jo_o_colussi),
            modifier = Modifier,
            color = Color(0XFF3ddc84),
            textColor = Color.White
        )
        ContactInformationItem(
            imageVector = Icons.Filled.Email,
            stringResource = stringResource(id = R.string.colussidev_gmail_com),
            modifier = Modifier,
            color = Color(0XFF3ddc84),
            textColor = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}
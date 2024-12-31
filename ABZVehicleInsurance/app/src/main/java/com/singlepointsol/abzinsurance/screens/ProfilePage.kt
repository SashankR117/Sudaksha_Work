package com.singlepointsol.abzinsurance.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.singlepointsol.abzinsurance.viewmodel.ProfileViewModel


@Composable
fun ProfilePage(viewModel: Modifier.Companion, pviewModel: ProfileViewModel) {

    var customer by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxWidth().padding(8.dp).windowInsetsPadding(WindowInsets.systemBars),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = customer,
                onValueChange = { customer = it },
                label = {
                    Text("Enter CustomerID")
                }
            )
            /**
            IconButton(onClick = {
            pviewModel.getData(customer)
            })
            {
            Icon(Icons.Default.Search,
            contentDescription = "Search")
            }

            }*/
        }
    }
}


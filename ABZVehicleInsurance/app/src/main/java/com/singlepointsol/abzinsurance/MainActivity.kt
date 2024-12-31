package com.singlepointsol.abzinsurance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.singlepointsol.abzinsurance.navigation.Routes
import com.singlepointsol.abzinsurance.screens.*
import com.singlepointsol.abzinsurance.ui.theme.ABZInsuranceTheme
import com.singlepointsol.abzinsurance.ui.theme.NavItems
import com.singlepointsol.abzinsurance.viewmodel.*
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val agentViewModel = ViewModelProvider(this)[AgentViewModel::class.java]
        val claimViewModel = ViewModelProvider(this)[ClaimViewModel::class.java]
        val customerViewModel = ViewModelProvider(this)[CustomerViewModel::class.java]
        val policyAddonViewModel = ViewModelProvider(this)[PolicyAddonViewModel::class.java]
        val policyViewModel = ViewModelProvider(this)[PolicyViewModel::class.java]
        val proposalViewModel = ViewModelProvider(this)[ProposalViewModel::class.java]
        val vehicleViewModel = ViewModelProvider(this)[VehicleViewModel::class.java]
        val productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        val productAddOnViewModel = ViewModelProvider(this)[ProductAddOnViewModel::class.java]
        val customerQueryViewModel = ViewModelProvider(this)[CustomerQueryViewModel::class.java]
        val queryResponseViewModel = ViewModelProvider(this)[QueryResponseViewModel::class.java]
        val profileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        setContent {
            ABZInsuranceTheme {
                MyApp(
                    agentViewModel,
                    claimViewModel,
                    customerViewModel,
                    policyAddonViewModel,
                    policyViewModel,
                    proposalViewModel,
                    vehicleViewModel,
                    productViewModel,
                    productAddOnViewModel,
                    customerQueryViewModel,
                    queryResponseViewModel,
                    profileViewModel
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(
    agentViewModel: AgentViewModel,
    claimViewModel: ClaimViewModel,
    customerViewModel: CustomerViewModel,
    policyAddOnViewModel: PolicyAddonViewModel,
    policyViewModel: PolicyViewModel,
    proposalViewModel: ProposalViewModel,
    vehicleViewModel: VehicleViewModel,
    productViewModel: ProductViewModel,
    productAddOnViewModel: ProductAddOnViewModel,
    customerQueryViewModel: CustomerQueryViewModel,
    queryResponseViewModel: QueryResponseViewModel,
    profileViewModel: ProfileViewModel
)

{
    val navItemList = listOf(
        NavItems("Home", Icons.Default.Home),
        NavItems("My Policies", Icons.Default.ShoppingCart),
        NavItems("Support", Icons.Default.Build)
    )
    var selectedindex by remember { mutableIntStateOf(0) }
    val navController = rememberNavController()
    rememberDrawerState(initialValue = DrawerValue.Closed)
    rememberCoroutineScope()

        Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
            TopAppBar(
                title = { Text("ABZ Insurance") })
        },
            bottomBar = {
                NavigationBar {
                    navItemList.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = selectedindex == index,
                            onClick = { selectedindex = index
                                      when(index){
                                          0->navController.navigate(Routes.MainPage.route){popUpTo(0)}
                                          1->navController.navigate(Routes.ProfilePage.route)
                                          2->navController.navigate(Routes.ContactUsPage.route)
                                      }},
                            label = { Text(item.label) },
                            icon = {
                                Icon(
                                    imageVector = navItemList[index].icon,
                                    contentDescription = item.label
                                )
                            })
                    }
                }

            }
        ) { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                NavHost(
                    navController = navController,
                    startDestination = Routes.Splash.route
                ) {
                    composable(Routes.Splash.route) { SplashScreen(navController) }
                    composable(Routes.Blankpage.route) { Blankpage() }
                    composable(Routes.ProfilePage.route) { ProfilePage(Modifier, profileViewModel) }
                    composable(Routes.ContactUsPage.route) { ContactUsPage() }
                    composable(Routes.MainPage.route) { MainPage(navController) }
                    composable(Routes.AgentPage.route) { AgentPage(Modifier, agentViewModel) }
                    composable(Routes.ClaimPage.route) { ClaimPage(Modifier, claimViewModel) }
                    composable(Routes.CustomerPage.route) { CustomerPage(Modifier, customerViewModel) }
                    composable(Routes.PolicyAddOnPage.route) { PolicyAddOnPage(Modifier, policyAddOnViewModel) }
                    composable(Routes.PolicyPage.route) { PolicyPage(Modifier, policyViewModel) }
                    composable(Routes.ProposalPage.route) { ProposalPage(Modifier, proposalViewModel) }
                    composable(Routes.VehiclePage.route) { VehiclePage(Modifier, vehicleViewModel) }
                    composable(Routes.ProductPage.route) { ProductPage(Modifier, productViewModel) }
                    composable(Routes.ProductAddOnPage.route) { ProductAddOnPage(Modifier, productAddOnViewModel) }
                    composable(Routes.CustomerQueryPage.route) { CustomerQueryPage(Modifier, customerQueryViewModel) }
                    composable(Routes.QueryResponsePage.route) { QueryResponsePage(Modifier, queryResponseViewModel) }
                }
            }
        }


}





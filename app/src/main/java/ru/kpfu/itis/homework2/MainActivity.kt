package ru.kpfu.itis.homework2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import ru.kpfu.itis.homework2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var viewBinding : ActivityMainBinding? = null

    private var controller : NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(viewBinding?.root)

        controller = (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment).navController

        viewBinding?.apply {
            navigation.setupWithNavController(controller!!)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }
}
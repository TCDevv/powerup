package com.horizon.powerup.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.horizon.powerup.R
import com.horizon.powerup.di.Injector

class MainActivity : AppCompatActivity(), Navigator.Container {
    private val repository = Injector.injectRepository()
    private val logger = Injector.injectLogger()
    private val pokemonRepository = Injector.injectPokemonRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logger.log(repository.getUserInfo("userInfo"))
        logger.log(pokemonRepository.getPokemonList())
        setContentView(R.layout.activity_main)
        attachNavigator()
    }

    override fun onDestroy() {
        detachNavigator()
        super.onDestroy()
    }

    override fun getHostFragmentManager(): FragmentManager {
        return supportFragmentManager
    }

    override fun getHostContainerId(): Int {
        return R.id.screenContainer
    }
}
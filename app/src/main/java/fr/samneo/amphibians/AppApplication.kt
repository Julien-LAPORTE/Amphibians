package fr.samneo.amphibians

import android.app.Application
import fr.samneo.amphibians.di.AppContainer
import fr.samneo.amphibians.di.DefaultAppContainer

class AppApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
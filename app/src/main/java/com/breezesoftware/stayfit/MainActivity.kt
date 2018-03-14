package com.breezesoftware.stayfit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.widget.TextView
import com.breezesoftware.stayfit.model.FeatureRepo
import com.tobishiba.circularviewpager.library.CircularViewPagerHandler

/* Главный экран приложения */
class MainActivity : AppCompatActivity() {

    private var featuredVP : ViewPager? = null;

    private var graphVP: ViewPager? = null;
    private var graphTabLayout : TabLayout? = null;

    private var welcomeTV : TextView? = null;
    private var nextTrainingTV : TextView? = null;
    private var achievementTV : TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpWidgets();
    }

    /* Настраивает необходимые элементы страницы */
    private fun setUpWidgets() {
        setUpFeatured();
        setUpGraphs();
        setUpTextViews();
    }

    private fun setUpFeatured() {
        featuredVP = findViewById(R.id.featured_vp);

        /* Делаем данный блок цикличным */
        featuredVP?.adapter = FeaturedPagerAdapter(this,
                supportFragmentManager, FeatureRepo.getFeatureImages());
        featuredVP?.addOnPageChangeListener(CircularViewPagerHandler(featuredVP));
    }

    private fun setUpTextViews() {
        welcomeTV = findViewById(R.id.welcome_tv);
        nextTrainingTV = findViewById(R.id.next_training_tv);
        achievementTV = findViewById(R.id.achivement_tv);

        welcomeTV?.text = getString(R.string.main_welcome, "George");
        nextTrainingTV?.text = getString(R.string.main_next_training, "Tomorrow");
        achievementTV?.text = getString(R.string.main_achievement, 10);
    }

    /* Настраивает отображение графиков прогресса */
    private fun setUpGraphs() {
        graphTabLayout = findViewById(R.id.graph_tab_layout);
        graphVP = findViewById(R.id.graph_vp);

        val graphPagerAdapter = GraphsPagerAdapter(supportFragmentManager, this);
        graphVP?.adapter = graphPagerAdapter;

        graphTabLayout?.setupWithViewPager(graphVP);
    }
}

package ma.ensa.navigationdrawerdemo;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Configuration de la Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 2. Initialisation des vues
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // 3. Gestion moderne du bouton Retour (Remplace onBackPressed)
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    // Désactive temporairement ce callback pour permettre la fermeture de l'app
                    setEnabled(false);
                    getOnBackPressedDispatcher().onBackPressed();
                }
            }
        });

        // 4. Animation du bouton "Hamburger"
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // 5. Affichage du fragment par défaut
        if (savedInstanceState == null) {
            remplacerFragment(new BlankFragment(), "Accueil");
            navigationView.setCheckedItem(R.id.nav_fragment1);
        }
    }

    /**
     * Méthode optimisée pour changer de fragment
     */
    private void remplacerFragment(Fragment fragment, String titre) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Animation fluide de transition
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        transaction.replace(R.id.contenu, fragment);
        transaction.commit();

        // Mise à jour sécurisée du titre de la Toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(titre);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_fragment1) {
            remplacerFragment(new BlankFragment(), "Fragment 1");
        } else if (id == R.id.nav_fragment2) {
            remplacerFragment(new BlankFragment2(), "Fragment 2");
        } else if (id == R.id.nav_list) {
            remplacerFragment(new FragmentList(), "Ma Liste");
        }

        // Fermeture du menu
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
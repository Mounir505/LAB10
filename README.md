📱 NavigationDrawerDemo
=======================

🎯 Objectif
-----------

Apprendre à créer une application Android intégrant un menu latéral (Navigation Drawer) et gérer dynamiquement plusieurs fragments dans une seule activité.

⚙️ Étape 1 – Création du projet
-------------------------------

*   Ouvrir Android Studio
*   New Project → Navigation Drawer Activity
*   Langage : Java
*   Min SDK : 24
*   Nom : NavigationDrawerDemo

🧭 Étape 2 – Modifier le menu
-----------------------------

`<menu xmlns:android="http://schemas.android.com/apk/res/android"> <item android:id="@+id/nav_fragment1" android:icon="@drawable/ic_home" android:title="Fragment 1" /> <item android:id="@+id/nav_fragment2" android:icon="@drawable/ic_dashboard" android:title="Fragment 2" /> <item android:id="@+id/nav_list" android:icon="@drawable/ic_list" android:title="Fragment List" /> </menu>`

🧩 Étape 3 – Création des fragments
-----------------------------------

### Fragment 1

`<LinearLayout android:layout_width="match_parent" android:layout_height="match_parent" android:gravity="center" android:orientation="vertical" android:background="#F8BBD0"> <TextView android:text="Fragment 1" android:textSize="24sp" android:textStyle="bold" android:textColor="#000"/> </LinearLayout>`

### Fragment 2

`<LinearLayout android:layout_width="match_parent" android:layout_height="match_parent" android:gravity="center" android:orientation="vertical" android:background="#3F51B5"> <TextView android:text="Fragment 2" android:textSize="24sp" android:textStyle="bold" android:textColor="#FFF"/> </LinearLayout>`

📦 Étape 4 – Conteneur de fragments
-----------------------------------

`<FrameLayout android:id="@+id/contenu" android:layout_width="match_parent" android:layout_height="match_parent" />`

🔄 Étape 5 – Navigation entre fragments
---------------------------------------

`@Override public boolean onNavigationItemSelected(@NonNull MenuItem item) { int id = item.getItemId(); if (id == R.id.nav_fragment1) { getSupportFragmentManager().beginTransaction() .replace(R.id.contenu, new BlankFragment()) .commit(); } else if (id == R.id.nav_fragment2) { getSupportFragmentManager().beginTransaction() .replace(R.id.contenu, new BlankFragment2()) .commit(); } else if (id == R.id.nav_list) { getSupportFragmentManager().beginTransaction() .replace(R.id.contenu, new FragmentList()) .commit(); } DrawerLayout drawer = findViewById(R.id.drawer_layout); drawer.closeDrawer(GravityCompat.START); return true; }`

📋 Étape 6 – ListFragment
-------------------------

`public class FragmentList extends ListFragment { @Override public void onActivityCreated(Bundle savedInstanceState) { super.onActivityCreated(savedInstanceState); String[] items = { "Item 1","Item 2","Item 3","Item 4", "Item 5","Item 6","Item 7","Item 8", "Item 9","Item 10" }; ArrayAdapter<String> adapter = new ArrayAdapter<>( getActivity(), android.R.layout.simple_list_item_1, items ); setListAdapter(adapter); } }`

▶️ Étape 7 – Exécution
----------------------

*   Lancer l’application
*   Ouvrir le menu latéral
*   Choisir un fragment :

*   Fragment 1 → fond rose
*   Fragment 2 → fond bleu
*   Fragment List → liste

📚 Bilan
--------

Cet exercice permet de comprendre :

*   Le Navigation Drawer
*   La gestion des fragments
*   Le FragmentManager
*   La navigation dynamique

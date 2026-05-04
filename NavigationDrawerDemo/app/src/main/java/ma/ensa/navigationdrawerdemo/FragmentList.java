package ma.ensa.navigationdrawerdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class FragmentList extends ListFragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Données à afficher
        String[] items = {"Android Studio", "Java Language", "Fragment Transaction", "Navigation Drawer", "Layout XML"};

        // Adaptateur pour lier les données à la liste
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                items
        );

        setListAdapter(adapter);
    }

    // Petit bonus : action au clic sur un élément
    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        String selection = (String) getListAdapter().getItem(position);
        Toast.makeText(getActivity(), "Tu as sélectionné : " + selection, Toast.LENGTH_SHORT).show();
    }
}
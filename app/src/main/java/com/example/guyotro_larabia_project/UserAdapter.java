package com.example.guyotro_larabia_project;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.guyotro_larabia_project.db.User;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

    public UserAdapter(Context mContext, List<User> userlist) {
        super(mContext, R.layout.template_user, userlist);
    }

    /**
     * Remplit une ligne de la listView avec les informations du user associée
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Récupération de la multiplication
        final User user = getItem(position);

        // Charge le template XML
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.template_user, parent, false);

        // Récupération des objets graphiques dans le template
        TextView textViewNom= (TextView) rowView.findViewById(R.id.textViewNom);
        TextView textViewPrenom = (TextView) rowView.findViewById(R.id.textViewPrenom);

        //
        textViewNom.setText(user.getNom());
        textViewPrenom.setText(user.getPrenom());

        //
        return rowView;
    }
}

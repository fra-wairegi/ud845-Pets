package com.example.android.pets.data;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.pets.R;

/**
 * Created by franciswairegi on 10/19/17.
 */

public class PetCursorAdapter extends CursorAdapter {
    public PetCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView viewPetName = (TextView) view.findViewById(R.id.pet_name);
        TextView viewPetBreed = (TextView) view.findViewById(R.id.pet_breed);

        String petName = cursor.getString(cursor.getColumnIndexOrThrow(PetContract.PetEntry.COLUMN_PET_NAME));
        String petBreed = cursor.getString(cursor.getColumnIndexOrThrow(PetContract.PetEntry.COLUMN_PET_BREED));

        if (TextUtils.isEmpty(petBreed)){
            petBreed = context.getString(R.string.unknown_breed);
        }

        viewPetName.setText(petName);
        viewPetBreed.setText(petBreed);

    }
}

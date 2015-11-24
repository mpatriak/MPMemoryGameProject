package com.example.michal.mpmemorygameproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by Michal on 11/16/2015.
 */
public class NameEntryFragment extends DialogFragment
{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.name_entry_title)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}

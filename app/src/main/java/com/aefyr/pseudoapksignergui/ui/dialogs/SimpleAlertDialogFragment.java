package com.aefyr.pseudoapksignergui.ui.dialogs;

import android.app.Dialog;
import android.os.Bundle;

import com.aefyr.pseudoapksignergui.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class SimpleAlertDialogFragment extends DialogFragment {
    private static final String ARG_TITLE = "title";
    private static final String ARG_MESSAGE = "message";

    private CharSequence mTitle;
    private CharSequence mMessage;

    public static SimpleAlertDialogFragment newInstance(CharSequence title, CharSequence message) {
        SimpleAlertDialogFragment fragment = new SimpleAlertDialogFragment();
        Bundle args = new Bundle();
        args.putCharSequence(ARG_TITLE, title);
        args.putCharSequence(ARG_MESSAGE, message);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args == null) {
            return;
        }

        mTitle = args.getCharSequence(ARG_TITLE, getString(R.string.title_default));
        mMessage = args.getCharSequence(ARG_MESSAGE, getString(R.string.message_default));
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setTitle(mTitle)
                .setMessage(mMessage)
                .setPositiveButton(R.string.ok, null)
                .create();
    }
}
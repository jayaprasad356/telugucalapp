package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.ReminderActivity;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.model.Abdhikam;
import com.vibame.telugupanchangamcalendar.model.Reminder;

import java.util.ArrayList;

public class RemindAdapter extends RecyclerView.Adapter<RemindAdapter.ViewHolder> {
    Activity activity;
    ArrayList<Reminder> reminders;

    public RemindAdapter(Activity activity, ArrayList<Reminder> reminders) {
        this.reminders = reminders;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.reminder_layout, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.tvTitle.setText(reminders.get(position).getTitle());
        holder.tvDate.setText(reminders.get(position).getDate());
        holder.tvTime.setText(reminders.get(position).getTime());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = reminders.get(position).getId();
                String title = reminders.get(position).getTitle();



                showCustomDialog(id, title);


            }
        });


    }


    @Override
    public int getItemCount() {
        return reminders.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle,tvDate,tvTime;

        public ViewHolder(View itemView) {
            super(itemView);

            this.tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            this.tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            this.tvTime = (TextView) itemView.findViewById(R.id.tvTime);
        }
    }


    private void showCustomDialog( String id, String title) {
        EditText notesEditText;
        TextView okTextView;
        TextView cancelTextView;
        TextView deleteTextView;

        // Declare a variable for the AlertDialog
        Dialog customDialog;
        // Create a custom dialog
        customDialog = new Dialog(activity);
        customDialog.setContentView(R.layout.custom_dialog_list);

        notesEditText = customDialog.findViewById(R.id.notes);
        okTextView = customDialog.findViewById(R.id.Edit);
        cancelTextView = customDialog.findViewById(R.id.cancel);
        deleteTextView = customDialog.findViewById(R.id.iv_delete);



        notesEditText.setText(title);


        okTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseHelper databaseHelper = new DatabaseHelper(activity);

                String newTitle = notesEditText.getText().toString();
                databaseHelper.updateReminderTitle(id, newTitle);



                ((ReminderActivity)activity).loadReminder();

                customDialog.dismiss();


            }
        });


        deleteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String idToDelete = id;

                DatabaseHelper databaseHelper = new DatabaseHelper(activity);
                databaseHelper.deleteReminder(idToDelete);

                ((ReminderActivity)activity).loadReminder();


                customDialog.dismiss();

            }
        });





        cancelTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Cancel button click in the custom dialog
                // You can perform any actions you need here
                // Dismiss the custom dialog
                customDialog.dismiss();
            }
        });

        // Show the custom dialog
        customDialog.show();
    }

}

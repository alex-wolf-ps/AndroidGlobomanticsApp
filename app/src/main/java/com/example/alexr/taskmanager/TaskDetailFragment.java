package com.example.alexr.taskmanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alexr.taskmanager.Models.Task;
import com.example.alexr.taskmanager.Services.ServiceFactory;
import com.example.alexr.taskmanager.Services.TaskService;
import com.example.alexr.taskmanager.dummy.DummyContent;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a single Task detail screen.
 * This fragment is either contained in a {@link TaskListActivity}
 * in two-pane mode (on tablets) or a {@link TaskDetailActivity}
 * on handsets.
 */
public class TaskDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Task mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TaskDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.task_create, container, false);

        final Context context = getContext();

        Button updateTask = (Button) rootView.findViewById(R.id.task_create);
        final EditText taskName = (EditText) rootView.findViewById(R.id.task_name);
        final EditText taskNotes = (EditText) rootView.findViewById(R.id.task_notes);
        final CheckBox taskComplete = (CheckBox) rootView.findViewById(R.id.task_isComplete);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            Activity activity = this.getActivity();
            final CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);

            TaskService taskService = ServiceFactory.createService(TaskService.class);

            Call<Task> call = taskService.getTask(getArguments().getInt(ARG_ITEM_ID));
            call.enqueue(new Callback<Task>() {
                @Override
                public void onResponse(Call<Task> call, Response<Task> response) {
                    mItem = response.body();

                    taskName.setText(mItem.getName());
                    taskNotes.setText(mItem.getNotes());
                    taskComplete.setChecked(mItem.getIsComplete());

                    if (appBarLayout != null) {
                        appBarLayout.setTitle(mItem.getName());
                    }
                }

                @Override
                public void onFailure(Call<Task> call, Throwable t) {
                    String test = "";
                }
            });
        }

        updateTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaskService taskService = ServiceFactory.createService(TaskService.class);

                Task newTask = new Task();
                newTask.setId(getArguments().getInt(ARG_ITEM_ID));
                newTask.setName(taskName.getText().toString());
                newTask.setNotes(taskNotes.getText().toString());
                newTask.setIsComplete(taskComplete.isChecked());

                Call<Task> call = taskService.updateTask(newTask);
                call.enqueue(new Callback<Task>() {
                    @Override
                    public void onResponse(Call<Task> call, Response<Task> response) {
                        Intent intent = new Intent(context, TaskListActivity.class);
                        context.startActivity(intent);

                        Toast.makeText(context, "Task updated successfully!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Task> call, Throwable t) {
                        Toast.makeText(context, "An error occurred updating task.", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        return rootView;
    }
}

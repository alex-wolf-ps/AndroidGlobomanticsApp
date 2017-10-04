package com.example.alexr.taskmanager;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alexr.taskmanager.Models.Task;
import com.example.alexr.taskmanager.Services.ServiceFactory;
import com.example.alexr.taskmanager.Services.TaskService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a single Task detail screen.
 * This fragment is either contained in a {@link TaskListActivity}
 * in two-pane mode (on tablets) or a {@link TaskDetailActivity}
 * on handsets.
 */
public class TaskCreateFragment extends Fragment {
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
    public TaskCreateFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.task_create, container, false);

//        if (getArguments().containsKey(ARG_ITEM_ID)) {
//            // Load the dummy content specified by the fragment
//            // arguments. In a real-world scenario, use a Loader
//            // to load content from a content provider.
//            Activity activity = this.getActivity();
//            final CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
//
//            TaskService taskService = ServiceFactory.createService(TaskService.class);
//
//            Call<Task> call = taskService.getTask(getArguments().getInt(ARG_ITEM_ID));
//            call.enqueue(new Callback<Task>() {
//                @Override
//                public void onResponse(Call<Task> call, Response<Task> response) {
//                    mItem = response.body();
//
//                    if (appBarLayout != null) {
//                        appBarLayout.setTitle(mItem.getName());
//                    }
//
//
//                    // Show the dummy content as text in a TextView.
//                    if (mItem != null) {
//                        ((TextView) rootView.findViewById(R.id.task_detail)).setText(mItem.getNotes());
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<Task> call, Throwable t) {
//                    String test = "";
//                }
//            });
//        }

        return rootView;
    }
}

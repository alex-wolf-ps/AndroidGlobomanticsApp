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
import android.widget.EditText;
import android.widget.Toast;

import com.example.alexr.taskmanager.Models.Idea;
import com.example.alexr.taskmanager.Services.ServiceFactory;
import com.example.alexr.taskmanager.Services.IdeaService;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a single Task detail screen.
 * This fragment is either contained in a {@link IdeaListActivity}
 * in two-pane mode (on tablets) or a {@link IdeaDetailActivity}
 * on handsets.
 */
public class IdeaDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Idea mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public IdeaDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.idea_detail, container, false);

        final Context context = getContext();

        Button updateIdea = (Button) rootView.findViewById(R.id.idea_update);
        Button deleteIdea = (Button) rootView.findViewById(R.id.idea_delete);

        final EditText ideaName = (EditText) rootView.findViewById(R.id.idea_name);
        final EditText ideaDescription = (EditText) rootView.findViewById(R.id.idea_description);
        final EditText ideaStatus = (EditText) rootView.findViewById(R.id.idea_status);
        final EditText ideaOwner = (EditText) rootView.findViewById(R.id.idea_owner);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            Activity activity = this.getActivity();
            final CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);

            IdeaService ideaService = ServiceFactory.createService(IdeaService.class);

            Call<Idea> call = ideaService.getIdea(getArguments().getInt(ARG_ITEM_ID));
            call.enqueue(new Callback<Idea>() {
                @Override
                public void onResponse(Call<Idea> call, Response<Idea> response) {
                    mItem = response.body();

                    ideaName.setText(mItem.getName());
                    ideaDescription.setText(mItem.getDescription());
                    ideaStatus.setText(mItem.getStatus());
                    ideaOwner.setText(mItem.getOwner());

                    if (appBarLayout != null) {
                        appBarLayout.setTitle(mItem.getName());
                    }
                }

                @Override
                public void onFailure(Call<Idea> call, Throwable t) {
                    String test = "";
                }
            });
        }

        updateIdea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IdeaService ideaService = ServiceFactory.createService(IdeaService.class);

                Idea newIdea = new Idea();
                newIdea.setId(getArguments().getInt(ARG_ITEM_ID));
                newIdea.setName(ideaName.getText().toString());
                newIdea.setDescription(ideaDescription.getText().toString());
                newIdea.setStatus(ideaStatus.getText().toString());
                newIdea.setOwner(ideaOwner.getText().toString());

                Call<Idea> call = ideaService.updateIdea(newIdea);
                call.enqueue(new Callback<Idea>() {
                    @Override
                    public void onResponse(Call<Idea> call, Response<Idea> response) {
                        Intent intent = new Intent(context, IdeaListActivity.class);
                        context.startActivity(intent);

                        Toast.makeText(context, "Idea updated successfully!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Idea> call, Throwable t) {
                        Toast.makeText(context, "An error occurred updating the idea.", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        deleteIdea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IdeaService ideaService = ServiceFactory.createService(IdeaService.class);

                Call<Idea> call = ideaService.deleteIdea(getArguments().getInt(ARG_ITEM_ID));
                call.enqueue(new Callback<Idea>() {
                    @Override
                    public void onResponse(Call<Idea> call, Response<Idea> response) {
                        Intent intent = new Intent(context, IdeaListActivity.class);
                        context.startActivity(intent);

                        Toast.makeText(context, "Idea deleted!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Idea> call, Throwable t) {
                        Toast.makeText(context, "An error occurred deleting the idea.", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        return rootView;
    }
}

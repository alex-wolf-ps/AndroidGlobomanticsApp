package com.example.alexr.ideamanager.helpers;

import com.example.alexr.ideamanager.models.Idea;
import java.util.ArrayList;
import java.util.List;

public class SampleContent {

    public static final List<Idea> IDEAS = new ArrayList<Idea>();

    private static int COUNT = 5;

    static {
        // Add some sample items.
        Idea newIdea1 = new Idea();
        newIdea1.setId(1);
        newIdea1.setName("New issue tracking system");
        newIdea1.setStatus("Idea Stage");
        newIdea1.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce accumsan quis justo quis hendrerit. Curabitur a ante neque. Fusce nec mauris sodales, auctor sem at, luctus eros. Praesent aliquam nibh neque. Duis ut suscipit justo, id consectetur orci. Curabitur ultricies nunc eu enim dignissim, sed laoreet odio blandit.");
        newIdea1.setOwner("Bob");
        IDEAS.add(newIdea1);

        Idea newIdea2 = new Idea();
        newIdea2.setId(2);
        newIdea2.setName("Revamp Build Scripts");
        newIdea2.setStatus("Started");
        newIdea2.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce accumsan quis justo quis hendrerit. Curabitur a ante neque. Fusce nec mauris sodales, auctor sem at, luctus eros. Praesent aliquam nibh neque. Duis ut suscipit justo, id consectetur orci. Curabitur ultricies nunc eu enim dignissim, sed laoreet odio blandit.");
        newIdea2.setOwner("Jim");
        IDEAS.add(newIdea2);

        Idea newIdea3 = new Idea();
        newIdea3.setId(3);
        newIdea3.setName("New phone triage");
        newIdea3.setStatus("Mind Mapped");
        newIdea3.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce accumsan quis justo quis hendrerit. Curabitur a ante neque. Fusce nec mauris sodales, auctor sem at, luctus eros. Praesent aliquam nibh neque. Duis ut suscipit justo, id consectetur orci. Curabitur ultricies nunc eu enim dignissim, sed laoreet odio blandit.");
        newIdea3.setOwner("Phil");
        IDEAS.add(newIdea3);

        Idea newIdea4 = new Idea();
        newIdea4.setId(4);
        newIdea4.setName("Implement containerization");
        newIdea4.setStatus("POC");
        newIdea4.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce accumsan quis justo quis hendrerit. Curabitur a ante neque. Fusce nec mauris sodales, auctor sem at, luctus eros. Praesent aliquam nibh neque. Duis ut suscipit justo, id consectetur orci. Curabitur ultricies nunc eu enim dignissim, sed laoreet odio blandit.");
        newIdea4.setOwner("Joel");
        IDEAS.add(newIdea4);

        Idea newIdea5 = new Idea();
        newIdea5.setId(5);
        newIdea5.setName("Migrate to oauth accounts");
        newIdea5.setStatus("Exploratory");
        newIdea5.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce accumsan quis justo quis hendrerit. Curabitur a ante neque. Fusce nec mauris sodales, auctor sem at, luctus eros. Praesent aliquam nibh neque. Duis ut suscipit justo, id consectetur orci. Curabitur ultricies nunc eu enim dignissim, sed laoreet odio blandit.");
        newIdea5.setOwner("Jake");
        IDEAS.add(newIdea5);

    }

    public static void createIdea(Idea item) {
        COUNT += 1;
        item.setId(COUNT);
        IDEAS.add(item);
    }

    public static Idea getIdeaById(int id){
        for(int i = 0; i < IDEAS.size(); i++){
            if(IDEAS.get(i).getId() == id){
                return IDEAS.get(i);
            }
        }

        return null;
    }

    public static void deleteIdea(int id){
        Idea ideaToRemove = null;

        for(int i = 0; i < IDEAS.size(); i++){
            if(IDEAS.get(i).getId() == id){
                ideaToRemove = IDEAS.get(i);
            }
        }

        if(ideaToRemove != null){
            IDEAS.remove(ideaToRemove);
        }
    }

    public static void updateIdea(Idea idea){
        for(int i = 0; i < IDEAS.size(); i++){
            if(IDEAS.get(i).getId() == idea.getId()){
                Idea ideaToUpdate = IDEAS.get(i);

                ideaToUpdate.setName(idea.getName());
                ideaToUpdate.setDescription(idea.getDescription());
                ideaToUpdate.setOwner(idea.getOwner());
                ideaToUpdate.setStatus(idea.getStatus());
            }
        }
    }
}

package com.example.alexr.taskmanager.helpers;

import com.example.alexr.taskmanager.models.Idea;

import java.util.ArrayList;
import java.util.List;

public class DummyContent {

    public static final List<Idea> ITEMS = new ArrayList<Idea>();

    private static int COUNT = 5;

    static {
        // Add some sample items.
        Idea newIdea1 = new Idea();
        newIdea1.setId(1);
        newIdea1.setName("New issue tracking system");
        newIdea1.setStatus("Idea Stage");
        newIdea1.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce accumsan quis justo quis hendrerit. Curabitur a ante neque. Fusce nec mauris sodales, auctor sem at, luctus eros. Praesent aliquam nibh neque. Duis ut suscipit justo, id consectetur orci. Curabitur ultricies nunc eu enim dignissim, sed laoreet odio blandit.");
        newIdea1.setOwner("Bob");
        ITEMS.add(newIdea1);

        Idea newIdea2 = new Idea();
        newIdea2.setId(2);
        newIdea2.setName("Revamp Build Scripts");
        newIdea2.setStatus("Started");
        newIdea2.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce accumsan quis justo quis hendrerit. Curabitur a ante neque. Fusce nec mauris sodales, auctor sem at, luctus eros. Praesent aliquam nibh neque. Duis ut suscipit justo, id consectetur orci. Curabitur ultricies nunc eu enim dignissim, sed laoreet odio blandit.");
        newIdea2.setOwner("Jim");
        ITEMS.add(newIdea2);

        Idea newIdea3 = new Idea();
        newIdea3.setId(3);
        newIdea3.setName("New phone triage");
        newIdea3.setStatus("Mind Mapped");
        newIdea3.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce accumsan quis justo quis hendrerit. Curabitur a ante neque. Fusce nec mauris sodales, auctor sem at, luctus eros. Praesent aliquam nibh neque. Duis ut suscipit justo, id consectetur orci. Curabitur ultricies nunc eu enim dignissim, sed laoreet odio blandit.");
        newIdea3.setOwner("Phil");
        ITEMS.add(newIdea3);

        Idea newIdea4 = new Idea();
        newIdea4.setId(4);
        newIdea4.setName("Implement containerization");
        newIdea4.setStatus("POC");
        newIdea4.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce accumsan quis justo quis hendrerit. Curabitur a ante neque. Fusce nec mauris sodales, auctor sem at, luctus eros. Praesent aliquam nibh neque. Duis ut suscipit justo, id consectetur orci. Curabitur ultricies nunc eu enim dignissim, sed laoreet odio blandit.");
        newIdea4.setOwner("Joel");
        ITEMS.add(newIdea4);

        Idea newIdea5 = new Idea();
        newIdea5.setId(5);
        newIdea5.setName("Migrate to oauth accounts");
        newIdea5.setStatus("Exploratory");
        newIdea5.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce accumsan quis justo quis hendrerit. Curabitur a ante neque. Fusce nec mauris sodales, auctor sem at, luctus eros. Praesent aliquam nibh neque. Duis ut suscipit justo, id consectetur orci. Curabitur ultricies nunc eu enim dignissim, sed laoreet odio blandit.");
        newIdea5.setOwner("Jake");
        ITEMS.add(newIdea5);

    }

    public static void createIdea(Idea item) {
        item.setId(COUNT);
        ITEMS.add(item);
        COUNT += 1;
    }

    public static Idea getIdeaById(int id){
        for(int i = 0; i < ITEMS.size(); i++){
            if(ITEMS.get(i).getId() == id){
                return ITEMS.get(i);
            }
        }

        return null;
    }

    public static void deleteIdea(int id){
        for(int i = 0; i < ITEMS.size(); i++){
            if(ITEMS.get(i).getId() == id){
                ITEMS.remove(id);
            }
        }
    }

    public static void updateIdea(Idea idea){
        for(int i = 0; i < ITEMS.size(); i++){
            if(ITEMS.get(i).getId() == idea.getId()){
                Idea ideaToUpdate = ITEMS.get(i);

                ideaToUpdate.setName(idea.getName());
                ideaToUpdate.setDescription(idea.getDescription());
                ideaToUpdate.setOwner(idea.getOwner());
                ideaToUpdate.setStatus(idea.getStatus());
            }
        }
    }
}

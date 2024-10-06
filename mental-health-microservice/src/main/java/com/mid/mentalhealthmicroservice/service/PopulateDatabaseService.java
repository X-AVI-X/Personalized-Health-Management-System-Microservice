package com.mid.mentalhealthmicroservice.service;

import com.mid.mentalhealthmicroservice.entity.CategoryBasedExerciseEntity;
import com.mid.mentalhealthmicroservice.entity.MentalExerciseEntity;
import com.mid.mentalhealthmicroservice.repository.CategoryBasedExerciseRepository;
import com.mid.mentalhealthmicroservice.repository.MentalExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PopulateDatabaseService {
    @Autowired
    private CategoryBasedExerciseRepository categoryBasedExerciseRepository;

    @Autowired
    private MentalExerciseRepository mentalExerciseRepository;

    public Boolean populateExercise(){
        if (mentalExerciseRepository.existsById(1)){
            return false;
        }
        MentalExerciseEntity mentalExercise1=new MentalExerciseEntity();
        mentalExercise1.setExercise("Mindfulness Meditation");
        mentalExercise1.setDescription("Find a quiet and comfortable place to sit or lie down.Close your eyes and focus your attention on your breath. Breathe naturally and pay close attention to the sensation of each breath.");
        mentalExerciseRepository.save(mentalExercise1);

        MentalExerciseEntity mentalExercise2=new MentalExerciseEntity();
        mentalExercise2.setExercise("Deep Breathing Exercises");
        mentalExercise2.setDescription("Practice deep breathing to activate the body's relaxation response. One technique is the 4-7-8 breath, where you inhale for a count of 4, hold for 7, and exhale for 8.");
        mentalExerciseRepository.save(mentalExercise2);

        MentalExerciseEntity mentalExercise3=new MentalExerciseEntity();
        mentalExercise3.setExercise("Progressive Muscle Relaxation");
        mentalExercise3.setDescription("To practice PMR, lie down in a comfortable position and start at your toes, progressively working your way up to your head. Tense each muscle group for a few seconds, then release and relax.");
        mentalExerciseRepository.save(mentalExercise3);

        MentalExerciseEntity mentalExercise4=new MentalExerciseEntity();
        mentalExercise4.setExercise("Yoga");
        mentalExercise4.setDescription("Yoga is a practice that combines physical postures, breath control, meditation, and ethical principles to promote physical, mental, and spiritual well-being.");
        mentalExerciseRepository.save(mentalExercise4);

        MentalExerciseEntity mentalExercise5=new MentalExerciseEntity();
        mentalExercise5.setExercise("Meditation");
        mentalExercise5.setDescription("Meditation is a practice that involves focusing your mind on a particular object, thought, or activity to achieve a state of mental clarity, relaxation, and heightened awareness. ");
        mentalExerciseRepository.save(mentalExercise5);

        MentalExerciseEntity mentalExercise6=new MentalExerciseEntity();
        mentalExercise6.setExercise("Cognitive-Behavioral Therapy");
        mentalExercise6.setDescription("It includes various techniques and exercises, such as cognitive restructuring and stimulus control");
        mentalExerciseRepository.save(mentalExercise6);

        MentalExerciseEntity mentalExercise7=new MentalExerciseEntity();
        mentalExercise7.setExercise("Visualization");
        mentalExercise7.setDescription("Close your eyes and visualize a calming and safe place. Imagine yourself in this place, engaging all your senses to make it as vivid as possible. Spend a few minutes here.");
        mentalExerciseRepository.save(mentalExercise7);
        return true;

    }
    public Boolean populateCategory(){
        if (categoryBasedExerciseRepository.existsById(1)){
            return false;
        }
        List<MentalExerciseEntity> mentalExerciseEntitiesList=new ArrayList<>();
        CategoryBasedExerciseEntity categoryBasedExerciseEntity1=new CategoryBasedExerciseEntity();
        categoryBasedExerciseEntity1.setCategory("Normal");
        categoryBasedExerciseEntity1.setDuration("5-10 minutes");
        categoryBasedExerciseEntity1.setRecommendation("1.Maintain regular sleep routines \n 2.Follow suggested Mental health exercises");
        mentalExerciseEntitiesList.add(mentalExerciseRepository.findById(1).get());
        categoryBasedExerciseEntity1.setMentalExerciseEntities(mentalExerciseEntitiesList);
        categoryBasedExerciseRepository.save(categoryBasedExerciseEntity1);

        CategoryBasedExerciseEntity categoryBasedExerciseEntity2=new CategoryBasedExerciseEntity();
        categoryBasedExerciseEntity2.setCategory("Anxious");
        categoryBasedExerciseEntity2.setDuration("10-15 minutes");
        categoryBasedExerciseEntity2.setRecommendation("1.Make sure to get 6-8 hours sleep \n 2.Limit caffeine and alcohol\n 3.Follow suggested Mental health exercises");
        mentalExerciseEntitiesList=new ArrayList<>();
        mentalExerciseEntitiesList.add(mentalExerciseRepository.findById(2).get());
        mentalExerciseEntitiesList.add(mentalExerciseRepository.findById(4).get());
        categoryBasedExerciseEntity2.setMentalExerciseEntities(mentalExerciseEntitiesList);
        categoryBasedExerciseRepository.save(categoryBasedExerciseEntity2);

        CategoryBasedExerciseEntity categoryBasedExerciseEntity3=new CategoryBasedExerciseEntity();
        categoryBasedExerciseEntity3.setCategory("Stressed");
        categoryBasedExerciseEntity3.setDuration("10-15 minutes");
        categoryBasedExerciseEntity3.setRecommendation("1.Make sure to get 6-8 hours sleep \n 2.Maintain a stress journal\n 3.Follow suggested Mental health exercises");
        mentalExerciseEntitiesList=new ArrayList<>();
        mentalExerciseEntitiesList.add(mentalExerciseRepository.findById(2).get());
        mentalExerciseEntitiesList.add(mentalExerciseRepository.findById(5).get());
        categoryBasedExerciseEntity3.setMentalExerciseEntities(mentalExerciseEntitiesList);
        categoryBasedExerciseRepository.save(categoryBasedExerciseEntity3);

        CategoryBasedExerciseEntity categoryBasedExerciseEntity4=new CategoryBasedExerciseEntity();
        categoryBasedExerciseEntity4.setCategory("Insomniac");
        categoryBasedExerciseEntity4.setDuration("10-15 minutes");
        categoryBasedExerciseEntity4.setRecommendation("1.Go to bed and and wake up at the same time everyday \n 2.Exercise regularly during the day\n 3.Follow suggested Mental health exercises");
        mentalExerciseEntitiesList=new ArrayList<>();
        mentalExerciseEntitiesList.add(mentalExerciseRepository.findById(1).get());
        mentalExerciseEntitiesList.add(mentalExerciseRepository.findById(3).get());
        categoryBasedExerciseEntity4.setMentalExerciseEntities(mentalExerciseEntitiesList);
        categoryBasedExerciseRepository.save(categoryBasedExerciseEntity4);

        CategoryBasedExerciseEntity categoryBasedExerciseEntity5=new CategoryBasedExerciseEntity();
        categoryBasedExerciseEntity5.setCategory("Turbulent");
        categoryBasedExerciseEntity5.setDuration("15-20 minutes");
        categoryBasedExerciseEntity5.setRecommendation("1.Make sure to get 6-8 hours sleep \n 2.Give self affirmation everyday\n 3.Follow suggested Mental health exercises");
        mentalExerciseEntitiesList=new ArrayList<>();
        mentalExerciseEntitiesList.add(mentalExerciseRepository.findById(1).get());
        mentalExerciseEntitiesList.add(mentalExerciseRepository.findById(2).get());
        mentalExerciseEntitiesList.add(mentalExerciseRepository.findById(4).get());
        categoryBasedExerciseEntity5.setMentalExerciseEntities(mentalExerciseEntitiesList);
        categoryBasedExerciseRepository.save(categoryBasedExerciseEntity5);

        CategoryBasedExerciseEntity categoryBasedExerciseEntity6=new CategoryBasedExerciseEntity();
        categoryBasedExerciseEntity6.setCategory("Stressinsomnia");
        categoryBasedExerciseEntity6.setDuration("15-20 minutes");
        categoryBasedExerciseEntity6.setRecommendation("1.Go to bed and and wake up at the same time everyday \n 2.Maintain a journal \n 3.Follow suggested Mental health exercises");
        mentalExerciseEntitiesList=new ArrayList<>();
        mentalExerciseEntitiesList.add(mentalExerciseRepository.findById(1).get());
        mentalExerciseEntitiesList.add(mentalExerciseRepository.findById(3).get());
        categoryBasedExerciseEntity6.setMentalExerciseEntities(mentalExerciseEntitiesList);
        categoryBasedExerciseRepository.save(categoryBasedExerciseEntity6);

        CategoryBasedExerciseEntity categoryBasedExerciseEntity7=new CategoryBasedExerciseEntity();
        categoryBasedExerciseEntity7.setCategory("Anxiosomnia");
        categoryBasedExerciseEntity7.setDuration("15-20 minutes");
        categoryBasedExerciseEntity7.setRecommendation("1.Go to bed and and wake up at the same time everyday \n 2.Limit caffeine and alcohol\n 3.Follow suggested Mental health exercises");
        mentalExerciseEntitiesList=new ArrayList<>();
        mentalExerciseEntitiesList.add(mentalExerciseRepository.findById(1).get());
        mentalExerciseEntitiesList.add(mentalExerciseRepository.findById(6).get());
        categoryBasedExerciseEntity7.setMentalExerciseEntities(mentalExerciseEntitiesList);
        categoryBasedExerciseRepository.save(categoryBasedExerciseEntity7);

        CategoryBasedExerciseEntity categoryBasedExerciseEntity8=new CategoryBasedExerciseEntity();
        categoryBasedExerciseEntity8.setCategory("Severe");
        categoryBasedExerciseEntity8.setDuration("20-25 minutes");
        categoryBasedExerciseEntity8.setRecommendation("1.Go to bed and and wake up at the same time everyday \n 2.Limit caffeine and alcohol\n 3.Give self affirmation everyday\n 4.Follow suggested Mental health exercises");
        mentalExerciseEntitiesList=new ArrayList<>();
        mentalExerciseEntitiesList.add(mentalExerciseRepository.findById(1).get());
        mentalExerciseEntitiesList.add(mentalExerciseRepository.findById(2).get());
        mentalExerciseEntitiesList.add(mentalExerciseRepository.findById(7).get());
        categoryBasedExerciseEntity8.setMentalExerciseEntities(mentalExerciseEntitiesList);
        categoryBasedExerciseRepository.save(categoryBasedExerciseEntity8);
        return true;
    }
}

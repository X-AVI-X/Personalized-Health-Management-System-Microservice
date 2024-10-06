package com.mid.mentalhealthmicroservice.service;

import com.mid.mentalhealthmicroservice.dto.*;
import com.mid.mentalhealthmicroservice.entity.CategoryBasedExerciseEntity;
import com.mid.mentalhealthmicroservice.entity.MentalExerciseEntity;
import com.mid.mentalhealthmicroservice.entity.UserInformationEntity;
import com.mid.mentalhealthmicroservice.exception.ExerciseNotFound;
import com.mid.mentalhealthmicroservice.exception.UserNotFound;
import com.mid.mentalhealthmicroservice.networkmanager.UserFeignClient;
import com.mid.mentalhealthmicroservice.repository.CategoryBasedExerciseRepository;
import com.mid.mentalhealthmicroservice.repository.MentalExerciseRepository;
import com.mid.mentalhealthmicroservice.repository.UserInformationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MentalHealthService {
    @Autowired
    private MentalExerciseRepository mentalExerciseRepository;
    @Autowired
    private CategoryBasedExerciseRepository categoryBasedExerciseRepository;
    @Autowired
    private UserInformationRepository userInformationRepository;
    @Autowired
    private UserFeignClient userFeignClient;

    public MentalExerciseDTO createMentalExercise(MentalExerciseDTO mentalExerciseDTO){
        MentalExerciseEntity mentalExercise=new MentalExerciseEntity();
        mentalExercise.setExercise(mentalExerciseDTO.getExercise());
        mentalExercise.setDescription(mentalExerciseDTO.getDescription());
        return new ModelMapper().map(mentalExerciseRepository.save(mentalExercise),MentalExerciseDTO.class);
    }
    public List<MentalExerciseDTO> getAllMentalExercise(){
        List<MentalExerciseDTO> mentalExerciseDTOList=new ArrayList<>();
        for(MentalExerciseEntity mentalExerciseEntity:mentalExerciseRepository.findAll()){
            mentalExerciseDTOList.add(new ModelMapper().map(mentalExerciseEntity,MentalExerciseDTO.class));
        }
        return mentalExerciseDTOList.stream()
                .sorted(Comparator.comparing(MentalExerciseDTO::getExercise))
                .collect(Collectors.toList());
    }
    public MentalExerciseDTO getMentalExercise (String exercise) throws ExerciseNotFound {
        if(mentalExerciseRepository.existsByExercise(exercise)){
            return new ModelMapper().map(mentalExerciseRepository.findByExercise(exercise).orElseThrow(() -> new NullPointerException("No exercise")),MentalExerciseDTO.class);
        }
        throw new ExerciseNotFound();
    }
    public CategoryBasedExerciseDTO getUserBasedMentalExercise() throws UserNotFound{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        String userId=userFeignClient.getUserByEmail(userEmail).getId();
        if(userInformationRepository.existsByUserId(userId)) {
            CategoryBasedExerciseEntity categoryBasedExerciseEntity=categoryBasedExerciseRepository.findByCategory(userInformationRepository.findByUserId(userId).orElseThrow(() -> new NullPointerException()).getMentalHealthCategory()).orElseThrow(() -> new NullPointerException());
            CategoryBasedExerciseDTO categoryBasedExerciseDTO=new ModelMapper().map(categoryBasedExerciseEntity,CategoryBasedExerciseDTO.class);

            List<MentalExerciseDTO> mentalExerciseDTOList=new ArrayList<>();
            for(MentalExerciseEntity mentalExerciseEntity:categoryBasedExerciseEntity.getMentalExerciseEntities()){
                mentalExerciseDTOList.add(new ModelMapper().map(mentalExerciseEntity,MentalExerciseDTO.class));
            }
            categoryBasedExerciseDTO.setExercises(mentalExerciseDTOList);
            return categoryBasedExerciseDTO;
        }
        throw new UserNotFound();
    }
    public UserDto getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        return userFeignClient.getUserByEmail(userEmail);
    }
    public MentalHealthRecommendationDTO getUserBasedRecommendation() throws UserNotFound {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        String userId=userFeignClient.getUserByEmail(userEmail).getId();
        if(userInformationRepository.existsByUserId(userId)) {
            CategoryBasedExerciseEntity categoryBasedExerciseEntity=categoryBasedExerciseRepository.findByCategory(userInformationRepository.findByUserId(userId).orElseThrow(() -> new NullPointerException()).getMentalHealthCategory()).orElseThrow(() -> new NullPointerException());
            MentalHealthRecommendationDTO mentalHealthRecommendationDTO=new ModelMapper().map(categoryBasedExerciseEntity,MentalHealthRecommendationDTO.class);
            return mentalHealthRecommendationDTO;
        }
        throw new UserNotFound();
    }

    public Boolean findMentalHealth(QuestionsDTO questionsDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        String userId=userFeignClient.getUserByEmail(userEmail).getId();
        if(userInformationRepository.existsByUserId(userId)){
            return false;
        }
        else{
            UserInformationEntity userInformationEntity=new UserInformationEntity();
            userInformationEntity.setUserId(userId);

            if(questionsDTO.getSleep()==0 && questionsDTO.getStress()==0 && questionsDTO.getAnxiety()==0){
                userInformationEntity.setMentalHealthCategory("Normal");
                userInformationRepository.save(userInformationEntity);
            }
            else if (questionsDTO.getSleep()==0 && questionsDTO.getStress()==0 && questionsDTO.getAnxiety()==1) {
                userInformationEntity.setMentalHealthCategory("Anxious");
                userInformationRepository.save(userInformationEntity);
            }
            else if (questionsDTO.getSleep()==0 && questionsDTO.getStress()==1 && questionsDTO.getAnxiety()==0) {
                userInformationEntity.setMentalHealthCategory("Stressed");
                userInformationRepository.save(userInformationEntity);
            }
            else if (questionsDTO.getSleep()==1 && questionsDTO.getStress()==0 && questionsDTO.getAnxiety()==0) {
                userInformationEntity.setMentalHealthCategory("Insomniac");
                userInformationRepository.save(userInformationEntity);
            }
            else if (questionsDTO.getSleep()==0 && questionsDTO.getStress()==1 && questionsDTO.getAnxiety()==1) {
                userInformationEntity.setMentalHealthCategory("Turbulent");
                userInformationRepository.save(userInformationEntity);
            }
            else if (questionsDTO.getSleep()==1 && questionsDTO.getStress()==1 && questionsDTO.getAnxiety()==0) {
                userInformationEntity.setMentalHealthCategory("Stressinsomnia");
                userInformationRepository.save(userInformationEntity);
            }

            else if (questionsDTO.getSleep()==1 && questionsDTO.getStress()==0 && questionsDTO.getAnxiety()==1) {
                userInformationEntity.setMentalHealthCategory("Anxiosomnia");
                userInformationRepository.save(userInformationEntity);
            }

            else if (questionsDTO.getSleep()==1 && questionsDTO.getStress()==1 && questionsDTO.getAnxiety()==1) {
                userInformationEntity.setMentalHealthCategory("Severe");
                userInformationRepository.save(userInformationEntity);
            }
            else {
                return false;
            }
            return true;
        }

    }



}

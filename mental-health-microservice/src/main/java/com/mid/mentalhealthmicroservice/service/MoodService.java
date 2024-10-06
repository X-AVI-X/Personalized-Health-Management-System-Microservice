package com.mid.mentalhealthmicroservice.service;

import com.mid.mentalhealthmicroservice.dto.MentalExerciseDTO;
import com.mid.mentalhealthmicroservice.dto.MoodDTO;
import com.mid.mentalhealthmicroservice.dto.MoodDateDTO;
import com.mid.mentalhealthmicroservice.entity.MentalExerciseEntity;
import com.mid.mentalhealthmicroservice.entity.MoodEntity;
import com.mid.mentalhealthmicroservice.networkmanager.UserFeignClient;
import com.mid.mentalhealthmicroservice.repository.MoodRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MoodService {
    @Autowired
    private MoodRepository moodRepository;

    @Autowired
    private UserFeignClient userFeignClient;

    public MoodDTO insertMood(MoodDTO moodDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        String userId =userFeignClient.getUserByEmail(userEmail).getId();
        MoodEntity moodEntity=new MoodEntity();
        moodEntity.setUserId(userId);
        moodEntity.setMood(moodDTO.getMood());
        moodEntity.setPresentDate(LocalDate.now());
        return new ModelMapper().map(moodRepository.save(moodEntity),MoodDTO.class);
    }

    public List<MoodDateDTO> trackMood(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        String userId =userFeignClient.getUserByEmail(userEmail).getId();

        List<MoodDateDTO> moodDTOList=new ArrayList<>();
        for(MoodEntity moodEntity:moodRepository.findAllByUserId(userId)){
            moodDTOList.add(new ModelMapper().map(moodEntity,MoodDateDTO.class));
        }
        return moodDTOList;
    }
}

package com.upgrad.patterns.Service;

import com.upgrad.patterns.Interfaces.IndianDiseaseStat;
import com.upgrad.patterns.Constants.SourceType;
import com.upgrad.patterns.Strategies.DiseaseShStrategy;
import com.upgrad.patterns.Strategies.JohnHopkinsStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndiaDiseaseStatFactory {
    private final IndianDiseaseStat diseaseShStrategy;
    private final IndianDiseaseStat johnHopkinsStrategy;

    @Autowired
    public IndiaDiseaseStatFactory(DiseaseShStrategy diseaseShStrategy, JohnHopkinsStrategy johnHopkinsStrategy) {
        this.diseaseShStrategy = diseaseShStrategy;
        this.johnHopkinsStrategy = johnHopkinsStrategy;
    }
    
    //create a method named GetInstance with return type as IndianDiseaseStat and parameter of type sourceType
    public IndianDiseaseStat GetInstance(SourceType sourceType) {
        //create a conditional statement
        switch (sourceType) {
            //if the sourceType is DiseaseSh
            //return diseaseShStrategy
            case DiseaseSh:
                return this.diseaseShStrategy;
            //if the sourceType is JohnHopkins
            //return johnHopkinsStrategy
            case JohnHopkins:
                return this.johnHopkinsStrategy;
            //create a message for invalid disease strategy/sourceType
            //throw the message as an Illegal argument exception
            default:
                throw new IllegalArgumentException("invalid disease strategy/sourceType");
        }
    }

}

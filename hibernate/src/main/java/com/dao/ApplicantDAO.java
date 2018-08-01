package com.dao;

import java.util.List;

import com.entity.Applicant;
import com.model.ApplicantInfo;
 
public interface ApplicantDAO {
 
    public Applicant findApplicant(String id);
 
    public List<ApplicantInfo> listApplicantInfos();
 
    public void saveApplicant(ApplicantInfo applicantInfo);
    
    public void updateApplicantInfo(ApplicantInfo applicantInfo);
 
    public ApplicantInfo findApplicantInfo(String id);
 
    public void deleteApplicant(String id);

	public void addStaff(ApplicantInfo applicantInfo);
    
}